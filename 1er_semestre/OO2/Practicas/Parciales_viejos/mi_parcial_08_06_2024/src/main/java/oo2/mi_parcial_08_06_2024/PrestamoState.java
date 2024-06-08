package oo2.mi_parcial_08_06_2024;

public abstract class PrestamoState {
	protected Prestamo prestamo;

	public PrestamoState(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public double pagarCuota() throws Error {
		throw new Error("error");
	}

	public abstract double gastoCancelacion();
}
