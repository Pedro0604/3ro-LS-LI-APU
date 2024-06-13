package oo2.mi_parcial_08_06_2024;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrestamoTest {
	private Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		this.cliente = new Cliente("Pepe", 5000);
	}

	@Test
	public void testSolicitarPrestamoSimple() {
		Prestamo prestamo = this.cliente.solicitarPrestamoSimple(100, 10, 0.05);
		assertEquals(0, prestamo.getMontoAbonado());
		assertEquals(10, prestamo.getCuotasRestantes());
		double montoCuota = (100 / 10) * 0.05;
		assertEquals(montoCuota, prestamo.getMontoCuota());
		assertEquals(montoCuota * 10, prestamo.getMontoRestante());
		double gastoCancelacion = montoCuota * 10 + montoCuota * 10 * 0.1 + 5000;
		assertEquals(gastoCancelacion, prestamo.gastoCancelacion());
	}
}
