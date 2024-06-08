package oo2.mi_parcial_08_06_2024;

public class PrestamoUVA extends Prestamo {
	public PrestamoUVA(double monto, int cantCuotas, Cliente cliente) {
		super(monto, cantCuotas, cliente);
	}

	@Override
	protected double getTasaInteres() {
		return Math.random();
	}

	@Override
	public double getValorSellado() {
		return 0;
	}

}
