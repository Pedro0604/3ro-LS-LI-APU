package oo2.mi_parcial_29_06_2024;

public class ConfiguracionBasica extends Configuracion {
	@Override
	public void addProcesador() {
		this.equipo.addComponente("Procesador Básico");
	}

	@Override
	public void addRam() {
		this.equipo.addComponente("Memoria RAM 8GB");
	}

	@Override
	public void addDisco() {
		this.equipo.addComponente("HDD 500GB");
	}

	@Override
	public void addGrafica() {
	}

	@Override
	public void addGabinete() {
		this.equipo.addComponente("Gabinete estándar");
	}
}
