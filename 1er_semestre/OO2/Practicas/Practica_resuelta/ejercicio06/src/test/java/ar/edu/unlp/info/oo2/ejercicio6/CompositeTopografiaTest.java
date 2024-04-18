package ar.edu.unlp.info.oo2.ejercicio6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompositeTopografiaTest {
	private CompositeTopografia ct;

	@BeforeEach
	void setUp() throws Exception {
		this.ct = new CompositeTopografia();
	}

	@Test
	public void testAddTopografia() {
		assertTrue(this.ct.addTopografia(new Agua()));
		assertTrue(this.ct.addTopografia(new Tierra()));
		assertTrue(this.ct.addTopografia(new Tierra()));
		assertTrue(this.ct.addTopografia(new Agua()));
		assertEquals(4, this.ct.getChildCount());
		assertFalse(this.ct.addTopografia(new Tierra()));
		assertEquals(4, this.ct.getChildCount());
	}

	public void createTopografiaC(CompositeTopografia ct) {
		ct.removeAllTopografias();

		ct.addTopografia(new Agua());
		ct.addTopografia(new Tierra());
		ct.addTopografia(new Tierra());
		ct.addTopografia(new Agua());
	}

	public void createTopografiaD(CompositeTopografia ct) {
		ct.removeAllTopografias();

		ct.addTopografia(new Agua());
		ct.addTopografia(new Tierra());
		ct.addTopografia(new Tierra());

		CompositeTopografia ct2 = new CompositeTopografia();
		ct2.addTopografia(new Agua());
		ct2.addTopografia(new Tierra());
		ct2.addTopografia(new Tierra());
		ct2.addTopografia(new Agua());

		ct.addTopografia(ct2);
	}

	@Test
	public void testGetProporcionAgua() {
		this.createTopografiaC(this.ct);
		assertEquals(0.5, this.ct.getProporcionAgua());

		this.createTopografiaD(this.ct);
		assertEquals(0.375, this.ct.getProporcionAgua());
	}

	@Test
	public void testIsEqualTo() {
		this.createTopografiaC(this.ct);

		CompositeTopografia compuesta = new CompositeTopografia();
		this.createTopografiaC(compuesta);

		assertTrue(this.ct.isEqualTo(compuesta));
		assertTrue(compuesta.isEqualTo(this.ct));

		this.createTopografiaD(this.ct);
		this.createTopografiaD(compuesta);

		assertTrue(this.ct.isEqualTo(compuesta));
		assertTrue(compuesta.isEqualTo(this.ct));

		// Testeo de comparacion entre topografias con la misma
		// proporcion de agua pero diferente disposición
		this.createTopografiaC(this.ct);

		compuesta.removeAllTopografias();

		// Notar que estas topografias estan en distinto orden
		// que las topografias añadidas a this.ct en createTopografiaC()
		compuesta.addTopografia(new Agua());
		compuesta.addTopografia(new Tierra());
		compuesta.addTopografia(new Agua());
		compuesta.addTopografia(new Tierra());

		assertFalse(this.ct.isEqualTo(compuesta));
		assertFalse(compuesta.isEqualTo(this.ct));

		this.createTopografiaD(this.ct);

		compuesta.removeAllTopografias();

		// Notar que estas topografias estan en distinto orden
		// que las topografias añadidas a this.ct en createTopografiaD()
		compuesta.addTopografia(new Agua());
		compuesta.addTopografia(new Tierra());
		compuesta.addTopografia(new Tierra());

		CompositeTopografia compuesta2 = new CompositeTopografia();
		compuesta2.addTopografia(new Agua());
		compuesta2.addTopografia(new Tierra());
		compuesta2.addTopografia(new Agua());
		compuesta2.addTopografia(new Tierra());

		compuesta.addTopografia(compuesta2);

		assertFalse(this.ct.isEqualTo(compuesta));
		assertFalse(compuesta.isEqualTo(this.ct));

		this.createTopografiaD(this.ct);

		compuesta.removeAllTopografias();

		// Notar que estas topografias estan en distinto orden
		// que las topografias añadidas a this.ct en createTopografiaD()
		compuesta.addTopografia(new Agua());
		compuesta.addTopografia(new Tierra());

		compuesta2.removeAllTopografias();

		compuesta2.addTopografia(new Agua());
		compuesta2.addTopografia(new Tierra());
		compuesta2.addTopografia(new Tierra());
		compuesta2.addTopografia(new Agua());

		compuesta.addTopografia(compuesta2);

		compuesta.addTopografia(new Tierra());

		assertFalse(this.ct.isEqualTo(compuesta));
		assertFalse(compuesta.isEqualTo(this.ct));
	}
}
