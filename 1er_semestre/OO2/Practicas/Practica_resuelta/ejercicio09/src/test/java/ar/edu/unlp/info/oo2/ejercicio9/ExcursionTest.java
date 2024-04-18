package ar.edu.unlp.info.oo2.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExcursionTest {
	Excursion e;
	Usuario pepe, messi, fatiga, paola;

	@BeforeEach
	void setUp() throws Exception {
		e = new Excursion("Dos días en kayak bajando el Paraná", LocalDate.of(2024, 10, 12), LocalDate.of(2025, 12, 2),
				"Casa de Messi", 500_000, 1, 3);
		pepe = new Usuario("Pepe", "Argento", "pepeargento@gmail.com");
		messi = new Usuario("Lionel", "Messi", "leomessi10@gmail.com");
		fatiga = new Usuario("Fatiga", "Argento", "guauguau@gmail.com");
		paola = new Usuario("Paola", "Argento", "gmail@paolaargento.com");
	}

	@Test
	public void testInscribirUsuario() {
		assertEquals(0, this.e.getCantUsuarios());
		System.out.println(this.e.toString());

		this.e.inscribirUsuario(pepe);
		assertEquals(1, this.e.getCantUsuarios());
		System.out.println(this.e.toString());

		this.e.inscribirUsuario(messi);
		assertEquals(2, this.e.getCantUsuarios());
		System.out.println(this.e.toString());

		this.e.inscribirUsuario(fatiga);
		assertEquals(3, this.e.getCantUsuarios());
		System.out.println(this.e.toString());

		assertEquals(0, this.e.getListaEspera().size());
		this.e.inscribirUsuario(paola);
		assertEquals(3, this.e.getCantUsuarios());
		assertEquals(1, this.e.getListaEspera().size());
		System.out.println(this.e.toString());
	}
}
