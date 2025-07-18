package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

class NormalTesting {
	
	Ranking ranking = new Ranking();
	
	// purchaseTotal, frequency, pointCollected, ExpectedResult
	@ParameterizedTest
	@CsvSource({
		"10000, 4, 550, Standard",
		"10001, 4, 550, Standard",
		"55000, 4, 550, Gold",
		"99999, 4, 550, Gold",
		"100000, 4, 550, Standard",
		"55000, 1, 550, Standard",
		"55000, 2, 550, Standard",
		"55000, 6, 550, Standard",
		"55000, 7, 550, Standard",
		"55000, 4, 100, Standard",
		"55000, 4, 101, Standard",
		"55000, 4, 999, Gold",
		"55000, 4, 1000, Standard",
		
		//Special Silver Test case (TC14, TC15)
		"10000, 1, 100, Silver",
		"49999, 2, 499, Silver",
		
		//Special Platinum Test case (TC16, TC17)
		"100000, 6, 1000, Platinum",
		"100000, 7, 1000, Platinum"
		
	})
	void test_normalRanking(int purchaseTotal, int frequency, int pointCollected, String expectedResult) {
		assertEquals(expectedResult,(ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected)));
	}

}
