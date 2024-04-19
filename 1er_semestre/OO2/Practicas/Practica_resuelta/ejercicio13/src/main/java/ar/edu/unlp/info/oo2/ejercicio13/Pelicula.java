package ar.edu.unlp.info.oo2.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int anioEstreno;
	private double puntaje;
	private List<Pelicula> peliculasSimilares;

	public Pelicula(String titulo, int anioEstreno, double puntaje) {
		this.titulo = titulo;
		this.anioEstreno = anioEstreno;
		this.puntaje = puntaje;
		this.peliculasSimilares = new ArrayList<>();
	}

	public int getAnioEstreno() {
		return anioEstreno;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public List<Pelicula> getPeliculasSimilares() {
		return peliculasSimilares;
	}

	public void addPeliculaSimilar(Pelicula pelicula) {
		if (!this.peliculasSimilares.contains(pelicula)) {
			this.peliculasSimilares.add(pelicula);
			pelicula.addPeliculaSimilar(this);
		}
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", anioEstreno=" + anioEstreno + ", puntaje=" + puntaje + "]";
	}
}
