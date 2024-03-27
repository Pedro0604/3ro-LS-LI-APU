package ar.edu.unlp.info.oo2.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoPlantaTest {
	private EmpleadoPlanta tAntiguo, tNuevo, tCasado, tConejo;

	@BeforeEach
	void setUp() throws Exception {
		tAntiguo = new EmpleadoPlanta(false, 0, 25);
		tNuevo = new EmpleadoPlanta(false, 0, 0);
		tCasado = new EmpleadoPlanta(true, 0, 10);
		tConejo = new EmpleadoPlanta(false, 5, 10);
	}

	@Test
	public void testAdicional() {
		assertEquals(50_000, tAntiguo.getAdicional());
		assertEquals(0, tNuevo.getAdicional());
		assertEquals(25_000, tCasado.getAdicional());
		assertEquals(30_000, tConejo.getAdicional());
	}

	@Test
	public void testSueldoBasico() {
		assertEquals(50_000, tAntiguo.getSueldoBasico());
		assertEquals(50_000, tNuevo.getSueldoBasico());
		assertEquals(50_000, tCasado.getSueldoBasico());
		assertEquals(50_000, tConejo.getSueldoBasico());
	}

	@Test
	public void testSueldo() {
		assertEquals(91_000, tAntiguo.sueldo());
		assertEquals(43_500, tNuevo.sueldo());
		assertEquals(67_250, tCasado.sueldo());
		assertEquals(72_000, tConejo.sueldo());
	}
}
