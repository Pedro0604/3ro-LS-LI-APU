package ar.edu.unlp.info.oo2.ejercicio22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio22.creators.SandwichClasicoCreator;
import ar.edu.unlp.info.oo2.ejercicio22.creators.SandwichSinTACCCreator;
import ar.edu.unlp.info.oo2.ejercicio22.creators.SandwichVeganoCreator;
import ar.edu.unlp.info.oo2.ejercicio22.creators.SandwichVegetarianoCreator;

public class SandwichTest {
	private Sandwich sinProblemas, vegetariano, vegano, celiaco;

	@BeforeEach
	void setUp() throws Exception {
		sinProblemas = new SandwichClasicoCreator().createSandwich();
		vegetariano = new SandwichVegetarianoCreator().createSandwich();
		vegano = new SandwichVeganoCreator().createSandwich();
		celiaco = new SandwichSinTACCCreator().createSandwich();
	}

	@Test
	public void testGetPrecio() {
		assertEquals(100 + 20 + 300 + 80, this.sinProblemas.getPrecio());
		assertEquals(120 + 200 + 100, this.vegetariano.getPrecio());
		assertEquals(100 + 20 + 500, this.vegano.getPrecio());
		assertEquals(150 + 18 + 250 + 200, this.celiaco.getPrecio());
	}
}
