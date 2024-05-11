package ar.edu.unlp.info.oo2.ejercicio13;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaSimilaridad implements EstrategiaDeSugerencia {
	@Override
	public List<Pelicula> sugerir(List<Pelicula> peliculas, List<Pelicula> peliculasVistas) {
		List<Pelicula> peliculasSimilares = peliculasVistas.stream().map(p -> p.getPeliculasSimilares())
				.flatMap(List::stream).collect(Collectors.toList());

		return peliculas.stream().filter(p -> !peliculasVistas.contains(p) && peliculasSimilares.contains(p))
				.sorted((p1, p2) -> Integer.compare(p2.getAnioEstreno(), p1.getAnioEstreno())).limit(3)
				.collect(Collectors.toList());
	}
}
