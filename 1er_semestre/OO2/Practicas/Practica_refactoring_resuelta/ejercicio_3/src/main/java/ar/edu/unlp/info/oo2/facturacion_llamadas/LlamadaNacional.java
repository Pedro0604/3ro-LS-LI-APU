package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaNacional extends Llamada {
	public LlamadaNacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}

	public int getPrecioPorSegundo() {
		return 3;
	}

	public int getCostoEstablecerLlamada() {
		return 0;
	}
}
