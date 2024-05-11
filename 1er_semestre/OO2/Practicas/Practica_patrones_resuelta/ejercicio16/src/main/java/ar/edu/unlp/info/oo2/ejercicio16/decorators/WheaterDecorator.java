package ar.edu.unlp.info.oo2.ejercicio16.decorators;

import java.util.List;

import ar.edu.unlp.info.oo2.ejercicio16.WheaterData;

public abstract class WheaterDecorator implements WheaterData {
	protected WheaterData datos;

	public WheaterDecorator(WheaterData datos) {
		this.datos = datos;
	}

	@Override
	public double getTemperatura() {
		return this.datos.getTemperatura();
	}

	@Override
	public double getPresion() {
		return this.datos.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		return this.datos.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturas() {
		return this.datos.getTemperaturas();
	}

	@Override
	public String displayData() {
		return this.datos.displayData();
	}

}
