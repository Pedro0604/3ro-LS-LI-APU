package ar.edu.unlp.info.oo2.ejercicio6_b;

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

	public void createTopografiaConPantano(CompositeTopografia ct) {
		ct.removeAllTopografias();

		ct.addTopografia(new Agua());
		ct.addTopografia(new Tierra());
		ct.addTopografia(new Pantano());

		CompositeTopografia ct2 = new CompositeTopografia();
		ct2.addTopografia(new Agua());
		ct2.addTopografia(new Tierra());
		ct2.addTopografia(new Pantano());
		ct2.addTopografia(new Agua());

		ct.addTopografia(ct2);
	}

	public void createTopografiaConPantanoSimilar(CompositeTopografia ct) {
		ct.removeAllTopografias();

		ct.addTopografia(new Agua());
		ct.addTopografia(new Tierra());
		ct.addTopografia(new Pantano());

		// Notar que esta topografia difiere de la creada en
		// createTopografiaConPantano() en el orden de las
		// topografias de ct2
		CompositeTopografia ct2 = new CompositeTopografia();
		ct2.addTopografia(new Agua());
		ct2.addTopografia(new Tierra());
		ct2.addTopografia(new Agua());
		ct2.addTopografia(new Pantano());

		ct.addTopografia(ct2);
	}

	@Test
	public void testGetProporcionAgua() {
		this.createTopografiaConPantano(this.ct);
		assertEquals(0.59375, this.ct.getProporcionAgua());

		this.createTopografiaConPantanoSimilar(this.ct);
		assertEquals(0.59375, this.ct.getProporcionAgua());
	}

	@Test
	public void testIsEqualTo() {
		this.createTopografiaConPantano(this.ct);

		CompositeTopografia compuesta = new CompositeTopografia();
		this.createTopografiaConPantano(compuesta);

		assertTrue(this.ct.isEqualTo(compuesta));
		assertTrue(compuesta.isEqualTo(this.ct));

		// Testeo de comparacion entre topografias con la misma
		// proporcion de agua pero diferente disposición
		this.createTopografiaConPantano(this.ct);

		this.createTopografiaConPantanoSimilar(compuesta);

		assertFalse(this.ct.isEqualTo(compuesta));
		assertFalse(compuesta.isEqualTo(this.ct));
	}
}
