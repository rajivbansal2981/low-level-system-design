package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.parkinglot.enums.ParkingSlotType;
import com.parkinglot.models.Address;
import com.parkinglot.models.ParkingFloor;
import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSlot;

@SpringBootApplication
@ComponentScan(basePackages = "com.parkinglot")
public class ParkingLotApplication {

	@Bean
	public ParkingLot parkingLot() {
		String nameOfParkingLot = "Pintosss Parking Lot";
		Address address = Address.builder().city("Bangalore").country("India").state("KA").build();
		Map<ParkingSlotType, Map<String, ParkingSlot>> allSlots = new HashMap();
		Map<String, ParkingSlot> compactSlot = new HashMap();
		compactSlot.put("C1", new ParkingSlot("C1", ParkingSlotType.Compact));
		compactSlot.put("C2", new ParkingSlot("C2", ParkingSlotType.Compact));
		compactSlot.put("C3", new ParkingSlot("C3", ParkingSlotType.Compact));
		allSlots.put(ParkingSlotType.Compact, compactSlot);

		Map<String, ParkingSlot> largeSlot = new HashMap();
		largeSlot.put("L1", new ParkingSlot("L1", ParkingSlotType.Large));
		largeSlot.put("L2", new ParkingSlot("L2", ParkingSlotType.Large));
		largeSlot.put("L3", new ParkingSlot("L3", ParkingSlotType.Large));
		allSlots.put(ParkingSlotType.Large, largeSlot);
		ParkingFloor parkingFloor = new ParkingFloor("1", allSlots);
		List<ParkingFloor> parkingFloors = new ArrayList();
		parkingFloors.add(parkingFloor);
		ParkingLot parkingLot = ParkingLot.getInstance(nameOfParkingLot, address, parkingFloors);
		return parkingLot;
	}

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(ParkingLotApplication.class, args);

	}
}
