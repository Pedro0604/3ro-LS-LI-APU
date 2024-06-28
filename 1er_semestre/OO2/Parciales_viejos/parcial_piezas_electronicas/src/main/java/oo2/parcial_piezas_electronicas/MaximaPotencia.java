package oo2.parcial_piezas_electronicas;

public class MaximaPotencia implements Configuracion {

	@Override
	public double porcentajeVariacionBateria() {
		return 0.5;
	}

	@Override
	public double porcentajeVariacionPotencia() {
		return 0.2;
	}

}
