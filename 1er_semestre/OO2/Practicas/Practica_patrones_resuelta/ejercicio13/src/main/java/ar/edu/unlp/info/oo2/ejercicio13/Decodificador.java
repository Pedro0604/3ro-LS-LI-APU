package ar.edu.unlp.info.oo2.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
	private List<Pelicula> peliculas, peliculasVistas;
	private EstrategiaDeSugerencia strategy;

	public Decodificador(EstrategiaDeSugerencia strategy) {
		this.peliculas = new ArrayList<>();
		this.peliculasVistas = new ArrayList<>();
		this.strategy = strategy;
	}

	public void setStrategy(EstrategiaDeSugerencia strategy) {
		this.strategy = strategy;
	}

	public void addPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}

	public void addPeliculaVista(Pelicula pelicula) {
		this.peliculasVistas.add(pelicula);
	}

	public List<Pelicula> sugerirPeliculas() {
		return this.strategy.sugerir(this.peliculas, this.peliculasVistas);
	}
}
