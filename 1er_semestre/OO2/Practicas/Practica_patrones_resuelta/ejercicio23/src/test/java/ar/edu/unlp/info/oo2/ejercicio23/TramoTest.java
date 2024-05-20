package ar.edu.unlp.info.oo2.ejercicio23;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TramoTest {
	private Tramo tramo;
	private Vuelo vuelo;
	private Avion avion;
	private final boolean[] FRECUENCIA_DIARIA = new boolean[] { true, true, true, true, true, true, true };

	@BeforeEach
	void setUp() throws Exception {
		avion = new Avion("Pilatus PC-12", 6, 1500);
		vuelo = new Vuelo("UF101", "La Plata", "Balcarce", LocalTime.of(7, 0), LocalTime.of(8, 0), 12000,
				FRECUENCIA_DIARIA, avion);
		tramo = new Tramo(LocalDate.of(2024, 5, 18), vuelo);
	}

	// Testeo getters porque van a buscar la info al TypeVuelo
	@Test
	public void testGetters() {
		assertEquals(this.vuelo.getId(), this.tramo.getId());
		assertEquals(this.vuelo.getCiudadSalida(), this.tramo.getCiudadSalida());
		assertEquals(this.vuelo.getCiudadLlegada(), this.tramo.getCiudadLlegada());
		assertEquals(this.vuelo.getHoraSalida(), this.tramo.getHoraSalida());
		assertEquals(this.vuelo.getHoraLlegada(), this.tramo.getHoraLlegada());
		assertEquals(this.vuelo.getCostoBase(), this.tramo.getCostoBase());
		assertEquals(this.vuelo.getFrecuencia(), this.tramo.getFrecuencia());
		assertEquals(this.vuelo.getAvion(), this.tramo.getAvion());
	}

	@Test
	public void testOcuparAsiento() {
		assertEquals(0, this.tramo.getCantAsientosOcupados());
		assertTrue(this.tramo.ocuparAsiento(0));
		assertEquals(1, this.tramo.getCantAsientosOcupados());
		assertFalse(this.tramo.ocuparAsiento(0));
		assertEquals(1, this.tramo.getCantAsientosOcupados());
		assertFalse(this.tramo.ocuparAsiento(-1));
		assertEquals(1, this.tramo.getCantAsientosOcupados());
		assertFalse(this.tramo.ocuparAsiento(120));
		assertEquals(1, this.tramo.getCantAsientosOcupados());
		assertTrue(this.tramo.ocuparAsiento(this.avion.getCantAsientos() - 1));
		assertEquals(2, this.tramo.getCantAsientosOcupados());
	}

	@Test
	public void testDesocuparAsiento() {
		assertEquals(0, this.tramo.getCantAsientosOcupados());
		this.tramo.desocuparAsiento(0);
		assertEquals(0, this.tramo.getCantAsientosOcupados());
		this.tramo.desocuparAsiento(-1);
		assertEquals(0, this.tramo.getCantAsientosOcupados());
		this.tramo.desocuparAsiento(120);
		assertEquals(0, this.tramo.getCantAsientosOcupados());
		this.tramo.desocuparAsiento(this.avion.getCantAsientos() - 1);
		assertEquals(0, this.tramo.getCantAsientosOcupados());
		assertTrue(this.tramo.ocuparAsiento(0));
		this.tramo.desocuparAsiento(1);
		assertEquals(1, this.tramo.getCantAsientosOcupados());
		this.tramo.desocuparAsiento(0);
		assertEquals(0, this.tramo.getCantAsientosOcupados());
	}

	@Test
	public void testIsFull() {
		for (int i = 0; i < this.avion.getCantAsientos(); i++) {
			assertFalse(this.tramo.isFull());
			this.tramo.ocuparAsiento(i);
		}
		assertTrue(this.tramo.isFull());
	}
}
