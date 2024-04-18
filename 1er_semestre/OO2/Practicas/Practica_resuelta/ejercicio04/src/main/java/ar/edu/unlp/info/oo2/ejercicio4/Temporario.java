package ar.edu.unlp.info.oo2.ejercicio4;

public class Temporario extends Empleado {
	private boolean estaCasado;
	private int cantHijos;

	public Temporario(int cantHorasTrabajadas, boolean estaCasado, int cantHijos) {
		super(20_000 + cantHorasTrabajadas * 300);
		this.estaCasado = estaCasado;
		this.cantHijos = cantHijos;
	}

	@Override
	public double getAdicional() {
		return (this.estaCasado ? 5000 : 0) + this.cantHijos * 2000;
	}
}
