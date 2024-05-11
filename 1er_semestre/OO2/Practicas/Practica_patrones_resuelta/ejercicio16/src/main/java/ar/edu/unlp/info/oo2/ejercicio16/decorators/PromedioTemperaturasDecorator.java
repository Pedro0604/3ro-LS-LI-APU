package ar.edu.unlp.info.oo2.ejercicio16.decorators;

import java.text.DecimalFormat;

import ar.edu.unlp.info.oo2.ejercicio16.WheaterData;

public class PromedioTemperaturasDecorator extends WheaterDecorator {
	private boolean isCelsius;

	public PromedioTemperaturasDecorator(WheaterData datos, boolean isCelsius) {
		super(datos);
		this.isCelsius = isCelsius;
	}

	@Override
	public String displayData() {
		DecimalFormat formatter = new DecimalFormat("#0");
		double promedioTemperaturas = this.getTemperaturas().stream().mapToDouble(t -> isCelsius ? (t - 32) / 1.8 : t)
				.average().orElse(0.0);
		return "Promedio: " + formatter.format(promedioTemperaturas) + "; " + super.displayData();
	}
}