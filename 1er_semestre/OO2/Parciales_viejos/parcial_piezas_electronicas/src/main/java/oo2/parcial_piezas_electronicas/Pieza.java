package oo2.parcial_piezas_electronicas;

public abstract class Pieza {
	protected String nombre;

	public Pieza(String nombre) {
		this.nombre = nombre;
	}

	public abstract double capacidadBateria();

	public abstract double potencia();

	public String informacion() {
		return "Pieza [nombre=" + nombre + ", capacidadBateria=" + this.capacidadBateria() + "%, potencia="
				+ this.potencia() + "w]";
	}
}
