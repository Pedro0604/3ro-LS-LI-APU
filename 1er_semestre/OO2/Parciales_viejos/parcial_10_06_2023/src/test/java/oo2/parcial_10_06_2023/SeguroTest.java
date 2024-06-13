package oo2.parcial_10_06_2023;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeguroTest {
	private Persona jose;

	@BeforeEach
	void setUp() throws Exception {
		jose = new Persona("José", 50);
		jose.setPromocion(new SinPromocion(jose));
		Vehiculo renault11 = new Vehiculo(680_000, 1988, 4);
		renault11.setSeguro(new SeguroContraTerceros(renault11));
		jose.addVehiculo(renault11);

		Vehiculo clio = new Vehiculo(1_200_000, 2001, 5);
		clio.setSeguro(new SeguroContraTerceros(clio));
		jose.addVehiculo(clio);
	}

	@Test
	public void testParcial() {
		double expectedCosto = 50 * 100 + 1000 + 0.01 * 680_000 + 0.005 * 680_000;
		expectedCosto += 50 * 100 + 1000 + 0.01 * 1_200_000 + 0.005 * 1_200_000;
		assertEquals(expectedCosto, this.jose.getCostoSeguros());
	}
}
