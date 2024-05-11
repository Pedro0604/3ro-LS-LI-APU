package ar.edu.unlp.info.oo2.ejercicio13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecodificadorTest {
	private Decodificador d;

	@BeforeEach
	void setUp() throws Exception {
		d = new Decodificador(new SugerenciaNovedad());
		Pelicula thor = new Pelicula("Thor", 2007, 7.9);
		Pelicula capitanAmerica = new Pelicula("Capitan América", 2016, 7.8);
		Pelicula ironMan = new Pelicula("Iron Man", 2010, 7.9);
		Pelicula dunkirk = new Pelicula("Dunkirk", 2017, 7.9);
		Pelicula rocky = new Pelicula("Rocky", 1976, 8.1);
		Pelicula rambo = new Pelicula("Rambo", 1979, 7.8);

		thor.addPeliculaSimilar(capitanAmerica);
		thor.addPeliculaSimilar(ironMan);
		rocky.addPeliculaSimilar(rambo);

		d.addPelicula(thor);
		d.addPelicula(capitanAmerica);
		d.addPelicula(ironMan);
		d.addPelicula(dunkirk);
		d.addPelicula(rocky);
		d.addPelicula(rambo);

		d.addPeliculaVista(thor);
		d.addPeliculaVista(rocky);
	}

	@Test
	public void testSugerencias() {
		d.sugerirPeliculas().forEach(p -> System.out.println(p.toString()));

		d.setStrategy(new SugerenciaSimilaridad());
		d.sugerirPeliculas().forEach(p -> System.out.println(p.toString()));

		d.setStrategy(new SugerenciaPuntaje());
		d.sugerirPeliculas().forEach(p -> System.out.println(p.toString()));
	}
}
