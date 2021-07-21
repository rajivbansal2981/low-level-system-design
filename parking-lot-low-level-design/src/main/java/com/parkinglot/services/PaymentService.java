package com.parkinglot.services;

import org.springframework.stereotype.Component;

import com.parkinglot.models.Ticket;

@Component
public class PaymentService {
	
	 public void scanAndPay(Ticket ticket){
	        long endTime = System.currentTimeMillis();
	        int duration = (int) (endTime-ticket.getStartTime())/1000;
	        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
	        System.out.println("price is >>" + price);
	        //persist record to database and call to Payment Gateway
	    }
}
