package oo2.parcial_10_06_2023;

public class SeguroTodoRiesgo extends Seguro {

	public SeguroTodoRiesgo(Vehiculo vehiculo) {
		super(vehiculo);
	}

	@Override
	protected double costoSeguroDeVidaExtra() {
		return 9000 * this.vehiculo.getAntiguedad();
	}

	@Override
	public double costoCoberturaDañosOtros(int edadAsegurado) {
		return 100_000 / edadAsegurado;
	}

	@Override
	public double costoCoberturaDañosPropios() {
		return 0.005 * this.vehiculo.getValor() + 1000 * this.vehiculo.getAntiguedad();
	}

}
