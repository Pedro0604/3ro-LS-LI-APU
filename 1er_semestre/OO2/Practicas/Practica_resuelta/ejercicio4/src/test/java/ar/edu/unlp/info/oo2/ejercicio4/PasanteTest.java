package ar.edu.unlp.info.oo2.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasanteTest {
	private Pasante pSinExamenes, pConExamenes;

	@BeforeEach
	void setUp() throws Exception {
		pSinExamenes = new Pasante(0);
		pConExamenes = new Pasante(10);
	}

	@Test
	public void testAdicional() {
		assertEquals(0, pSinExamenes.getAdicional());
		assertEquals(20_000, pConExamenes.getAdicional());
	}

	@Test
	public void testSueldoBasico() {
		assertEquals(20_000, pSinExamenes.getSueldoBasico());
		assertEquals(20_000, pConExamenes.getSueldoBasico());
	}

	@Test
	public void testSueldo() {
		assertEquals(17_400, pSinExamenes.sueldo());
		assertEquals(36_400, pConExamenes.sueldo());
	}
}
