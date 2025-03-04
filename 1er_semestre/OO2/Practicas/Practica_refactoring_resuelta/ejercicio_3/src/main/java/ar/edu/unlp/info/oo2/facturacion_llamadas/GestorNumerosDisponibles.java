package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;
import java.util.TreeSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineasTelefonicasDisponibles = new TreeSet<String>();
	private GeneradorDeLineasStrategy tipoGenerador = new StrategyUltimo();

	public SortedSet<String> getLineasTelefonicasDisponibles() {
		return lineasTelefonicasDisponibles;
	}

	public String obtenerNumeroLibre() {
		String lineaTelefonica = this.tipoGenerador.obtenerNumeroLibre(lineasTelefonicasDisponibles);
		if (lineaTelefonica != null) {
			lineasTelefonicasDisponibles.remove(lineaTelefonica);
		}
		return lineaTelefonica;
	}

	public void cambiarTipoGenerador(GeneradorDeLineasStrategy nuevoTipoGenerador) {
		this.tipoGenerador = nuevoTipoGenerador;
	}

	public boolean agregarNumeroTelefono(String numeroDeTelefono) {
		return this.getLineasTelefonicasDisponibles().add(numeroDeTelefono);
	}
}