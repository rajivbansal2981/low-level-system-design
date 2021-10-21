package com.jmk.elevator.workers;

import com.jmk.elevator.operator.ElevatorController;
import com.jmk.elevator.request.Request;

public class AddJobWorker implements Runnable {
	private ElevatorController elevatorController;
	private Request request;

	public AddJobWorker(ElevatorController elevator, Request request) {
		this.elevatorController = elevatorController;
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
		elevatorController.addJob(request);
	}
}
