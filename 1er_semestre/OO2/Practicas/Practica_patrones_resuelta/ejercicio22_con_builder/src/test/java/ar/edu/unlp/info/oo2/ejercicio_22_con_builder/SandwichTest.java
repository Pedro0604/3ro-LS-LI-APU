package ar.edu.unlp.info.oo2.ejercicio_22_con_builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders.SandwichClasicoBuilder;
import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders.SandwichSinTACCBuilder;
import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders.SandwichVeganoBuilder;
import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders.SandwichVegetarianoBuilder;

public class SandwichTest {
	private Sandwich sinProblemas, vegetariano, vegano, celiaco;

	@BeforeEach
	void setUp() throws Exception {
		SubteWayDirector director = new SubteWayDirector();
		sinProblemas = director.construir(new SandwichClasicoBuilder());
		vegetariano = director.construir(new SandwichVegetarianoBuilder());
		vegano = director.construir(new SandwichVeganoBuilder());
		celiaco = director.construir(new SandwichSinTACCBuilder());
	}

	@Test
	public void testGetPrecio() {
		assertEquals(100 + 20 + 300 + 80, this.sinProblemas.getPrecio());
		assertEquals(120 + 200 + 100, this.vegetariano.getPrecio());
		assertEquals(100 + 20 + 500, this.vegano.getPrecio());
		assertEquals(150 + 18 + 250 + 200, this.celiaco.getPrecio());
	}
}
