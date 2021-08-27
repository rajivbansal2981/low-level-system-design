package com.jmk.elevator.workers;

import com.jmk.elevator.operator.ElevatorOperator;

public class ProcessJobWorker implements Runnable{
	private ElevatorOperator elevator;

	public ProcessJobWorker(ElevatorOperator elevator) {
		this.elevator = elevator;
	}

	@Override
	public void run() {
		/**
		 * start the elevator
		 */
		elevator.startElevator();
	}

}
