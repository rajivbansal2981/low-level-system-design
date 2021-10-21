/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jmk.elevator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmk.elevator.enums.Direction;
import com.jmk.elevator.operator.ElevatorController;
import com.jmk.elevator.request.ExternalRequest;
import com.jmk.elevator.request.InternalRequest;
import com.jmk.elevator.request.Request;
import com.jmk.elevator.workers.AddJobWorker;
import com.jmk.elevator.workers.ProcessJobWorker;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElevatorSystemApplicationTest {

	@Test
	public void testElevatorOpertor() {
		ElevatorController elevator = new ElevatorController();

		/**
		 * Thread for starting the elevator
		 */
		ProcessJobWorker processJobWorker = new ProcessJobWorker(elevator);
		Thread t2 = new Thread(processJobWorker);
		t2.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InternalRequest ir = new InternalRequest(5);

		ExternalRequest er = new ExternalRequest(Direction.UP, 0);

		Request request1 = new Request(ir, er);

		/**
		 * Pass job to the elevator
		 */
		new Thread(new AddJobWorker(elevator, request1)).start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
