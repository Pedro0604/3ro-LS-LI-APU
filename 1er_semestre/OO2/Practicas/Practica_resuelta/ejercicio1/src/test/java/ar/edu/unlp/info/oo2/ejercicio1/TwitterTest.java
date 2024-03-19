package ar.edu.unlp.info.oo2.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwitterTest {

	private Twitter tweety;

	@BeforeEach
	void setUp() throws Exception {
		tweety = new Twitter();
	}

	@Test
	public void testRegistrarUsuario() {
		tweety.registrarUsuario("pepe");
		assertEquals(1, tweety.getUsuarios().size());
	}

	@Test
	public void testRegistrarUsuariosIguales() {
		tweety.registrarUsuario("pepe");
		assertNull(tweety.registrarUsuario("pepe"));
		assertEquals(1, tweety.getUsuarios().size());
	}

	@Test
	public void testEliminarUsuario() {
		Usuario u = tweety.registrarUsuario("pepe");
		Tweet t = u.tweet("hola");
		u.reTweet(t);
		u.tweet("chauu");
		assertTrue(tweety.eliminarUsuario("pepe"));
		assertEquals(0, tweety.getUsuarios().size());
	}

	@Test
	public void testEliminarUsuarioInexistente() {
		Usuario u = tweety.registrarUsuario("pepe");
		assertFalse(tweety.eliminarUsuario("jose"));
		assertEquals(1, tweety.getUsuarios().size());
	}
}
