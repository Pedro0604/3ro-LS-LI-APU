package ar.edu.unlp.info.oo2.ejercicio16.decorators;

import java.text.DecimalFormat;

import ar.edu.unlp.info.oo2.ejercicio16.WheaterData;

public class MinimaTemperaturaDecorator extends WheaterDecorator {
	private boolean isCelsius;

	public MinimaTemperaturaDecorator(WheaterData datos, boolean isCelsius) {
		super(datos);
		this.isCelsius = isCelsius;
	}

	@Override
	public String displayData() {
		DecimalFormat formatter = new DecimalFormat("#0");
		double minTemperatura = this.getTemperaturas().stream().mapToDouble(t -> isCelsius ? (t - 32) / 1.8 : t).min()
				.orElse(0.0);
		return "Mínimo: " + formatter.format(minTemperatura) + "; " + super.displayData();
	}
}
