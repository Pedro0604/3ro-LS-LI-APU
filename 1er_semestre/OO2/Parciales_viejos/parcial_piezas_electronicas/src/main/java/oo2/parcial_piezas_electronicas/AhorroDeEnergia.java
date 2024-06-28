package oo2.parcial_piezas_electronicas;

public class AhorroDeEnergia implements Configuracion {

	@Override
	public double porcentajeVariacionBateria() {
		return -0.2;
	}

	@Override
	public double porcentajeVariacionPotencia() {
		return -0.3;
	}

}
