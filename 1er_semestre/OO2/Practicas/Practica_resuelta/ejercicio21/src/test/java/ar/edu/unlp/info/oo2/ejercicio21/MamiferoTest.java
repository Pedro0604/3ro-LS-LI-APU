package ar.edu.unlp.info.oo2.ejercicio21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MamiferoTest {
	private Mamifero nala;
	private Mamifero melquiades;
	private Mamifero mufasa;
	private Mamifero alexa;
	private Mamifero elsa;
	private Mamifero scar;
	private Mamifero sarabi;
	private Mamifero anonimo;

	@BeforeEach
	void setUp() {
		nala = new Mamifero("Nala");
		melquiades = new Mamifero("Melquiades");
		mufasa = new Mamifero("Mufasa");
		alexa = new Mamifero("Alexa");
		elsa = new Mamifero("Elsa");
		scar = new Mamifero("Scar");
		sarabi = new Mamifero("Sarabi");
		anonimo = new Mamifero();

		alexa.setPadre(mufasa);
		alexa.setMadre(sarabi);
		mufasa.setPadre(melquiades);
		mufasa.setMadre(nala);
		sarabi.setPadre(scar);
		sarabi.setMadre(elsa);

	}

	@Test
	void testAbuelaMaterna() {
		assertEquals(elsa, alexa.getAbuelaMaterna());
		assertTrue(sarabi.getAbuelaMaterna() instanceof NullMamifero);
		assertTrue(elsa.getAbuelaMaterna() instanceof NullMamifero);
	}

	@Test
	void testAbuelaPaterna() {
		assertEquals(nala, alexa.getAbuelaPaterna());
		assertTrue(mufasa.getAbuelaPaterna() instanceof NullMamifero);
		assertTrue(nala.getAbuelaPaterna() instanceof NullMamifero);

	}

	@Test
	void testAbueloMaterno() {
		assertEquals(scar, alexa.getAbueloMaterno());
		assertTrue(sarabi.getAbueloMaterno() instanceof NullMamifero);
		assertTrue(scar.getAbueloMaterno() instanceof NullMamifero);

	}

	@Test
	void testAbueloPaterno() {
		assertEquals(melquiades, alexa.getAbueloPaterno());
		assertTrue(mufasa.getAbueloPaterno() instanceof NullMamifero);
		assertTrue(melquiades.getAbueloPaterno() instanceof NullMamifero);

	}

	@Test
	void testEspecie() {
		anonimo.setEspecie("Panthera leo");
		assertEquals("Panthera leo", anonimo.getEspecie());
	}

	@Test
	void testIdentificador() {
		anonimo.setIdentificador("Nala");
		assertEquals("Nala", anonimo.getIdentificador());
	}

	@Test
	void testMadre() {
		anonimo.setMadre(alexa);
		assertEquals(alexa, anonimo.getMadre());
		assertTrue(nala.getMadre() instanceof NullMamifero);
	}

	@Test
	void testPadre() {
		anonimo.setPadre(mufasa);
		assertEquals(mufasa, anonimo.getPadre());
		assertTrue(nala.getPadre() instanceof NullMamifero);
	}

	@Test
	void testTieneComoAncestroA() {
		assertFalse(nala.tieneComoAncestroA(anonimo));
		assertFalse(mufasa.tieneComoAncestroA(anonimo));
		assertFalse(alexa.tieneComoAncestroA(anonimo));
		assertFalse(alexa.tieneComoAncestroA(alexa));
		assertTrue(alexa.tieneComoAncestroA(mufasa));
		assertTrue(alexa.tieneComoAncestroA(sarabi));
		assertTrue(alexa.tieneComoAncestroA(nala));
		assertTrue(alexa.tieneComoAncestroA(melquiades));
		assertTrue(alexa.tieneComoAncestroA(elsa));
		assertTrue(alexa.tieneComoAncestroA(scar));

	}

}
