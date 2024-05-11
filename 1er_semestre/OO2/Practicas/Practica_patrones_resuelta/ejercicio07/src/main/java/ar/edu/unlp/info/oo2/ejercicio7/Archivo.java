package ar.edu.unlp.info.oo2.ejercicio7;

public class Archivo extends Elemento {
	private int tamano;

	public Archivo(String nombre, int tamano) {
		super(nombre);
		this.tamano = tamano;
	}

	@Override
	public int getTamano() {
		return this.tamano;
	}
}
