package com.jmk.elevator.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //It is combination of @ToString, @EqualsAndHashCode ,@Getter,@Setter and @RequiredArgsConstructor
public class InternalRequest {

	private int destinationFloor;
	
	@Override
	public String toString() {
		return "The destinationFloor is - " + destinationFloor;
	}
	
}
