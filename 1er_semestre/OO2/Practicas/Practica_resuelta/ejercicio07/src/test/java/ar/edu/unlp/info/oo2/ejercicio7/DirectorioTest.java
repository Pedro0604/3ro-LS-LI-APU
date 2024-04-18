package ar.edu.unlp.info.oo2.ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DirectorioTest {
	private Directorio d;

	@BeforeEach
	void setUp() throws Exception {
		d = new Directorio("pepe");
	}

	public void addArchivos(Directorio d) {
		Archivo a = new Archivo("hola.txt", 220);
		Archivo a2 = new Archivo("chau.txt", 50);
		Archivo a3 = new Archivo("adio.txt", 111);
		d.addChild(a);
		d.addChild(a2);
		d.addChild(a3);
	}

	public void addArchivosYDirectorios(Directorio d) {
		Archivo a = new Archivo("hola.txt", 220);
		Archivo a2 = new Archivo("chau.txt", 50);
		d.addChild(a);
		d.addChild(a2);

		Directorio d2 = new Directorio("d2");
		Archivo a3 = new Archivo("adio.txt", 111);
		Archivo a4 = new Archivo("jelou.txt", 456);
		d2.addChild(a3);
		d2.addChild(a4);

		d.addChild(d2);
	}

	@Test
	public void testGetTamano() {
		addArchivos(d);
		assertEquals(32 * 1024 + 381, d.getTamano());

		d.removeAllChildren();

		addArchivosYDirectorios(d);
		assertEquals(32 * 1024 + 270 + 32 * 1024 + 567, d.getTamano());
	}
}
