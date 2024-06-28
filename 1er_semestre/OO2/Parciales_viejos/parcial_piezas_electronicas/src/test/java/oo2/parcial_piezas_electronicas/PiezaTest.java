package oo2.parcial_piezas_electronicas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PiezaTest {
	private PiezaCompuesta notebook;
	private PiezaSimple CPU, GPU;

	@BeforeEach
	void setUp() throws Exception {
		this.notebook = new PiezaCompuesta("Notebook");

		this.CPU = new PiezaSimple("Core i7", 67, 95);
		this.GPU = new PiezaSimple("Tarjeta gráfica NVIDIA", 50, 30);

		this.notebook.addPieza(CPU);
		this.notebook.addPieza(GPU);
	}

	@Test
	public void testCapacidadBateria() {
		assertEquals((67 + 50) / 2.0, this.notebook.capacidadBateria());

		this.notebook.setConfiguracion(new MaximaPotencia());
		assertEquals(((67 + 50) / 2.0) * 1.5, this.notebook.capacidadBateria());

		this.notebook.setConfiguracion(new AhorroDeEnergia());
		assertEquals(((67 + 50) / 2.0) * 0.8, this.notebook.capacidadBateria());
	}

	@Test
	public void testPotencia() {
		assertEquals((95 + 30) / 2.0, this.notebook.potencia());

		this.notebook.setConfiguracion(new MaximaPotencia());
		assertEquals(((95 + 30) / 2.0) * 1.2, this.notebook.potencia());

		this.notebook.setConfiguracion(new AhorroDeEnergia());
		assertEquals(((95 + 30) / 2.0) * 0.7, this.notebook.potencia());
	}

	@Test
	public void testInformacion() {
		System.out.println(this.CPU.informacion());
		System.out.println(this.GPU.informacion());
		System.out.println(this.notebook.informacion());

		this.notebook.setConfiguracion(new MaximaPotencia());
		System.out.println(this.notebook.informacion());

		this.notebook.setConfiguracion(new AhorroDeEnergia());
		System.out.println(this.notebook.informacion());
	}
}
