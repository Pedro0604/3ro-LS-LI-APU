package oo2.parcial_10_06_2023;

public class SeguroTercerosCompleto extends Seguro {

	public SeguroTercerosCompleto(Vehiculo vehiculo) {
		super(vehiculo);
	}

	@Override
	protected double costoSeguroDeVidaExtra() {
		return 5000 * this.vehiculo.getCapacidadMaxima();
	}

	@Override
	public double costoCoberturaDañosOtros(int edadAsegurado) {
		long antiguedad = this.vehiculo.getAntiguedad();
		return antiguedad > 4 ? 4000 * antiguedad : 10000;
	}

	@Override
	public double costoCoberturaDañosPropios() {
		return this.vehiculo.getValor() * 0.005 + 10000;
	}

}
