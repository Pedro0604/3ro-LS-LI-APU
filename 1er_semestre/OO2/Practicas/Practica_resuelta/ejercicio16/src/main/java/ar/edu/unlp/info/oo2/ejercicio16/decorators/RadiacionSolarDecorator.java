package ar.edu.unlp.info.oo2.ejercicio16.decorators;

import java.text.DecimalFormat;

import ar.edu.unlp.info.oo2.ejercicio16.WheaterData;

public class RadiacionSolarDecorator extends WheaterDecorator {
	public RadiacionSolarDecorator(WheaterData datos) {
		super(datos);
	}

	@Override
	public String displayData() {
		DecimalFormat formatter = new DecimalFormat("#0");
		return "Radiación solar: " + formatter.format(this.getRadiacionSolar()) + "; " + super.displayData();
	}
}