package ar.edu.unlp.info.oo2.ejercicio19_b;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio19_b.creators.ArqueroCreator;
import ar.edu.unlp.info.oo2.ejercicio19_b.creators.CreaThOOr;
import ar.edu.unlp.info.oo2.ejercicio19_b.creators.CuranderoCreator;
import ar.edu.unlp.info.oo2.ejercicio19_b.creators.GuerreroCreator;
import ar.edu.unlp.info.oo2.ejercicio19_b.creators.MagoCreator;

public class PersonajeTest {
	Personaje gandalf, legolas, callateWarrior, mercy, thOOr;

	@BeforeEach
	void setUp() throws Exception {
		gandalf = (new MagoCreator()).createPersonaje("Gandalf");
		legolas = (new ArqueroCreator()).createPersonaje("Legolas");
		callateWarrior = (new GuerreroCreator()).createPersonaje("Cállate warrior");
		mercy = (new CuranderoCreator()).createPersonaje("Mercy");
		thOOr = (new CreaThOOr()).createPersonaje("ThOOr");
	}

	@Test
	public void testEnfrentamiento() {
		thOOr.desafiarAMuerteA(callateWarrior);
		thOOr.desafiarAMuerteA(mercy);
		thOOr.desafiarAMuerteA(legolas);
		thOOr.desafiarAMuerteA(gandalf);
		assertTrue(thOOr.tieneVida());
	}
}
