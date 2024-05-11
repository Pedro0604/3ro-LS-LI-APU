package ar.edu.unlp.info.oo2.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProyecto {
	Proyecto p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Proyecto("Vacaciones de invierno", LocalDateTime.of(2024, 7, 16, 0, 0, 0),
				LocalDateTime.of(2024, 7, 24, 0, 0, 0), "Salir con amigos", 3, 12000);
	}

	@Test
	public void testEnConstruccion() {
		assertEquals("En construcción", p.getState());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen invalido
		p.modificarMargenDeGanancia(0.02);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen valido
		p.modificarMargenDeGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.09, p.precioProyecto());

		p.aprobarEtapa();
		assertEquals("En evaluación", p.getState());

		p = new Proyecto("Vacaciones de invierno", LocalDateTime.of(2024, 7, 16, 0, 0, 0),
				LocalDateTime.of(2024, 7, 24, 0, 0, 0), "Salir con amigos", 1, 0);

		try {
			p.aprobarEtapa();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		p.cancelarProyecto();
		assertEquals("Cancelado", p.getState());
		assertTrue(p.getObjetivo().contains("(Cancelado)"));
	}

	@Test
	public void testEnEvaluación() {
		p.aprobarEtapa();
		assertEquals("En evaluación", p.getState());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen invalido
		p.modificarMargenDeGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// Margen valido
		p.modificarMargenDeGanancia(0.13);
		assertEquals(3 * 12_000 * 8 * 1.13, p.precioProyecto());

		p.aprobarEtapa();
		assertEquals("Confirmado", p.getState());

		p = new Proyecto("Vacaciones de invierno", LocalDateTime.of(2024, 7, 16, 0, 0, 0),
				LocalDateTime.of(2024, 7, 24, 0, 0, 0), "Salir con amigos", 3, 12_000);
		p.aprobarEtapa();

		p.cancelarProyecto();
		assertEquals("Cancelado", p.getState());
		assertTrue(p.getObjetivo().contains("(Cancelado)"));
	}

	@Test
	public void testConfirmado() {
		p.aprobarEtapa();
		p.aprobarEtapa();
		assertEquals("Confirmado", p.getState());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// No se puede modificarMargenDeGanancia en un proyecto confirmado
		p.modificarMargenDeGanancia(0.02);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.modificarMargenDeGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.modificarMargenDeGanancia(0.013);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.aprobarEtapa();
		assertEquals("Confirmado", p.getState());

		p = new Proyecto("Vacaciones de invierno", LocalDateTime.of(2024, 7, 16, 0, 0, 0),
				LocalDateTime.of(2024, 7, 24, 0, 0, 0), "Salir con amigos", 3, 12_000);
		p.aprobarEtapa();
		p.aprobarEtapa();

		p.cancelarProyecto();
		assertEquals("Cancelado", p.getState());
		assertTrue(p.getObjetivo().contains("(Cancelado)"));
	}

	@Test
	public void testCancelado() {
		p.cancelarProyecto();
		assertEquals("Cancelado", p.getState());
		assertEquals(3 * 12_000 * 8, p.costoProyecto());
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		// No se puede modificarMargenDeGanancia en un proyecto cancelado
		p.modificarMargenDeGanancia(0.02);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.modificarMargenDeGanancia(0.09);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.modificarMargenDeGanancia(0.013);
		assertEquals(3 * 12_000 * 8 * 1.07, p.precioProyecto());

		p.aprobarEtapa();
		assertEquals("Cancelado", p.getState());

		assertTrue(p.getObjetivo().contains("(Cancelado)"));
		p.cancelarProyecto();
		p.setObjetivo("Messi");
		assertFalse(p.getObjetivo().contains("(Cancelado)"));
	}
}
