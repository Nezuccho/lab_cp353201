package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import sqa.main.ShippingVehicle;

class TestCalculate {

	ShippingVehicle shipping = new ShippingVehicle();
	
	@ParameterizedTest
	@MethodSource("shippingVehicleTestCase")
	void test_calculateCategoryPartition(int numSmall, int numMedium , int numLarge, List<Integer> expectedResult) {
		assertEquals(expectedResult,(shipping.calculate(numSmall, numMedium, numLarge)));
	}

	static Stream<Arguments> shippingVehicleTestCase() {
		return Stream.of(
			Arguments.of(0, 0, 0, List.of(0, 0, 0)),
			Arguments.of(0, 0, 99, List.of(99, 0, 0)),
			Arguments.of(0, 199, 0, List.of(0, 199, 0)),
			Arguments.of(499, 0, 0, List.of(0, 0, 499)),
			Arguments.of(0, 99, 49, List.of(49, 99, 0)),
			Arguments.of(249, 99, 0, List.of(0, 99, 249)),
			Arguments.of(149, 69, 34, List.of(34, 69, 149)),
			Arguments.of(0, 0, 101, List.of(-1)),
			Arguments.of(0, 201, 0, List.of(-1)),
			Arguments.of(501, 0, 0, List.of(-1)),
			Arguments.of(0, 101, 50, List.of(-1)),
			Arguments.of(251, 100, 0, List.of(-1)),
			Arguments.of(166, 67, 56, List.of(-1)),
			Arguments.of(0, 0, -1, List.of(-1)),
			Arguments.of(0, -1, 0, List.of(-1)),
			Arguments.of(-1, 0, 0, List.of(-1)),
			Arguments.of(0, -1, -1, List.of(-1)),
			Arguments.of(-1, -1, 0, List.of(-1)),
			Arguments.of(-1, -1, -1, List.of(-1))
		);
	}
}
