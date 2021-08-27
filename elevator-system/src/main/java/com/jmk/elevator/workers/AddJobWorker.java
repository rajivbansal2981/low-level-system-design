package com.jmk.elevator.workers;

import com.jmk.elevator.operator.ElevatorOperator;
import com.jmk.elevator.request.Request;

public class AddJobWorker implements Runnable {
	private ElevatorOperator elevator;
	private Request request;

	public AddJobWorker(ElevatorOperator elevator, Request request) {
		this.elevator = elevator;
		this.request = request;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elevator.addJob(request);
	}
}
