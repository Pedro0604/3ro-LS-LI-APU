package oo2.mi_parcial_08_06_2024;

public abstract class Prestamo {
	private double monto, montoAbonado;
	private int cantCuotas, cantCuotasAbonadas;
	private PrestamoState state;
	private Cliente cliente;

	public Prestamo(double monto, int cantCuotas, Cliente cliente) {
		this.monto = monto;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
		if (this.cliente.puedeSolicitarPrestamo(this.getMontoCuota())) {
			this.state = new AprobadoState(this);
		} else {
			this.state = new RechazadoState(this);
		}
	}

	public void setState(PrestamoState state) {
		this.state = state;
	}

	public double getMontoCuota() {
		return (this.monto / this.cantCuotas) * this.getTasaInteres();
	}

	protected abstract double getTasaInteres();

	public void pagarCuota() throws Error {
		this.montoAbonado += this.state.pagarCuota();
		this.cantCuotasAbonadas++;
	}

	public double getMontoAbonado() {
		return this.montoAbonado;
	}

	public double getMontoRestante() {
		return this.getCuotasRestantes() * this.getMontoCuota();
	}

	public int getCuotasRestantes() {
		return this.cantCuotas - this.cantCuotasAbonadas;
	}

	public double gastoCancelacion() {
		return this.state.gastoCancelacion();
	}

	public double getValorAdministrativo() {
		return this.getMontoRestante() * 0.1;
	}

	public abstract double getValorSellado();
}
