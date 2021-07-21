package com.parkinglot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parkinglot.enums.VehicleCategory;
import com.parkinglot.models.Ticket;
import com.parkinglot.models.Vehicle;
import com.parkinglot.services.TicketCounterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingLotApplicationTest {
	
	@Autowired
	private TicketCounterService ticketCounterService;

	@Test
	public void testCreateParkingLot() {
		 	Vehicle vehicle = new Vehicle();
	        vehicle.setVehicleCategory(VehicleCategory.Hatchback);
	        vehicle.setVehicleNumber("KA-01-MA-9999");
	        
			/*
			 * When vehicle enters in the parking lot and TicketCounterService will create
			 * the ticket and assign the parking slot to the customer
			 */
	        Ticket ticket = ticketCounterService.entry(vehicle);
	        System.out.println(" ticket number >> "+ticket.getTicketNumber());
	        
	        try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	        /*
			 * When vehicle exits from the parking lot and TicketCounterService will remove the vehicle from the parking slot
			 * and asks the customer to pay the charges according to the time
			 */
	        ticketCounterService.exit(ticket);
	}
}
