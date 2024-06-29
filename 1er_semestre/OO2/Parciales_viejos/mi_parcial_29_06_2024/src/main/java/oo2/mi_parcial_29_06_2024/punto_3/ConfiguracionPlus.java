package oo2.mi_parcial_29_06_2024.punto_3;

import oo2.mi_parcial_29_06_2024.Configuracion;

// Para agregar una nueva configuración solo hay que subclasificar Configuración
public class ConfiguracionPlus extends Configuracion {
	@Override
	public void addProcesador() {
		this.equipo.addComponente("Ryzen 5 3600");
		this.equipo.addComponente("Pasta térmica");
		this.equipo.addComponente("Cooler");
	}

	@Override
	public void addRam() {
		this.equipo.addComponente("Memoria RAM 8GB");
		this.equipo.addComponente("Memoria RAM 8GB");
	}

	@Override
	public void addDisco() {
		this.equipo.addComponente("SSD 240GB");
		this.equipo.addComponente("HDD 2TB");
	}

	@Override
	public void addGrafica() {
		this.equipo.addComponente("RTX 3050");
	}

	@Override
	public void addGabinete() {
		this.equipo.addComponente("Gabinete Kolink Void");
		this.equipo.addComponente("Fuente 550w");
	}
}