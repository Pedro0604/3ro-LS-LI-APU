package ar.edu.unlp.info.oo2.ejercicio13;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaNovedad implements EstrategiaDeSugerencia {
	@Override
	public List<Pelicula> sugerir(List<Pelicula> peliculas, List<Pelicula> peliculasVistas) {
		return peliculas.stream().filter(p -> !peliculasVistas.contains(p))
				.sorted((p1, p2) -> Integer.compare(p2.getAnioEstreno(), p1.getAnioEstreno())).limit(3)
				.collect(Collectors.toList());
	}
}
