package oo2.mi_parcial_08_06_2024;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombre;
	private double salarioMensual;
	private List<Prestamo> prestamos;

	public Cliente(String nombre, double salarioMensual) {
		this.nombre = nombre;
		this.salarioMensual = salarioMensual;
		this.prestamos = new ArrayList<>();
	}

	public Prestamo solicitarPrestamoSimple(double monto, int cantCuotas, double interes) {
		Prestamo prestamo = new PrestamoSimple(monto, cantCuotas, this, interes);
		this.prestamos.add(prestamo);
		return prestamo;
	}

	public Prestamo solicitarPrestamoUVA(double monto, int cantCuotas) {
		Prestamo prestamo = new PrestamoUVA(monto, cantCuotas, this);
		this.prestamos.add(prestamo);
		return prestamo;
	}

	public boolean puedeSolicitarPrestamo(double montoCuota) {
		return montoCuota <= this.salarioMensual * 0.3;
	}
}
