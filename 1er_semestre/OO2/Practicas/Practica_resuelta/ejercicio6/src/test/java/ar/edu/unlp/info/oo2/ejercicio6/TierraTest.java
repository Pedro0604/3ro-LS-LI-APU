package ar.edu.unlp.info.oo2.ejercicio6;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TierraTest {
	private Tierra t;

	@BeforeEach
	void setUp() throws Exception {
		this.t = new Tierra();
	}

	@Test
	public void testIsEqualTo() {
		CompositeTopografia compuesta = new CompositeTopografia();
		compuesta.addTopografia(new Tierra());

		assertFalse(this.t.isEqualTo(compuesta));
		assertFalse(compuesta.isEqualTo(this.t));

		compuesta.addTopografia(new Tierra());
		compuesta.addTopografia(new Tierra());
		compuesta.addTopografia(new Tierra());

		assertFalse(this.t.isEqualTo(compuesta));
		assertFalse(compuesta.isEqualTo(this.t));

		assertTrue(this.t.isEqualTo(new Tierra()));
	}
}
