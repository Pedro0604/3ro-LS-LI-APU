package ar.edu.unlp.info.oo2.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemporarioTest {
	private Temporario tTrabajo, tVago, tCasado, tConejo;

	@BeforeEach
	void setUp() throws Exception {
		tTrabajo = new Temporario(100, false, 0);
		tVago = new Temporario(0, false, 0);
		tCasado = new Temporario(50, true, 0);
		tConejo = new Temporario(50, false, 5);
	}

	@Test
	public void testAdicional() {
		assertEquals(0, tTrabajo.getAdicional());
		assertEquals(0, tVago.getAdicional());
		assertEquals(5_000, tCasado.getAdicional());
		assertEquals(10_000, tConejo.getAdicional());
	}

	@Test
	public void testSueldoBasico() {
		assertEquals(50_000, tTrabajo.getSueldoBasico());
		assertEquals(20_000, tVago.getSueldoBasico());
		assertEquals(35_000, tCasado.getSueldoBasico());
		assertEquals(35_000, tConejo.getSueldoBasico());
	}

	@Test
	public void testSueldo() {
		assertEquals(43_500, tTrabajo.sueldo());
		assertEquals(17_400, tVago.sueldo());
		assertEquals(35_200, tCasado.sueldo());
		assertEquals(39_950, tConejo.sueldo());
	}
}
