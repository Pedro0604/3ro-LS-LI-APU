package oo2.parcial_01_07_2023;

public abstract class Tarea {
	private String nombre;

	public Tarea(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract int estimacionTotal();

	public abstract long getFechaInicio();

	public abstract long getFechaFin();

	public abstract void iniciar();

	public abstract void completar();

	public abstract long tiempoUtilizado();

	public double avance() {
		return this.tiempoUtilizado() / (double) this.estimacionTotal();
	}
}
