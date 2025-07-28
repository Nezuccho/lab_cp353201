package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Income;

class TestCalculateIncome {

	Income income = new Income();
	
	@ParameterizedTest
	@CsvSource({
		"1000, 300, 500, 29000",
		"1000, 300, 499, -1",
		"1000, 300, 3001, -1",
		"3000, 299, 1750, -1",
		"3000, 299, 499, -1",
		"3000, 299, 3001, -1",
		"3000, 801, 1750, -1",
		"3000, 801, 499, -1",
		"3000, 801, 3001, -1",
		"999, 800, 3000, -1",
		"999, 800, 499, -1",
		"999, 800, 3001, -1",
		"999, 299, 3000, -1",
		"999, 299, 499, -1",
		"999, 299, 3001, -1",
		"999, 801, 3000, -1",
		"999, 801, 499, -1",
		"999, 801, 3001, -1",
		"5500, 550, 1750, -1",
		"5500, 550, 250, -1",
		"5500, 550, 3500, -1",
		"5500, 150, 1750, -1",
		"5500, 150, 250, -1",
		"5500, 150, 3500, -1",
		"5500, 1000, 500, -1",
		"5500, 1000, 250, -1",
		"5500, 1000, 3500, -1",
	})
	void test_strongRobustIncome(int numImpeller, int numMotor , int numCover, Double expectedResult) {
		assertEquals(expectedResult,(income.calculateIncome(numImpeller, numMotor, numCover)));
	}

}
