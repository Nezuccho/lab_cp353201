//663380223-3 นายพิรัชย์ ชัยรัตน์ sec 1

package sqa.test;

import sqa.main.MassConverter;

public class MassGetConversionFactorStub extends MassConverter {
	
	@Override
	// convert cup -> gram
	public double getConversionFactor(String fromUnit, String toUnit) {
		return 125;
	}
}
