package sqa.main;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.TVPlan.TVPackage;


class TestPricePerMonthLEDT {

	
	@ParameterizedTest
	@CsvSource({
		//selectStandard, selectPremium, selectFamily, addOffline, addLive, signContract, expectedResult
		//Standard
		"true, false, false, true, true, true, 300",
		"true, false, false, true, true, false, 350",
		"true, false, false, true, false, true, 200",
		"true, false, false, true, false, false, 250",
		"true, false, false, false, true, true, 200",
		"true, false, false, false, true, false, 250",
		"true, false, false, false, false, true, 100",
		"true, false, false, false, false, false, 150",
		
		//Premium
		"false, true, false, true, true, true, 500",
		"false, true, false, true, true, false, 550",
		"false, true, false, true, false, true, 400",
		"false, true, false, true, false, false, 450",
		"false, true, false, false, true, true, 400",
		"false, true, false, false, true, false, 450",
		"false, true, false, false, false, true, 300",
		"false, true, false, false, false, false, 350",
		
		//Family
		"false, false, true, true, true, true, 600",
		"false, false, true, true, true, false, 650",
		"false, false, true, true, false, true, 500",
		"false, false, true, true, false, false, 550",
		"false, false, true, false, true, true, 500",
		"false, false, true, false, true, false, 550",
		"false, false, true, false, false, true, 400",
		"false, false, true, false, false, false, 450",
	})
	void test_pricePerMonthLEDT(boolean selectStandard, boolean selectPremium, boolean selectFamily, boolean addOffline, boolean addLive, boolean signContract, double expectedResult) {
		TVPackage selectedPackage = null;
		if (selectStandard) selectedPackage = TVPackage.STANDARD;
		else if (selectPremium) selectedPackage = TVPackage.PREMIUM;
		else if (selectFamily) selectedPackage = TVPackage.FAMILY;
		
		TVPlan tvPlan = new TVPlan(addOffline, addLive, signContract);
		double actualPrice = tvPlan.pricePerMonth(selectedPackage);
		assertEquals(expectedResult, actualPrice);
	}

}
