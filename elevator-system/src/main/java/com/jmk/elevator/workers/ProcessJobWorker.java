package com.jmk.elevator.workers;

import com.jmk.elevator.operator.ElevatorController;

public class ProcessJobWorker implements Runnable{
	private ElevatorController elevatorController;

	public ProcessJobWorker(ElevatorController elevatorController) {
		this.elevatorController = elevatorController;
	}

	@Override
	public void run() {
		/**
		 * start the elevator
		 */
		elevatorController.startElevator();
	}

}
