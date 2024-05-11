package ar.edu.unlp.info.oo2.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio17.creadores.CreadorProducto1;
import ar.edu.unlp.info.oo2.ejercicio17.creadores.CreadorProducto2;
import ar.edu.unlp.info.oo2.ejercicio17.creadores.CreadorProducto3;
import ar.edu.unlp.info.oo2.ejercicio17.creadores.CreadorProducto4;
import ar.edu.unlp.info.oo2.ejercicio17.membresias.Gold;
import ar.edu.unlp.info.oo2.ejercicio17.membresias.Silver;
import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraBonoAltoRiesgo;
import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraBonoBajoRiesgo;
import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraDolares;
import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraPesos;
import ar.edu.unlp.info.oo2.ejercicio17.productos.PlazoFijo;
import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoFinanciero;

public class ProductoFinancieroTest {
	private ProductoFinanciero dls, pesos, pf, bajo, alto, p1, p2, p3, p4;
	private Cliente silver, gold;

	@BeforeEach
	void setUp() throws Exception {
		dls = new CompraDolares(1000);
		pesos = new CompraPesos(0.001);
		pf = new PlazoFijo(40, 0.2);
		bajo = new CompraBonoBajoRiesgo(96);
		alto = new CompraBonoAltoRiesgo(96);
		p1 = new CreadorProducto1().crearProducto(1000, 0.001, 40, 0.2, 96, 96);
		p2 = new CreadorProducto2().crearProducto(1000, 0.001, 40, 0.2, 96, 96);
		p3 = new CreadorProducto3().crearProducto(1000, 0.001, 40, 0.2, 96, 96);
		p4 = new CreadorProducto4().crearProducto(1000, 0.001, 40, 0.2, 96, 96);

		silver = new Cliente(new Silver());
		gold = new Cliente(new Gold());
	}

	@Test
	public void testProducto1() {
		silver.addProducto(p1);
		assertEquals(1 + 1020.19 + 1_000_000, silver.retornoInversion(1000), 0.1);
	}
}
