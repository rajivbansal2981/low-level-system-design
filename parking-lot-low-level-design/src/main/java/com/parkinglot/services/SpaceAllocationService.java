package com.parkinglot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkinglot.models.ParkingFloor;
import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSlot;
import com.parkinglot.models.Vehicle;

@Component
public class SpaceAllocationService {
	
	@Autowired
	private ParkingLot parkingLot;

	public SpaceAllocationService(ParkingLot parkingLot) {
		super();
		this.parkingLot = parkingLot;
	}
	
	public ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
		ParkingSlot parkingSlot = null;
		for (ParkingFloor floor : parkingLot.getParkingFloors()) {
			parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
			if (parkingSlot != null)
				break;
		}
		return parkingSlot;
	}

	

}
