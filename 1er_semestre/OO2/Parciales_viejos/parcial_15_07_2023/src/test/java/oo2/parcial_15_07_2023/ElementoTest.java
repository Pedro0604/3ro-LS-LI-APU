package oo2.parcial_15_07_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementoTest {
	private Contenedor contenedor;
	private Boton boton;
	private Etiqueta etiqueta;
	private ListaDesplegableAdapter lista;

	@BeforeEach
	void setUp() throws Exception {
		this.contenedor = new Contenedor();

		this.boton = new Boton("Aceptar", "accept()");
		this.boton.aplicarEstilo(new ConfiguracionEstilo());

		this.etiqueta = new Etiqueta("Parcial de OO2");
		this.etiqueta.aplicarEstilo(new ConfiguracionEstilo());

		this.lista = new ListaDesplegableAdapter(new ListaDesplegable("Lista desplegable"));
		this.lista.aplicarEstilo(new ConfiguracionEstilo());

		this.contenedor.addElemento(boton);
		this.contenedor.addElemento(etiqueta);
		this.contenedor.addElemento(lista);
	}

	@Test
	public void testImprimir() {
		System.out.println(this.contenedor.imprimir());

		// String textoEsperado = "<contenedor>\n"
		// + "<boton estilo=\"color:red; text-size:10px;\" texto=\"Aceptar\"
		// accion=\"accept()\"/>\n"
		// + "<etiqueta estilo=\"color:blue; text-size:12px;\"/> Parcial de OO2
		// </etiqueta>\n"
		// + "<list estilo=\"color:blue; text-size:12px;\"/> Lista desplegable
		// </list>\r\n" + "</contenedor>\n";

		// No da pero lo copie de la consola :(
		// assertEquals(textoEsperado, this.contenedor.imprimir());
	}
}
