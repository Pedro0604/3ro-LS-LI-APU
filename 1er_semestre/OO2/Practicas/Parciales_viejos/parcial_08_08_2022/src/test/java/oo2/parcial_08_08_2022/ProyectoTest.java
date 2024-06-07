package oo2.parcial_08_08_2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProyectoTest {
	private Proyecto proyecto;

	@BeforeEach
	void setUp() throws Exception {
		this.proyecto = new Proyecto("Vacaciones de invierno", LocalDate.of(2024, 7, 20), LocalDate.of(2024, 7, 27),
				"Salir con amigos", 3, 100_000);
		this.proyecto.aprobarEtapa();
	}

	@Test
	public void testAprobarProyecto() {
		assertEquals("En evaluación", this.proyecto.getStateName());
		try {
			this.proyecto.aprobarEtapa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Confirmado", this.proyecto.getStateName());
	}
}
