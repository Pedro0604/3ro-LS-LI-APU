package ar.edu.unlp.info.oo2.ejercicio13;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPuntaje implements EstrategiaDeSugerencia {
	@Override
	public List<Pelicula> sugerir(List<Pelicula> peliculas, List<Pelicula> peliculasVistas) {
		Comparator<Pelicula> compararPorPuntaje = Comparator.comparing(Pelicula::getPuntaje)
				.thenComparing(Pelicula::getAnioEstreno).reversed();

		return peliculas.stream().filter(p -> !peliculasVistas.contains(p)).sorted(compararPorPuntaje).limit(3)
				.collect(Collectors.toList());
	}
}
