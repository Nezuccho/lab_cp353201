//663380223-3 นายพิรัชย์ ชัยรัตน์ sec 1

package sqa.test;

import sqa.main.TemperatureConverter;

public class TemperatureConverterStub extends TemperatureConverter {
	
	@Override
	// F -> C
	public double convert(double tempValue, String fromUnit, String toUnit) {
		return (tempValue - 32) / 1.8;
	}
}
