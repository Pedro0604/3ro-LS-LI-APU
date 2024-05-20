package ar.edu.unlp.info.oo2.ejercicio23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AerOOlineaTest {
	private AerOOlinea aerOOlinea;
	private Pasaje pasaje1, pasaje2;
	private Pasajero pasajero1, pasajero2;
	private Tramo tramo1, tramo2, tramo3, tramo4, tramo20Mayo, tramo1Mayo;
	private Vuelo vuelo1, vuelo2, vuelo3, vuelo4;
	private Avion avion;
	private final boolean[] FRECUENCIA_DIARIA = new boolean[] { true, true, true, true, true, true, true };

	@BeforeEach
	void setUp() throws Exception {
		aerOOlinea = new AerOOlinea();

		avion = new Avion("Pilatus PC-12", 6, 1500);
		aerOOlinea.addAvion(avion);

		vuelo1 = new Vuelo("UF101", "La Plata", "Balcarce", LocalTime.of(7, 0), LocalTime.of(8, 0), 12000,
				FRECUENCIA_DIARIA, avion);
		aerOOlinea.addVuelo(vuelo1);

		vuelo2 = new Vuelo("UF102", "Balcarce", "Pergamino", LocalTime.of(9, 0), LocalTime.of(10, 30), 15000,
				FRECUENCIA_DIARIA, avion);
		aerOOlinea.addVuelo(vuelo2);

		vuelo3 = new Vuelo("UF202", "Pergamino", "Balcarce", LocalTime.of(17, 0), LocalTime.of(18, 30), 15000,
				FRECUENCIA_DIARIA, avion);
		aerOOlinea.addVuelo(vuelo3);

		vuelo4 = new Vuelo("UF203", "Balcarce", "La Plata", LocalTime.of(20, 0), LocalTime.of(21, 0), 12000,
				FRECUENCIA_DIARIA, avion);
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
		assertEquals(0, aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1,
				Period.between(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31))));

		pasaje1.addTramo(tramo1, 0);
		assertEquals(0.3333, aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1,
				Period.between(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31))), 0.01);

		pasaje1.addTramo(tramo20Mayo, 0);
		assertEquals(0.6666, aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1,
				Period.between(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31))), 0.01);

		pasaje1.addTramo(tramo1Mayo, 0);
		assertEquals(1, aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1,
				Period.between(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31))), 0.01);

		pasaje2.addTramo(tramo1, 0);
		assertEquals(1.3333, aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1,
				Period.between(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31))), 0.01);

		// No toma en cuenta el tramo del 1 de mayo
		assertEquals(1.5, aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1,
				Period.between(LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 31))), 0.01);

		// Solo toma en cuenta el tramo del 18 de mayo
		assertEquals(2, aerOOlinea.getPromedioOcupacionEnPeriodo(vuelo1,
				Period.between(LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 19))), 0.01);
	}

	// TODO - AGREGAR TESTS PARA EL RESTO DE ESTADÍSTICAS DE AEROOLINEA
}
