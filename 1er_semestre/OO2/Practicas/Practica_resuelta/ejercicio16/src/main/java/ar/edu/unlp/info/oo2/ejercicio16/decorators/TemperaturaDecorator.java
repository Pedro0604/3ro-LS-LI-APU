package ar.edu.unlp.info.oo2.ejercicio16.decorators;

import java.text.DecimalFormat;

import ar.edu.unlp.info.oo2.ejercicio16.WheaterData;

public class TemperaturaDecorator extends WheaterDecorator {
	private boolean isCelsius;

	public TemperaturaDecorator(WheaterData datos, boolean isCelsius) {
		super(datos);
		this.isCelsius = isCelsius;
	}

	@Override
	public String displayData() {
		DecimalFormat formatter = new DecimalFormat("#0");
		double temperatura = this.getTemperatura();
		temperatura = isCelsius ? (temperatura - 32) / 1.8 : temperatura;
		return "Temperatura F: " + formatter.format(temperatura) + "; " + super.displayData();
	}
}
