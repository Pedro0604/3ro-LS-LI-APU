package oo2.mi_parcial_08_06_2024;

public class FinalizadoState extends PrestamoState {
	public FinalizadoState(Prestamo prestamo) {
		super(prestamo);
	}

	@Override
	public double gastoCancelacion() {
		return 0;
	}
}
