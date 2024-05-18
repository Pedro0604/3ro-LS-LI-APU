package ar.edu.unlp.info.oo2.ejercicio23;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VueloTest {
	private Vuelo v;
	private TypeVuelo tv;
	private Avion a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Avion("Pilatus PC-12", 6, 1500);
		tv = new TypeVuelo("UF101", "La Plata", "Balcarce", LocalTime.of(7, 0), LocalTime.of(8, 0), 12000,
				new boolean[] { true, true, true, true, true, true, true }, a);
		v = new Vuelo(LocalDate.of(2024, 5, 18), tv);
	}

	// Testeo getters porque van a buscar la info al TypeVuelo
	@Test
	public void testGetters() {
		assertEquals(this.tv.getId(), this.tv.getId());
		assertEquals(this.tv.getCiudadSalida(), this.tv.getCiudadSalida());
		assertEquals(this.tv.getCiudadLlegada(), this.tv.getCiudadLlegada());
		assertEquals(this.tv.getHoraSalida(), this.tv.getHoraSalida());
		assertEquals(this.tv.getHoraLlegada(), this.tv.getHoraLlegada());
		assertEquals(this.tv.getCostoBase(), this.tv.getCostoBase());
		assertEquals(this.tv.getFrecuencia(), this.tv.getFrecuencia());
		assertEquals(this.tv.getAvion(), this.tv.getAvion());
	}

	@Test
	public void testOcuparAsiento() {
		assertEquals(0, this.v.getCantAsientosOcupados());
		assertTrue(this.v.ocuparAsiento(0));
		assertEquals(1, this.v.getCantAsientosOcupados());
		assertFalse(this.v.ocuparAsiento(0));
		assertEquals(1, this.v.getCantAsientosOcupados());
		assertFalse(this.v.ocuparAsiento(-1));
		assertEquals(1, this.v.getCantAsientosOcupados());
		assertFalse(this.v.ocuparAsiento(120));
		assertEquals(1, this.v.getCantAsientosOcupados());
		assertTrue(this.v.ocuparAsiento(this.a.getCantAsientos() - 1));
		assertEquals(2, this.v.getCantAsientosOcupados());
	}

	@Test
	public void testDesocuparAsiento() {
		assertEquals(0, this.v.getCantAsientosOcupados());
		this.v.desocuparAsiento(0);
		assertEquals(0, this.v.getCantAsientosOcupados());
		this.v.desocuparAsiento(-1);
		assertEquals(0, this.v.getCantAsientosOcupados());
		this.v.desocuparAsiento(120);
		assertEquals(0, this.v.getCantAsientosOcupados());
		this.v.desocuparAsiento(this.a.getCantAsientos() - 1);
		assertEquals(0, this.v.getCantAsientosOcupados());
		assertTrue(this.v.ocuparAsiento(0));
		this.v.desocuparAsiento(1);
		assertEquals(1, this.v.getCantAsientosOcupados());
		this.v.desocuparAsiento(0);
		assertEquals(0, this.v.getCantAsientosOcupados());
	}

	@Test
	public void testIsFull() {
		for (int i = 0; i < this.a.getCantAsientos(); i++) {
			assertFalse(this.v.isFull());
			this.v.ocuparAsiento(i);
		}
		assertTrue(this.v.isFull());
	}
}
