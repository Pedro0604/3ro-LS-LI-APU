package ar.edu.unlp.info.oo2.ejercicio19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio19.creators.ArqueroCreator;
import ar.edu.unlp.info.oo2.ejercicio19.creators.GuerreroCreator;
import ar.edu.unlp.info.oo2.ejercicio19.creators.MagoCreator;

public class PersonajeTest {
	Personaje gandalf, legolas, callateWarrior;

	@BeforeEach
	void setUp() throws Exception {
		gandalf = (new MagoCreator()).createPersonaje();
		legolas = (new ArqueroCreator()).createPersonaje();
		callateWarrior = (new GuerreroCreator()).createPersonaje();
	}

	@Test
	public void testEnfrentamiento() {
		gandalf.desafiarAMuerteA(gandalf);
		assertEquals(100, this.gandalf.getPuntosDeVida());

		gandalf.desafiarAMuerteA(callateWarrior);
		assertEquals(0, this.gandalf.getPuntosDeVida());
		assertEquals(87, this.callateWarrior.getPuntosDeVida());

		gandalf.desafiarAMuerteA(callateWarrior);
		assertEquals(0, this.gandalf.getPuntosDeVida());
		assertEquals(87, this.callateWarrior.getPuntosDeVida());

		legolas.desafiarAMuerteA(gandalf);
		assertEquals(0, this.gandalf.getPuntosDeVida());
		assertEquals(87, this.callateWarrior.getPuntosDeVida());

		legolas.desafiarAMuerteA(callateWarrior);
		assertEquals(0, this.legolas.getPuntosDeVida());
		assertEquals(61, this.callateWarrior.getPuntosDeVida());
	}
}
