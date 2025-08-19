//663380223-3 นายพิรัชย์ ชัยรัตน์ sec 1

package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sqa.main.CookingConversionCalculator;

class TestWithStub {

	@Test
	void test_CookingConversionCalculator_TempStub() {
		TemperatureConverterStub TempStub = new TemperatureConverterStub();
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator() {
			@Override
			public double convert(double value, String choice, String fromUnit, String toUnit) {
				if (choice.equals("temperature")) {
					return TempStub.convert(value, fromUnit, toUnit);
				}
				return 0;
			}
		};
		
		//320 F -> 160.0 C
		double expectedResult = 160.0;
		assertEquals(expectedResult, CookingConverter.convert(320.0, "temperature","fahrenheit", "celsius"));
	}
	
	@Test
	void test_CookingConversionCalculator_MassStub() {
		MassConverterStub MassStub = new MassConverterStub();
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator() {
			@Override
			public double convert(double value, String choice, String fromUnit, String toUnit) {
				if (choice.equals("mass")) {
					return MassStub.convert(value, fromUnit, toUnit);
				}
				return 0;
			}
		};
		
		//5 cup -> 625.0 gram
		double expectedResult = 625.0;
		assertEquals(expectedResult, CookingConverter.convert(5, "mass","cup", "gram"));
	}
	
	@Test
	void test_CookingConversionCalculator_LiquidStub() {
		LiquidVolumeConverterStub LiquidStub = new LiquidVolumeConverterStub();
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator() {
			@Override
			public double convert(double value, String choice, String fromUnit, String toUnit) {
				if (choice.equals("liquid")) {
					return LiquidStub.convert(value, fromUnit, toUnit);
				}
				return 0;
			}
		};
		
		// 2 teaspoon -> 10 ml
		double expectedResult = 10.0;
		assertEquals(expectedResult, CookingConverter.convert(2, "liquid","teaspoon", "ml"));
	}
	
	@Test
	//320 F -> 160.0 C
	void test_TemperatureConverter() {
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator();
		double expectedResult = 160.0;
		assertEquals(expectedResult, CookingConverter.convert(320.0, "temperature","fahrenheit", "celsius"));
	}
	
	@Test
	// 10 cup -> 1250.0 gram
	void test_MassConverterConvert_MassGetConversionFactorStub() {
		MassGetConversionFactorStub MassFactorStub = new MassGetConversionFactorStub();
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator() {
			@Override
			public double convert(double value, String choice, String fromUnit, String toUnit) {
				if (choice.equals("mass")) {
					return MassFactorStub.convert(value, fromUnit, toUnit);
				}
				return 0;
			}
		};
		double expectedResult = 1250.0;
		assertEquals(expectedResult, CookingConverter.convert(10.0, "mass","cup", "gram"));
	}
	
	@Test
	// 10 cup -> 1250.0 gram
	void test_MassConverter() {
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator();
		double expectedResult = 1250.0;
		assertEquals(expectedResult, CookingConverter.convert(10.0, "mass","cup", "gram"));
	}
	
	@Test
	// 10 oz -> 295.74 ml
	void test_LiquidVolumeConverter_LiquidGetConversionFactorStub() {
		LiquidGetConversionFactorStub LiquidFactorStub = new LiquidGetConversionFactorStub();
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator() {
			@Override
			public double convert(double value, String choice, String fromUnit, String toUnit) {
				if (choice.equals("liquid")) {
					return LiquidFactorStub.convert(value, fromUnit, toUnit);
				}
				return 0;
			}
		};
		double expectedResult = 295.74;
		assertEquals(expectedResult, CookingConverter.convert(10.0, "liquid","oz", "ml"));
	}
	
	@Test
	// 10 oz -> 295.74 ml
	void test_LiquidVolumeConverter() {
		CookingConversionCalculator CookingConverter = new CookingConversionCalculator();
		double expectedResult = 295.74;
		assertEquals(expectedResult, CookingConverter.convert(10.0, "liquid","oz", "ml"));
	}
	
	

}
