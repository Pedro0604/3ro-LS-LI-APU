package oo2.mi_parcial_29_06_2024;

public class ConfiguracionGamer extends Configuracion {
	@Override
	public void addProcesador() {
		this.equipo.addComponente("Procesador Gamer");
		this.equipo.addComponente("Pad térmico");
		this.equipo.addComponente("Cooler");
	}

	@Override
	public void addRam() {
		this.equipo.addComponente("Memoria RAM 32GB");
		this.equipo.addComponente("Memoria RAM 32GB");
	}

	@Override
	public void addDisco() {
		this.equipo.addComponente("SSD 500GB");
		this.equipo.addComponente("SSD 1TB");
	}

	@Override
	public void addGrafica() {
		this.equipo.addComponente("RTX 4090");
	}

	@Override
	public void addGabinete() {
		this.equipo.addComponente("Gabinete Gamer");
		double consumo = this.equipo.getConsumo();
		consumo *= 1.5;
		this.equipo.addComponente("Fuente " + consumo + "w");
	}

	// Estos dos métodos son para el punto 4
	@Override
	public void addMonitor() {
		this.equipo.addComponente("Samsung 24 pulgadas");
		this.equipo.addComponente("Samsung 24 pulgadas");
	}

	@Override
	public void addPerifericos() {
		this.equipo.addComponente("HyperX Alloy Origins 60");
		this.equipo.addComponente("Logitech G305");
		this.equipo.addComponente("HyperX Cloud III");
	}
}
