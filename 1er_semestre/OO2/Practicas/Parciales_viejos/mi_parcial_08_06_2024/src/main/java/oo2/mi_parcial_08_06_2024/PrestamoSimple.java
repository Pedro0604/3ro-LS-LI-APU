package oo2.mi_parcial_08_06_2024;

public class PrestamoSimple extends Prestamo {
	private double interes;

	public PrestamoSimple(double monto, int cantCuotas, Cliente cliente, double interes) {
		super(monto, cantCuotas, cliente);
		this.interes = interes;
	}

	@Override
	protected double getTasaInteres() {
		return interes;
	}

	@Override
	public double getValorSellado() {
		return 5000;
	}

}
