//663380223-3 นายพิรัชย์ ชัยรัตน์ sec 1

package sqa.test;

import sqa.main.CookingConversionCalculator;
import sqa.main.LiquidVolumeConverter;
import sqa.main.MassConverter;

public class Driver {

	public static void main(String[] args) {
		
		double originalValue = 0.0;
		double convertedValue = 0.0;
		String selectedChoice;
		String from;
		String to;
		
		CookingConversionCalculator converter = new CookingConversionCalculator();
		
		//--------- TemperatureConverter ------------
		// 20.0 C -> 68.0 F
		originalValue = 20.0;
		selectedChoice = "temperature";
		from = "celsiusfahrenheit";
		to = "fahrenheit";
		
		convertedValue = converter.convert(originalValue, selectedChoice, from, to);
		System.out.println("--------- Unit under test: TemperatureConverter ------------");
		System.out.println(originalValue + " " + from + " = " + convertedValue + " " + to);
		
		//--------- MassConverter.getConversionFactor() ------------
	    // 100 grams -> 3.5 oz
        originalValue = 100.0;
        from = "gram";
        to = "oz";
        
        MassConverter massConverter = new MassConverter();
        convertedValue = massConverter.convert(originalValue, from, to);

		System.out.println("--------- Unit under test: MassConverter.getConversionFactor() ------------");
		System.out.println(originalValue + " " + from + " = "+ convertedValue + " " + to);
        
        //--------- MassConverter.getConversionFactor() + MassConverter.convert() ------------
        // 200 grams -> 7.0 oz
		originalValue = 200.0;
        selectedChoice = "mass";
		from = "gram";
		to = "oz";
       
        convertedValue = converter.convert(originalValue, selectedChoice, from, to);
        
        System.out.println("--------- Unit under test: MassConverter.getConversionFactor() + MassConverter.convert() ------------");
        System.out.println(originalValue + " " + from + " = "+ convertedValue + " " + to);
        
        //--------- LiquidVolumeConverter.getConversionFactor() ------------
        // 3 pint -> 1419.528 ml
        originalValue = 3.0;
        from = "pint";
        to = "ml";
       
        LiquidVolumeConverter LiquidConverter = new LiquidVolumeConverter();
        convertedValue = LiquidConverter.convert(originalValue, from, to);
        
        System.out.println("--------- Unit under test: LiquidVolumeConverter.getConversionFactor() ------------");
        System.out.println(originalValue + " " + from + " = "+ convertedValue + " " + to);
        
        //--------- LiquidVolumeConverter.getConversionFactor() + LiquidVolumeConverter.convert() ------------
        // 10.0 pint -> 4731.76 ml
        originalValue = 10.0;
        selectedChoice = "liquid";
		from = "pint";
		to = "ml";
               
        convertedValue = converter.convert(originalValue, selectedChoice, from, to);
        
        System.out.println("--------- Unit under test: MassConverter.getConversionFactor() + MassConverter.convert() ------------");
        System.out.println(originalValue + " " + from + " = "+ convertedValue + " " + to);
        
        
	
	}

}
