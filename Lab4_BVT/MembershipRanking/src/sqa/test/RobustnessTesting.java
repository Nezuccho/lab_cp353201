package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

class RobustnessTesting {

	Ranking ranking = new Ranking();
	
	// purchaseTotal, frequency, pointCollected, ExpectedResult
	@ParameterizedTest
	@CsvSource({
		"-1, 16, 550, Invalid",
		"0,  16, 550, Standard",
		"1,  16, 550, Standard",
		"50000, 16, 550, Standard",
		"99999, 16, 550, Standard",
		"100000, 16, 550, Standard",
		"100001, 16, 550, Standard",
		"50000, -1, 550, Invalid",
		"50000, 0, 550, Standard",
		"50000, 1, 550, Standard",
		"50000, 30, 550, Standard",
		"50000, 31, 550, Standard",
		"50000, 32, 550, Standard",
		"50000, 16, -1, Invalid",
		"50000, 16, 0, Standard",
		"50000, 16, 1, Standard",
		"50000, 16, 999, Standard",
		"50000, 16, 1000, Standard",
		"50000, 16, 1001, Standard",
		
	})
	void test_robustnessRanking(int purchaseTotal, int frequency, int pointCollected, String expectedResult) {
		assertEquals(expectedResult,(ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected)));
	}


}
