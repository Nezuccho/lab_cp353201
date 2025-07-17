package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Roman.RomanNumerals;

class TestRomanNumerals {
	RomanNumerals roman = new RomanNumerals();

	//---------Positive--------------
	//TC01 Input = "I", Expected Result = 1
	@Test
	void test_singleDigit() {
		assertEquals(1,roman.convertRomanNumToInt("I"));
	}
	
	//TC02 Input = "IX", Expected Result = 9
		@Test
		void test_twoDigits_FirstSmallerThanSecond() {
			assertEquals(9,roman.convertRomanNumToInt("IX"));
		}
		
	//TC03 Input = "CI", Expected Result = 101
		@Test
		void test_twoDigits_FirstLargerThanSecond() {
			assertEquals(101,roman.convertRomanNumToInt("CI"));
		}
	
	//TC04 Input = "XX", Expected Result = 20
		@Test
		void test_twoDigits_SameNumber() {
			assertEquals(20,roman.convertRomanNumToInt("XX"));
		}
		
	//TC05 Input = "III", Expected Result = 3
		@Test
		void test_multipleDigits_SameNumber() {
			assertEquals(3,roman.convertRomanNumToInt("III"));
		}
	
	//TC06 Input = "LXVII", Expected Result = 67
		@Test
		void test_multipleDigits_FirstLargerThanTheRest() {
			assertEquals(67,roman.convertRomanNumToInt("LXVII"));
		}

	//TC07 Input = "LXXXIV", Expected Result = 84
		@Test
		void test_multipleDigits_FirstLargestAndTheRestIsCombination() {
			assertEquals(84,roman.convertRomanNumToInt("LXXXIV"));
		}
		
	//---------Negative--------------
	//TC08 Input = "J", Expected Result = Error
		@Test
		void test_NotRoman() {
		    RuntimeException ex = assertThrows(RuntimeException.class, () -> {
		        roman.convertRomanNumToInt("J");
		    });
		    
		    //For checking which exception
		    //System.out.println("Caught Exception: " + ex.getClass().getName());
		    //System.out.println("Message: " + ex.getMessage());
		}

	//TC09 Input = "LL", Expected Result = !=100
		@Test
		void test_wrongRepeatDigits() {
			assertNotEquals(100, roman.convertRomanNumToInt("LL"));
			System.out.println("From wrong repeat input 'LL' = " + roman.convertRomanNumToInt("LL"));
		}

	//TC10 Input = "XXXX", Expected Result = !=40
		@Test
		void test_moreThanThreeRepeatRomanNumeral() {
			assertNotEquals(40, roman.convertRomanNumToInt("XXXX"));
			System.out.println("From moreThanThreeRepeatRomanNumeral input 'XXXX' = " + roman.convertRomanNumToInt("XXXX"));
		}
	



	

}
