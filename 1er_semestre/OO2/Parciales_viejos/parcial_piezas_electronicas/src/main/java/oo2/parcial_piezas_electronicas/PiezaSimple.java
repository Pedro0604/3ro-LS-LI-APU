package oo2.parcial_piezas_electronicas;

public class PiezaSimple extends Pieza {
	private int capacidadBateria, potencia;

	public PiezaSimple(String nombre, int capacidadBateria, int potencia) {
		super(nombre);
		this.capacidadBateria = capacidadBateria;
		this.potencia = potencia;
	}

	@Override
	public double capacidadBateria() {
		return capacidadBateria;
	}

	@Override
	public double potencia() {
		return potencia;
	}
}
