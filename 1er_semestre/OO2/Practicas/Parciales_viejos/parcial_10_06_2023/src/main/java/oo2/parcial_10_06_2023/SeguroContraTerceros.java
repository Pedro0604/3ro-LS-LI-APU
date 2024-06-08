package oo2.parcial_10_06_2023;

public class SeguroContraTerceros extends Seguro {

	public SeguroContraTerceros(Vehiculo vehiculo) {
		super(vehiculo);
	}

	@Override
	protected double costoSeguroDeVidaExtra() {
		return 0;
	}

	@Override
	public double costoCoberturaDañosOtros(int edadAsegurado) {
		return 1000 + 0.01 * this.vehiculo.getValor();
	}

	@Override
	public double costoCoberturaDañosPropios() {
		return this.vehiculo.getValor() * 0.005;
	}

}
