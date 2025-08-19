//663380223-3 นายพิรัชย์ ชัยรัตน์ sec 1

package sqa.test;

import sqa.main.LiquidVolumeConverter;

public class LiquidGetConversionFactorStub extends LiquidVolumeConverter {
	
	@Override
	// oz to ml
	public double getConversionFactor(String fromUnit, String toUnit) {
		return 29.574;
	}
}
