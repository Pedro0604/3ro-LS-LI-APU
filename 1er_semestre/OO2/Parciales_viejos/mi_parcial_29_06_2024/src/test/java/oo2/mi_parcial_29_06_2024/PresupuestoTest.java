package oo2.mi_parcial_29_06_2024;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PresupuestoTest {
	private Presupuesto presupuestoBasico, presupuestoIntermedio, presupuestoGamer;

	@BeforeEach
	void setUp() throws Exception {
		this.presupuestoBasico = new Presupuesto("Messi", new ConfiguracionBasica(), new DirectorNormal());
		this.presupuestoIntermedio = new Presupuesto("Messi", new ConfiguracionIntermedia(), new DirectorNormal());
		this.presupuestoGamer = new Presupuesto("Messi", new ConfiguracionGamer(), new DirectorNormal());
	}

	@Test
	public void testGetConsumo() {
		// Por como implementé Catalogo (solo para testear), cada componente tiene un
		// consumo de 10
		assertEquals(40, this.presupuestoBasico.getEquipo().getConsumo());
		assertEquals(60, this.presupuestoIntermedio.getEquipo().getConsumo());
		assertEquals(100, this.presupuestoGamer.getEquipo().getConsumo());
	}

	@Test
	public void testGetPrecio() {
		// Por como implementé Catalogo (solo para testear), cada componente tiene un
		// precio de 1000
		assertEquals(4000 * 1.21, this.presupuestoBasico.getEquipo().getPrecio());
		assertEquals(6000 * 1.21, this.presupuestoIntermedio.getEquipo().getPrecio());
		assertEquals(10000 * 1.21, this.presupuestoGamer.getEquipo().getPrecio());
	}
}
