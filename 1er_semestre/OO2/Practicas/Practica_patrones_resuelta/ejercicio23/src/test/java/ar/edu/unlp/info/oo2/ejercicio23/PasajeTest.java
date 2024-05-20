package ar.edu.unlp.info.oo2.ejercicio23;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasajeTest {
	private Pasaje pasaje1, pasaje2;
	private Pasajero pasajero1, pasajero2;
	private Tramo tramo1, tramo2, tramo3, tramo4;
	private Vuelo vuelo1, vuelo2, vuelo3, vuelo4;
	private Avion avion;
	private final boolean[] FRECUENCIA_DIARIA = new boolean[] { true, true, true, true, true, true, true };

	@BeforeEach
	void setUp() throws Exception {
		avion = new Avion("Pilatus PC-12", 6, 1500);

		vuelo1 = new Vuelo("UF101", "La Plata", "Balcarce", LocalTime.of(7, 0), LocalTime.of(8, 0), 12000,
				FRECUENCIA_DIARIA, avion);
		vuelo2 = new Vuelo("UF102", "Balcarce", "Pergamino", LocalTime.of(9, 0), LocalTime.of(10, 30), 15000,
				FRECUENCIA_DIARIA, avion);
		vuelo3 = new Vuelo("UF202", "Pergamino", "Balcarce", LocalTime.of(17, 0), LocalTime.of(18, 30), 15000,
				FRECUENCIA_DIARIA, avion);
		vuelo4 = new Vuelo("UF203", "Balcarce", "La Plata", LocalTime.of(20, 0), LocalTime.of(21, 0), 12000,
				FRECUENCIA_DIARIA, avion);

		// 18/05/2024 fue sábado
		tramo1 = new Tramo(LocalDate.of(2024, 5, 18), vuelo1);
		tramo2 = new Tramo(LocalDate.of(2024, 5, 18), vuelo2);
		tramo3 = new Tramo(LocalDate.of(2024, 5, 18), vuelo3);
		tramo4 = new Tramo(LocalDate.of(2024, 5, 18), vuelo4);

		pasajero1 = new Pasajero("Pepe", 12341234);
		pasaje1 = new Pasaje(pasajero1);

		pasajero2 = new Pasajero("Papa", 23452345);
		pasaje2 = new Pasaje(pasajero2);
	}

	@Test
	public void testAddTramo() {
		assertEquals(0, this.pasaje1.getTramos().size());
		assertEquals(0, this.pasaje1.getNrosAsientos().size());
		assertTrue(pasaje1.addTramo(tramo1, 0));
		assertEquals(1, this.pasaje1.getTramos().size());
		assertEquals(1, this.pasaje1.getNrosAsientos().size());

		assertFalse(pasaje1.addTramo(tramo1, 1));
		assertEquals(1, this.pasaje1.getTramos().size());
		assertEquals(1, this.pasaje1.getNrosAsientos().size());

		assertTrue(pasaje1.addTramo(tramo2, 0));
		assertEquals(2, this.pasaje1.getTramos().size());
		assertEquals(2, this.pasaje1.getNrosAsientos().size());

		assertEquals(0, this.pasaje2.getTramos().size());
		assertEquals(0, this.pasaje2.getNrosAsientos().size());
		assertFalse(pasaje2.addTramo(tramo1, 0));
		assertEquals(0, this.pasaje2.getTramos().size());
		assertEquals(0, this.pasaje2.getNrosAsientos().size());

		assertTrue(pasaje2.addTramo(tramo1, 1));
		assertEquals(1, this.pasaje2.getTramos().size());
		assertEquals(1, this.pasaje2.getNrosAsientos().size());
	}

	@Test
	public void testRemoveTramo() {
		this.pasaje1.removeTramo(tramo1);
		assertEquals(0, this.pasaje1.getTramos().size());
		assertEquals(0, this.pasaje1.getNrosAsientos().size());

		assertTrue(pasaje1.addTramo(tramo1, 0));
		this.pasaje1.removeTramo(tramo4);
		assertEquals(1, this.pasaje1.getTramos().size());
		assertEquals(1, this.pasaje1.getNrosAsientos().size());

		this.pasaje1.removeTramo(tramo1);
		assertEquals(0, this.pasaje1.getTramos().size());
		assertEquals(0, this.pasaje1.getNrosAsientos().size());

		assertTrue(this.pasaje1.addTramo(tramo1, 0));
		this.pasaje1.removeTramo(tramo1);
		assertTrue(this.pasaje2.addTramo(tramo1, 0));
	}

	@Test
	public void testGetNroAsientoTramo() {
		this.pasaje1.addTramo(tramo1, 0);
		this.pasaje1.addTramo(tramo2, 0);
		this.pasaje1.addTramo(tramo3, 1);
		this.pasaje1.addTramo(tramo4, 1);
		assertEquals(0, this.pasaje1.getNroAsientoDeTramo(tramo1));
		assertEquals(0, this.pasaje1.getNroAsientoDeTramo(tramo2));
		assertEquals(1, this.pasaje1.getNroAsientoDeTramo(tramo3));
		assertEquals(1, this.pasaje1.getNroAsientoDeTramo(tramo4));

		this.pasaje1.removeTramo(tramo2);
		assertEquals(0, this.pasaje1.getNroAsientoDeTramo(tramo1));
		assertEquals(-1, this.pasaje1.getNroAsientoDeTramo(tramo2));
		assertEquals(1, this.pasaje1.getNroAsientoDeTramo(tramo3));
		assertEquals(1, this.pasaje1.getNroAsientoDeTramo(tramo4));

		this.pasaje1.removeTramo(tramo3);
		assertEquals(0, this.pasaje1.getNroAsientoDeTramo(tramo1));
		assertEquals(-1, this.pasaje1.getNroAsientoDeTramo(tramo2));
		assertEquals(-1, this.pasaje1.getNroAsientoDeTramo(tramo3));
		assertEquals(1, this.pasaje1.getNroAsientoDeTramo(tramo4));
	}

	@Test
	public void testGetRateRoundTrip() {
		assertEquals(0, this.pasaje1.getRateRoundTrip());

		this.pasaje1.addTramo(tramo1, 0);
		assertEquals(1, this.pasaje1.getRateRoundTrip());

		this.pasaje1.addTramo(tramo2, 0);
		assertEquals(1, this.pasaje1.getRateRoundTrip());

		this.pasaje1.addTramo(tramo3, 0);
		assertEquals(1, this.pasaje1.getRateRoundTrip());

		this.pasaje1.addTramo(tramo4, 0);
		assertEquals(0.95, this.pasaje1.getRateRoundTrip());
	}

	@Test
	public void testGetRateMultiHop() {
		assertEquals(0, this.pasaje1.getRateMultiHop());

		this.pasaje1.addTramo(tramo1, 0);
		assertEquals(1, this.pasaje1.getRateMultiHop());

		this.pasaje1.addTramo(tramo2, 0);
		assertEquals(1, this.pasaje1.getRateMultiHop());

		this.pasaje1.addTramo(tramo3, 0);
		assertEquals(0.93, this.pasaje1.getRateMultiHop());
	}

	@Test
	public void testGetRateDiario() {
		Tramo tramoLunes = new Tramo(LocalDate.of(2024, 5, 20), vuelo4);
		Tramo tramoMartes = new Tramo(LocalDate.of(2024, 5, 21), vuelo4);
		Tramo tramoMiercoles = new Tramo(LocalDate.of(2024, 5, 22), vuelo4);
		Tramo tramoJueves = new Tramo(LocalDate.of(2024, 5, 23), vuelo4);
		Tramo tramoViernes = new Tramo(LocalDate.of(2024, 5, 24), vuelo4);
		// Vamos Argentina carajo :)
		Tramo tramoSabado = new Tramo(LocalDate.of(2024, 5, 25), vuelo4);
		Tramo tramoDomingo = new Tramo(LocalDate.of(2024, 5, 26), vuelo4);

		assertEquals(0, this.pasaje1.getRateDiario());

		this.pasaje1.addTramo(tramoLunes, 0);
		assertEquals(1, this.pasaje1.getRateDiario());
		this.pasaje1.removeTramo(tramoLunes);

		this.pasaje1.addTramo(tramoMartes, 0);
		assertEquals(1.01, this.pasaje1.getRateDiario());
		this.pasaje1.removeTramo(tramoMartes);

		this.pasaje1.addTramo(tramoMiercoles, 0);
		assertEquals(0.99, this.pasaje1.getRateDiario());
		this.pasaje1.removeTramo(tramoMiercoles);

		this.pasaje1.addTramo(tramoJueves, 0);
		assertEquals(0.95, this.pasaje1.getRateDiario());
		this.pasaje1.removeTramo(tramoJueves);

		this.pasaje1.addTramo(tramoViernes, 0);
		assertEquals(1, this.pasaje1.getRateDiario());
		this.pasaje1.removeTramo(tramoViernes);

		this.pasaje1.addTramo(tramoSabado, 0);
		assertEquals(1.01, this.pasaje1.getRateDiario());
		this.pasaje1.removeTramo(tramoSabado);

		this.pasaje1.addTramo(tramoDomingo, 0);
		assertEquals(1.01, this.pasaje1.getRateDiario());
		this.pasaje1.removeTramo(tramoDomingo);

		double rate = 1.00;

		this.pasaje1.addTramo(tramoLunes, 0);
		rate *= 1;
		assertEquals(rate, this.pasaje1.getRateDiario());

		this.pasaje1.addTramo(tramoMartes, 0);
		rate *= 1.01;
		assertEquals(rate, this.pasaje1.getRateDiario());

		this.pasaje1.addTramo(tramoMiercoles, 0);
		rate *= 0.99;
		assertEquals(rate, this.pasaje1.getRateDiario());

		this.pasaje1.addTramo(tramoJueves, 0);
		rate *= 0.95;
		assertEquals(rate, this.pasaje1.getRateDiario());

		this.pasaje1.addTramo(tramoViernes, 0);
		rate *= 1;
		assertEquals(rate, this.pasaje1.getRateDiario());

		this.pasaje1.addTramo(tramoSabado, 0);
		rate *= 1.01;
		assertEquals(rate, this.pasaje1.getRateDiario());

		this.pasaje1.addTramo(tramoDomingo, 0);
		rate *= 1.01;
		assertEquals(rate, this.pasaje1.getRateDiario());
	}

	@Test
	public void testGetCostoBase() {
		assertEquals(0, this.pasaje1.getCostoBase());

		double costoBase = 0;

		this.pasaje1.addTramo(tramo1, 0);
		costoBase += 12000;
		assertEquals(costoBase, this.pasaje1.getCostoBase());

		this.pasaje1.addTramo(tramo2, 0);
		costoBase += 15000;
		assertEquals(costoBase, this.pasaje1.getCostoBase());

		this.pasaje1.addTramo(tramo3, 0);
		costoBase += 15000;
		assertEquals(costoBase, this.pasaje1.getCostoBase());

		this.pasaje1.addTramo(tramo4, 0);
		costoBase += 12000;
		assertEquals(costoBase, this.pasaje1.getCostoBase());
	}

	@Test
	public void testGetPrecio() {
		assertEquals(0, this.pasaje1.getPrecio());

		double precio;

		this.pasaje1.addTramo(tramo1, 0);
		precio = 12000 * 1.01 * 1 * 1;
		assertEquals(precio, this.pasaje1.getPrecio());

		this.pasaje1.addTramo(tramo2, 0);
		precio = (12000 + 15000) * (1.01 * 1.01) * 1 * 1;
		assertEquals(precio, this.pasaje1.getPrecio());

		this.pasaje1.addTramo(tramo3, 0);
		precio = (12000 + 15000 + 15000) * (1.01 * 1.01 * 1.01) * 1 * 0.93;
		assertEquals(precio, this.pasaje1.getPrecio());

		this.pasaje1.addTramo(tramo4, 0);
		precio = (12000 + 15000 + 15000 + 12000) * (1.01 * 1.01 * 1.01 * 1.01) * 0.95 * 0.93;
		assertEquals(precio, this.pasaje1.getPrecio());
	}
}
