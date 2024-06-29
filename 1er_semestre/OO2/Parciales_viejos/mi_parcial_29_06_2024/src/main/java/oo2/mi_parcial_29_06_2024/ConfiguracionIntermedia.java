package oo2.mi_parcial_29_06_2024;

public class ConfiguracionIntermedia extends Configuracion {
	@Override
	public void addProcesador() {
		this.equipo.addComponente("Procesador Intermedio");
	}

	@Override
	public void addRam() {
		this.equipo.addComponente("Memoria RAM 16GB");
	}

	@Override
	public void addDisco() {
		this.equipo.addComponente("SSD 500GB");
	}

	@Override
	public void addGrafica() {
		this.equipo.addComponente("GTX 1650");
	}

	@Override
	public void addGabinete() {
		this.equipo.addComponente("Gabinete estándar");
		this.equipo.addComponente("Fuente 800w");
	}
}
