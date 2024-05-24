package ar.edu.unlp.info.oo2.facturacion_llamadas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {
	Empresa sistema;

	@BeforeEach
	public void setUp() {
		this.sistema = new Empresa();
		this.sistema.agregarNumeroTelefono("2214444554");
		this.sistema.agregarNumeroTelefono("2214444555");
		this.sistema.agregarNumeroTelefono("2214444556");
		this.sistema.agregarNumeroTelefono("2214444557");
		this.sistema.agregarNumeroTelefono("2214444558");
		this.sistema.agregarNumeroTelefono("2214444559");
	}

	@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarPersonaFisica("11555666", "Brendan Eich");
		Cliente remitentePersonaFisica = sistema.registrarPersonaFisica("00000001", "Doug Lea");
		Cliente emisorPersonaJuridica = sistema.registrarPersonaJuridica("17555222", "Nvidia Corp");
		Cliente remitentePersonaJuridica = sistema.registrarPersonaJuridica("25765432", "Sun Microsystems");

		emisorPersonaJuridica.registrarLlamadaNacional(remitentePersonaFisica, 10);
		emisorPersonaJuridica.registrarLlamadaInternacional(remitentePersonaFisica, 8);
		emisorPersonaJuridica.registrarLlamadaNacional(remitentePersonaJuridica, 5);
		emisorPersonaJuridica.registrarLlamadaInternacional(remitentePersonaJuridica, 7);
		emisorPersonaFisca.registrarLlamadaNacional(remitentePersonaFisica, 15);
		emisorPersonaFisca.registrarLlamadaInternacional(remitentePersonaFisica, 45);
		emisorPersonaFisca.registrarLlamadaNacional(remitentePersonaJuridica, 13);
		emisorPersonaFisca.registrarLlamadaInternacional(remitentePersonaJuridica, 17);

		assertEquals(11454.64, emisorPersonaFisca.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(2445.40, emisorPersonaJuridica.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(0, remitentePersonaFisica.calcularMontoTotalLlamadas());
		assertEquals(0, remitentePersonaJuridica.calcularMontoTotalLlamadas());
	}

	@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeUsuarios(), 0);
		this.sistema.agregarNumeroTelefono("2214444558");
		Cliente nuevaPersona = this.sistema.registrarPersonaFisica("2444555", "Alan Turing");

		assertEquals(1, this.sistema.cantidadDeUsuarios());
		assertTrue(this.sistema.existeUsuario(nuevaPersona));
	}

	@Test
	void obtenerNumeroLibre() {
		// por defecto es el ultimo
		assertEquals("2214444559", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().cambiarTipoGenerador(new StrategyPrimero());
		assertEquals("2214444554", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().cambiarTipoGenerador(new StrategyRandom());
		assertNotNull(this.sistema.obtenerNumeroLibre());
	}
}
