package oo2.parcial_10_06_2023;

public abstract class Seguro {
	protected Vehiculo vehiculo;

	public Seguro(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getCosto(int edadAsegurado) {
		return this.costoSeguroDeVida(edadAsegurado) + this.costoCoberturaDañosOtros(edadAsegurado)
				+ this.costoCoberturaDañosPropios();
	}

	protected double costoSeguroDeVida(int edadAsegurado) {
		return 100 * edadAsegurado + this.costoSeguroDeVidaExtra();
	}

	protected abstract double costoSeguroDeVidaExtra();

	protected abstract double costoCoberturaDañosOtros(int edadAsegurado);

	protected abstract double costoCoberturaDañosPropios();
}
