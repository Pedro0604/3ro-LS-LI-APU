package ar.edu.unlp.info.oo2.ejercicio4;

public abstract class Empleado {
	private double sueldoBasico;

	public Empleado(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public abstract double getAdicional();

	public double getDescuento() {
		return this.getSueldoBasico() * 0.13 + this.getAdicional() * 0.05;
	}

	protected double sueldo() {
		return this.getSueldoBasico() + this.getAdicional() - this.getDescuento();
	}
}
