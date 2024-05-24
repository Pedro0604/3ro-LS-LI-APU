package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public class StrategyPrimero extends GeneradorDeLineasStrategy {
	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineasTelefonicasDisponibles) {
		String lineaTelefonica = lineasTelefonicasDisponibles.first();
		lineasTelefonicasDisponibles.remove(lineaTelefonica);
		return lineaTelefonica;
	}
}
