package ar.edu.unlp.info.oo2.ejercicio23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AerOOlineaTest {
	private AerOOlinea aerOOlinea;
	private Pasaje pasaje1, pasaje2;
	private Pasajero pasajero1, pasajero2;
	private Tramo tramo1, tramo2, tramo3, tramo4, tramo20Mayo, tramo1Mayo;
	private Vuelo vuelo1, vuelo2, vuelo3, vuelo4;
	private Avion avion1, avion2;
	private final boolean[] FRECUENCIA_DIARIA = new boolean[] { true, true, true, true, true, true, true };

	@BeforeEach
	void setUp() throws Exception {
		aerOOlinea = new AerOOlinea();

		avion1 = new Avion("Pilatus PC-12", 6, 1500);
		aerOOlinea.addAvion(avion1);

		avion2 = new Avion("Pilatus PC-12", 9, 1500);
		aerOOlinea.addAvion(avion2);

		vuelo1 = new Vuelo("UF101", "La Plata", "Balcarce", LocalTime.of(7, 0), LocalTime.of(8, 0), 12000,
				FRECUENCIA_DIARIA, avion1);
		aerOOlinea.addVuelo(vuelo1);

		vuelo2 = new Vuelo("UF102", "Balcarce", "Pergamino", LocalTime.of(9, 0), LocalTime.of(10, 30), 15000,
				FRECUENCIA_DIARIA, avion1);
		aerOOlinea.addVuelo(vuelo2);

		vuelo3 = new Vuelo("UF202", "Pergamino", "Balcarce", LocalTime.of(17, 0), LocalTime.of(18, 30), 15000,
				FRECUENCIA_DIARIA, avion1);
		aerOOlinea.addVuelo(vuelo3);

		vuelo4 = new Vuelo("UF203", "Balcarce", "La Plata", LocalTime.of(20, 0), LocalTime.of(21, 0), 12000,
				FRECUENCIA_DIARIA, avion1);
		aerOOlinea.addVuelo(vuelo4);

		// 18/05/2024 fue sábado
		tramo1 = new Tramo(LocalDate.of(2024, 5, 18), vuelo1);
		tramo2 = new Tramo(LocalDate.of(2024, 5, 18), vuelo2);
		tramo3 = new Tramo(LocalDate.of(2024, 5, 18), vuelo3);
		tramo4 = new Tramo(LocalDate.of(2024, 5, 18), vuelo4);
		tramo20Mayo = new Tramo(LocalDate.of(2024, 5, 20), vuelo1);
		tramo1Mayo = new Tramo(LocalDate.of(2024, 5, 1), vuelo1);

		pasajero1 = new Pasajero("Pepe", 12341234);
		pasaje1 = new Pasaje(pasajero1);
		aerOOlinea.addPasaje(pasaje1);

		pasajero2 = new Pasajero("Papa", 23452345);
		pasaje2 = new Pasaje(pasajero2);
		aerOOlinea.addPasaje(pasaje2);
	}

	@Test
	public void testGetPromedioOcupacionEnPeriodo() {
		assertEquals(0,
				aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje1.addTramo(tramo1, 0);
		assertEquals(0.1666,
				aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)),
				0.001);

		pasaje1.addTramo(tramo20Mayo, 0);
		assertEquals(0.1666,
				aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)),
				0.001);

		pasaje1.addTramo(tramo1Mayo, 0);
		assertEquals(0.1666,
				aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)),
				0.001);

		pasaje2.addTramo(tramo1, 1);
		assertEquals(0.2222,
				aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)),
				0.001);

		// No toma en cuenta el tramo del 1 de mayo
		assertEquals(0.25,
				aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 31)));

		// Solo toma en cuenta el tramo del 18 de mayo
		assertEquals(0.3333,
				aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 19)),
				0.001);
	}

	@Test
	public void testGetHorasVoladasEnPeriodo() {
		assertEquals(0,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje1.addTramo(tramo1, 0);
		assertEquals(1,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje1.addTramo(tramo2, 0);
		assertEquals(2.5,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje1.addTramo(tramo3, 0);
		assertEquals(4,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje1.addTramo(tramo4, 0);
		assertEquals(5,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje2.addTramo(tramo1, 1);
		assertEquals(6,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje1.addTramo(tramo20Mayo, 0);
		assertEquals(7,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		pasaje1.addTramo(tramo1Mayo, 0);
		assertEquals(8,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));

		// No toma en cuenta el tramo del 1 de mayo
		assertEquals(7,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 31)));

		// Solo toma en cuenta los tramos del 18 de mayo
		assertEquals(6,
				aerOOlinea.getHorasVoladasEnPeriodo(avion1, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 19)));

		assertEquals(0,
				aerOOlinea.getHorasVoladasEnPeriodo(avion2, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31)));
	}

	@Test
	public void testGetHorasVoladasEnTotal() {
		assertEquals(0, aerOOlinea.getHorasVoladasEnTotal(avion1));

		pasaje1.addTramo(tramo1, 0);
		assertEquals(1, aerOOlinea.getHorasVoladasEnTotal(avion1));

		pasaje1.addTramo(tramo2, 0);
		assertEquals(2.5, aerOOlinea.getHorasVoladasEnTotal(avion1));

		pasaje1.addTramo(tramo3, 0);
		assertEquals(4, aerOOlinea.getHorasVoladasEnTotal(avion1));

		pasaje1.addTramo(tramo4, 0);
		assertEquals(5, aerOOlinea.getHorasVoladasEnTotal(avion1));

		pasaje2.addTramo(tramo1, 1);
		assertEquals(6, aerOOlinea.getHorasVoladasEnTotal(avion1));

		pasaje1.addTramo(tramo20Mayo, 0);
		assertEquals(7, aerOOlinea.getHorasVoladasEnTotal(avion1));

		pasaje1.addTramo(tramo1Mayo, 0);
		assertEquals(8, aerOOlinea.getHorasVoladasEnTotal(avion1));

		assertEquals(0, aerOOlinea.getHorasVoladasEnTotal(avion2));
	}

	@Test
	public void testGetMontoTotalDescuentos() {
		double costoBase = 0;
		double descuentos = 0;
		assertEquals(costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());

		this.pasaje1.addTramo(tramo1, 0);
		costoBase += 12_000;
		descuentos = 0;
		assertEquals(costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());

		this.pasaje1.addTramo(tramo2, 0);
		costoBase += 15_000;
		descuentos = 0;
		assertEquals(costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());

		this.pasaje1.addTramo(tramo3, 0);
		costoBase += 15_000;
		descuentos = (1 - 0.93);
		assertEquals(costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());

		this.pasaje1.addTramo(tramo4, 0);
		costoBase += 12_000;
		descuentos = (1 - 0.93) * (1 - 0.95);
		assertEquals(costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());
		double montoDescuentosPasaje1 = costoBase * descuentos;

		this.pasaje2.addTramo(tramo1, 1);
		costoBase = 12_000;
		descuentos = 0;
		assertEquals(montoDescuentosPasaje1 + costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());

		this.pasaje2.addTramo(tramo2, 1);
		costoBase += 15_000;
		descuentos = 0;
		assertEquals(montoDescuentosPasaje1 + costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());

		this.pasaje2.addTramo(tramo3, 1);
		costoBase += 15_000;
		descuentos = (1 - 0.93);
		assertEquals(montoDescuentosPasaje1 + costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());

		this.pasaje2.addTramo(tramo4, 1);
		costoBase += 12_000;
		descuentos = (1 - 0.93) * (1 - 0.95);
		assertEquals(montoDescuentosPasaje1 + costoBase * descuentos, this.aerOOlinea.getMontoTotalDescuentos());
	}

	@Test
	public void testGetEficienciaTarifas() {
		double facturado = 0;
		double costoBase = 0;
		assertEquals(facturado / costoBase, this.aerOOlinea.getEficienciaTarifas());

		this.pasaje1.addTramo(tramo1, 0);
		facturado = 12_000 * 1.01 * 1 * 1;
		costoBase += 12_000;
		assertEquals(facturado / costoBase, this.aerOOlinea.getEficienciaTarifas());

		this.pasaje1.addTramo(tramo2, 0);
		facturado = (12_000 + 15_000) * (1.01 * 1.01) * 1 * 1;
		costoBase += 15_000;
		assertEquals(facturado / costoBase, this.aerOOlinea.getEficienciaTarifas());

		this.pasaje1.addTramo(tramo3, 0);
		facturado = (12_000 + 15_000 + 15_000) * (1.01 * 1.01 * 1.01) * 1 * 0.93;
		costoBase += 15_000;
		assertEquals(facturado / costoBase, this.aerOOlinea.getEficienciaTarifas());

		this.pasaje1.addTramo(tramo4, 0);
		facturado = (12_000 + 15_000 + 15_000 + 12_000) * (1.01 * 1.01 * 1.01 * 1.01) * 0.95 * 0.93;
		costoBase += 12_000;
		assertEquals(facturado / costoBase, this.aerOOlinea.getEficienciaTarifas());
	}
}
