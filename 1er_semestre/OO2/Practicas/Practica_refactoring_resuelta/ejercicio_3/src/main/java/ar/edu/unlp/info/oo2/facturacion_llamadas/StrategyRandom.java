package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class StrategyRandom extends GeneradorDeLineasStrategy {
	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineasTelefonicasDisponibles) {
		String lineaTelefonica = new ArrayList<String>(lineasTelefonicasDisponibles)
				.get(new Random().nextInt(lineasTelefonicasDisponibles.size()));
		lineasTelefonicasDisponibles.remove(lineaTelefonica);
		return lineaTelefonica;
	}
}