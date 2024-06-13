package oo2.parcial_25_06_2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExcursionTest {
	private Excursion excursion;

	@BeforeEach
	void setUp() throws Exception {
		this.excursion = new Excursion("Dos días en kayak bajando el Paraná", LocalDateTime.of(2023, 10, 5, 8, 0),
				LocalDateTime.of(2023, 10, 7, 8, 0), "Manaos", 200000, 1, 2);
	}

	@Test
	public void testInscribirUsuario() {
		assertEquals(0, this.excursion.getCantidadUsuarios());
		assertEquals("Provisoria", this.excursion.getState().getName());
		System.out.println(this.excursion.obtenerInformacion());

		this.excursion.inscribir(new Usuario("Pepe", "Gonzáles", "pepeg@gmail.com"));
		assertEquals(1, this.excursion.getCantidadUsuarios());
		assertEquals("Definitiva", this.excursion.getState().getName());
		System.out.println(this.excursion.obtenerInformacion());

		this.excursion.inscribir(new Usuario("Jose", "Gómez", "joseg@gmail.com"));
		assertEquals(2, this.excursion.getCantidadUsuarios());
		assertEquals("Completa", this.excursion.getState().getName());
		System.out.println(this.excursion.obtenerInformacion());

		assertEquals(0, this.excursion.getCantidadUsuariosListaDeEspera());
		this.excursion.inscribir(new Usuario("Esteban", "Quito", "banco@gmail.com"));
		assertEquals(2, this.excursion.getCantidadUsuarios());
		assertEquals(1, this.excursion.getCantidadUsuariosListaDeEspera());
		assertEquals("Completa", this.excursion.getState().getName());
		System.out.println(this.excursion.obtenerInformacion());
	}
}
