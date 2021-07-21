package com.parkinglot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkinglot.models.ParkingSlot;
import com.parkinglot.models.Ticket;
import com.parkinglot.models.Vehicle;

@Component
public class TicketCounterService {
	
	@Autowired
	private SpaceAllocationService spaceAllocationService;
	
	@Autowired
	private PaymentService paymentService;
	
	public Ticket entry(Vehicle vehicle) {
		// to assign ticket we need parking slot for this vehicle
		ParkingSlot parkingSlot = spaceAllocationService.getParkingSlotForVehicleAndPark(vehicle);
		if (parkingSlot == null)
			return null;
		Ticket parkingTicket = Ticket.createTicket(vehicle, parkingSlot);
		// persist ticket to database
		return parkingTicket;
	}
	
	public void exit(Ticket ticket) {
		paymentService.scanAndPay(ticket);
		ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
	}

}
