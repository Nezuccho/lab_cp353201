//นายพิรัชย์ ชัยรัตน์ 663380223-3 Sec 1

package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import sqa.main.CountWordClumps;

class TestCountWordClumps {

	@ParameterizedTest
	@MethodSource("BranchAndConditionCoverageTestCase")
	void Test_CountClumpsBranchAndConditionCoverage(int[] nums, int expectedResult) {
		assertEquals(expectedResult, CountWordClumps.countClumps(nums));
	}

	static Stream<Arguments>BranchAndConditionCoverageTestCase() {
		return Stream.of(
			Arguments.of(null, 0),                      
			Arguments.of(new int[] {}, 0),              
			Arguments.of(new int[] {1, 1, 3, 3}, 2), 
			Arguments.of(new int[] {2, 2, 2}, 1)
		);
	}

}
