package ar.edu.unlp.info.oo2.ejercicio4;

public class Pasante extends Empleado {
	private int cantExamenes;

	public Pasante(int cantExamenes) {
		super(20_000);
		this.cantExamenes = cantExamenes;
	}

	@Override
	public double getAdicional() {
		return this.cantExamenes * 2000;
	}
}
