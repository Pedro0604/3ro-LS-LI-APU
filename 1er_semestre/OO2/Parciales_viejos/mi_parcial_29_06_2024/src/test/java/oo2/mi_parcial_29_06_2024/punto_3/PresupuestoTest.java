package oo2.mi_parcial_29_06_2024.punto_3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oo2.mi_parcial_29_06_2024.DirectorNormal;
import oo2.mi_parcial_29_06_2024.Presupuesto;

public class PresupuestoTest {
	private Presupuesto presupuestoPlus;

	@BeforeEach
	void setUp() throws Exception {
		this.presupuestoPlus = new Presupuesto("Messi", new ConfiguracionPlus(), new DirectorNormal());
	}

	@Test
	public void testGetConsumo() {
		// Por como implementé Catalogo (solo para testear), cada componente tiene un
		// consumo de 10
		assertEquals(100, this.presupuestoPlus.getEquipo().getConsumo());
	}

	@Test
	public void testGetPrecio() {
		// Por como implementé Catalogo (solo para testear), cada componente tiene un
		// precio de 1000
		assertEquals(10000 * 1.21, this.presupuestoPlus.getEquipo().getPrecio());
	}
}
