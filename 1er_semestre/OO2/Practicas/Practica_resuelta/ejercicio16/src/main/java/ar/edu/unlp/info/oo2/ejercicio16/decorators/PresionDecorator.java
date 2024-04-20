package ar.edu.unlp.info.oo2.ejercicio16.decorators;

import java.text.DecimalFormat;

import ar.edu.unlp.info.oo2.ejercicio16.WheaterData;

public class PresionDecorator extends WheaterDecorator {
	public PresionDecorator(WheaterData datos) {
		super(datos);
	}

	@Override
	public String displayData() {
		DecimalFormat formatter = new DecimalFormat("#0");
		return "Presión atmosf.: " + formatter.format(this.getPresion()) + "; " + super.displayData();
	}
}