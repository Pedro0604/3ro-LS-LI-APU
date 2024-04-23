package ar.edu.unlp.info.oo2.ejercicio17;

import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraDolares;
import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraPesos;
import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoFinanciero;

public class ProductoFinancieroTest {
	private ProductoFinanciero dls, pesos, pf, bajo, alto, p1, p2, p3, p4;

	@BeforeEach
	void setUp() throws Exception {
		dls = new CompraDolares(1000, 1050);
		pesos = new CompraPesos(1, 1);
		pf = new CompraDolares(0, 0);
		bajo = new CompraDolares(0, 0);
		alto = new CompraDolares(0, 0);
		p1 = new CompraDolares(0, 0);
		p2 = new CompraDolares(0, 0);
		p3 = new CompraDolares(0, 0);
		p4 = new CompraDolares(0, 0);
	}
}
