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
		"9999, 4, 550, Standard",
		"10000, 4, 550, Standard",
		"10001, 4, 550, Standard",
		"55000, 4, 550, Gold",
		"99999, 4, 550, Gold",
		"100000, 4, 550, Standard",
		"100001, 4, 550, Standard",
		"55000, 0, 550, Standard",
		"55000, 1, 550, Standard",
		"55000, 2, 550, Standard",
		"55000, 6, 550, Standard",
		"55000, 7, 550, Standard",
		"55000, 8, 550, Standard",
		"55000, 4, 99, Standard",
		"55000, 4, 100, Standard",
		"55000, 4, 101, Standard",
		"55000, 4, 999, Gold",
		"55000, 4, 1000, Standard",
		"55000, 4, 1001, Standard",
		
		//Special Silver Test case (TC20, TC21)
		"10000, 1, 100, Silver",
		"49999, 2, 499, Silver",
		
		//Special Platinum Test case (TC22, TC23)
		"100000, 6, 1000, Platinum",
		"100000, 7, 1000, Platinum",
		
		//Special Value Test case (TC24-TC28)
		"-1,	 4, 550, Invalid",
		"55000, -1, 550, Invalid",
		"55000,  4, -1,  Invalid",
		"0, 	 4, 550, Standard",
		"55000,  4, 0,   Standard"
		
	})
	void test_robustnessRanking(int purchaseTotal, int frequency, int pointCollected, String expectedResult) {
		assertEquals(expectedResult,(ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected)));
	}


}
