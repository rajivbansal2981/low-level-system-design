package com.jmk.elevator.request;

import com.jmk.elevator.enums.Direction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //It is combination of @ToString, @EqualsAndHashCode ,@Getter,@Setter and @RequiredArgsConstructor
public class ExternalRequest {
	private Direction directionToGo;
	private int sourceFloor;
	
	@Override
	public String toString() {
		return " The Elevator has been requested on floor - " + sourceFloor + " and the person wants go in the - "
				+ directionToGo;
	}
}
