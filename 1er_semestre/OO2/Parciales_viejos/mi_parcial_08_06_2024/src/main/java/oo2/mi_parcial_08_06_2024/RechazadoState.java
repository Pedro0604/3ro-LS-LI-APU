package oo2.mi_parcial_08_06_2024;

public class RechazadoState extends PrestamoState {

	public RechazadoState(Prestamo prestamo) {
		super(prestamo);
	}

	@Override
	public double gastoCancelacion() {
		throw new Error("error");
	}

}
