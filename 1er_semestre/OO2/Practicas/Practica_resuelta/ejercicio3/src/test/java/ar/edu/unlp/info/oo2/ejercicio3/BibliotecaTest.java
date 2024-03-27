package ar.edu.unlp.info.oo2.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class BibliotecaTest {
	private Biblioteca b;

	@BeforeEach
	void setUp() throws Exception {
		b = new Biblioteca();
	}

	@Test
	public void voorheesExporterTest() {
		b.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
		b.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2"));
		String expected = "[\n" + "    {\n" + "   	 \"nombre\": \"Arya Stark\",\n"
				+ "   	 \"email\": \"needle@stark.com\",\n" + "   	 \"legajo\": \"5234-5\"\n" + "    },\n" + "    {\n"
				+ "   	 \"nombre\": \"Tyron Lannister\",\n" + "   	 \"email\": \"tyron@thelannisters.com\",\n"
				+ "   	 \"legajo\": \"2345-2\"\n" + "    }\n" + "]";
		assertEquals(expected, b.exportarSocios());
	}
}
