package ar.edu.unlp.info.oo2.ejercicio13;

import java.util.List;

public interface EstrategiaDeSugerencia {
	public List<Pelicula> sugerir(List<Pelicula> peliculas, List<Pelicula> peliculasVistas);
}
