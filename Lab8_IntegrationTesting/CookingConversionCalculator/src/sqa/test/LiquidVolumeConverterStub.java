//663380223-3 นายพิรัชย์ ชัยรัตน์ sec 1

package sqa.test;

import sqa.main.LiquidVolumeConverter;

public class LiquidVolumeConverterStub extends LiquidVolumeConverter {
	
	@Override
	// Teaspoon -> ml
	public double getConversionFactor(String fromUnit, String toUnit) {
		return 5;
	}
}
