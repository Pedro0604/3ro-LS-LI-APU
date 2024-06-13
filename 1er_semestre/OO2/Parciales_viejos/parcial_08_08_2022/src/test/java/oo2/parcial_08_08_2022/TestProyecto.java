package oo2.parcial_08_08_2022;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProyecto {
	Proyecto p, proyectoEnCero;

	@BeforeEach
	void setUp() throws Exception {
		p = new Proyecto("Vacaciones de invierno", LocalDate.of(2024, 7, 16), LocalDate.of(2024, 7, 24),
				"Salir con amigos", 3, 12000);
		proyectoEnCero = new Proyecto("Vacaciones de invierno", LocalDate.of(2024, 7, 16), LocalDate.of(2024, 7, 24),
				"Salir con amigos", 3, 0);
	}

	@Test
	public void testEnConstruccion() {
		assertEquals("En construcción", p.getStateName());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen invalido
		p.moficarMargenGanancia(0.02);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen valido
		p.moficarMargenGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.09, p.precioProyecto());

		boolean noSeAprobo = false;
		try {
			proyectoEnCero.aprobarEtapa();
		} catch (Exception e) {
			noSeAprobo = true;
		}

		assertTrue(noSeAprobo);

		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("En evaluación", p.getStateName());

		p = new Proyecto("Vacaciones de invierno", LocalDate.of(2024, 7, 16), LocalDate.of(2024, 7, 24),
				"Salir con amigos", 1, 0);

		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		p.cancelarProyecto();
		assertEquals("Cancelado", p.getStateName());
		assertTrue(p.getObjetivo().contains("(Cancelado)"));
	}

	@Test
	public void testEnEvaluación() {
		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("En evaluación", p.getStateName());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen invalido
		p.moficarMargenGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen valido
		p.moficarMargenGanancia(0.13);
		assertEquals(3 * 12_000 * 8 * 1.13, p.precioProyecto());

		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Confirmado", p.getStateName());

		p = new Proyecto("Vacaciones de invierno", LocalDate.of(2024, 7, 16), LocalDate.of(2024, 7, 24),
				"Salir con amigos", 3, 12_000);
		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}

		p.cancelarProyecto();
		assertEquals("Cancelado", p.getStateName());
		assertTrue(p.getObjetivo().contains("(Cancelado)"));
	}

	@Test
	public void testConfirmado() {
		try {
			p.aprobarEtapa();
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Confirmado", p.getStateName());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// No se puede modificarMargenDeGanancia en un proyecto confirmado
		p.moficarMargenGanancia(0.02);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.moficarMargenGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.moficarMargenGanancia(0.013);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Confirmado", p.getStateName());

		p = new Proyecto("Vacaciones de invierno", LocalDate.of(2024, 7, 16), LocalDate.of(2024, 7, 24),
				"Salir con amigos", 3, 12_000);
		try {
			p.aprobarEtapa();
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}

		p.cancelarProyecto();
		assertEquals("Cancelado", p.getStateName());
		assertTrue(p.getObjetivo().contains("(Cancelado)"));
	}

	@Test
	public void testCancelado() {
		p.cancelarProyecto();
		assertEquals("Cancelado", p.getStateName());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// No se puede modificarMargenDeGanancia en un proyecto cancelado
		p.moficarMargenGanancia(0.02);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.moficarMargenGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.moficarMargenGanancia(0.013);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Cancelado", p.getStateName());

		assertTrue(p.getObjetivo().contains("(Cancelado)"));
		p.cancelarProyecto();
		p.setObjetivo("Messi");
		assertFalse(p.getObjetivo().contains("(Cancelado)"));
	}
}
