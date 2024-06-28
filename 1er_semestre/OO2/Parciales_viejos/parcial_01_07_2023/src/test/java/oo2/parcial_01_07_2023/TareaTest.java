package oo2.parcial_01_07_2023;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TareaTest {
	private TareaCompleja almuerzo, compras;
	private TareaSimple mercado, verdu, cocinar, mesa;

	@BeforeEach
	void setUp() throws Exception {
		this.almuerzo = new TareaCompleja("Preparar almuerzo");

		this.compras = new TareaCompleja("Realizar compras");

		this.mercado = new TareaSimple("Ir al supermercado", 3000);
		this.verdu = new TareaSimple("Ir a la verduleria", 1000);
		this.cocinar = new TareaSimple("Cocinar", 2000);
		this.mesa = new TareaSimple("Preparar la mesa", 1000);

		this.compras.addTarea(mercado);
		this.compras.addTarea(verdu);

		this.almuerzo.addTarea(compras);
		this.almuerzo.addTarea(cocinar);
		this.almuerzo.addTarea(mesa);

		this.mercado.iniciar();
		Thread.sleep(2000);
		this.mercado.completar();
		this.verdu.iniciar();
		Thread.sleep(1000);
		this.verdu.completar();
		this.cocinar.iniciar();
	}

	@Test
	public void testEstimacion() {
		assertEquals(3000, this.mercado.estimacionTotal());
		assertEquals(1000, this.verdu.estimacionTotal());
		assertEquals(2000, this.cocinar.estimacionTotal());
		assertEquals(1000, this.mesa.estimacionTotal());

		assertEquals(4000, this.compras.estimacionTotal());

		assertEquals(7000, this.almuerzo.estimacionTotal());
	}

	@Test
	public void testTiempoUtilizado() {
		assertEquals(2000, this.mercado.tiempoUtilizado(), 50);
		assertEquals(1000, this.verdu.tiempoUtilizado(), 50);
		assertEquals(0, this.cocinar.tiempoUtilizado());
		assertEquals(0, this.mesa.tiempoUtilizado());

		assertEquals(3000, this.compras.tiempoUtilizado(), 50);

		assertEquals(3000, this.almuerzo.tiempoUtilizado(), 50);
	}

	@Test
	public void testAvance() {
		assertEquals(2000 / 3000.0, this.mercado.avance(), 0.01);
		assertEquals(1000 / 1000.0, this.verdu.avance(), 0.01);
		assertEquals(0, this.cocinar.avance());
		assertEquals(0, this.mesa.avance());

		assertEquals(3000 / 4000.0, this.compras.avance(), 0.01);

		assertEquals(3000 / 7000.0, this.almuerzo.avance(), 0.01);
	}
}
