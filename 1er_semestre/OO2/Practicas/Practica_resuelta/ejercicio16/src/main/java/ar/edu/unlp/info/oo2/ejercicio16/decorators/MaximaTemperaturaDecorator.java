package ar.edu.unlp.info.oo2.ejercicio16.decorators;

import java.text.DecimalFormat;

import ar.edu.unlp.info.oo2.ejercicio16.WheaterData;

public class MaximaTemperaturaDecorator extends WheaterDecorator {
	private boolean isCelsius;

	public MaximaTemperaturaDecorator(WheaterData datos, boolean isCelsius) {
		super(datos);
		this.isCelsius = isCelsius;
	}

	@Override
	public String displayData() {
		DecimalFormat formatter = new DecimalFormat("#0");
		double maxTemperatura = this.getTemperaturas().stream().mapToDouble(t -> isCelsius ? (t - 32) / 1.8 : t).max()
				.orElse(0.0);
		return "Máximo: " + formatter.format(maxTemperatura) + "; " + super.displayData();
	}
}