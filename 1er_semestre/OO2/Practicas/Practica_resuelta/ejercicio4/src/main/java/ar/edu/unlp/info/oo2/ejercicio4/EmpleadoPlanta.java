package ar.edu.unlp.info.oo2.ejercicio4;

public class EmpleadoPlanta extends Empleado {
	private boolean estaCasado;
	private int cantHijos;
	private int antiguedad;

	public EmpleadoPlanta(boolean estaCasado, int cantHijos, int antiguedad) {
		super(50_000);
		this.estaCasado = estaCasado;
		this.cantHijos = cantHijos;
		this.antiguedad = antiguedad;
	}

	@Override
	public double getAdicional() {
		return (this.estaCasado ? 5000 : 0) + this.cantHijos * 2000 + this.antiguedad * 2000;
	}
}
