package oo2.mi_parcial_08_06_2024;

public class AprobadoState extends PrestamoState {
	public AprobadoState(Prestamo prestamo) {
		super(prestamo);
	}

	@Override
	public double pagarCuota() throws Error {
		if (this.prestamo.getCuotasRestantes() - 1 == 0) {
			this.prestamo.setState(new FinalizadoState(this.prestamo));
		}
		return this.prestamo.getMontoCuota();
	}

	@Override
	public double gastoCancelacion() {
		return this.prestamo.getMontoRestante() + this.prestamo.getValorAdministrativo()
				+ this.prestamo.getValorSellado();
	}
}
