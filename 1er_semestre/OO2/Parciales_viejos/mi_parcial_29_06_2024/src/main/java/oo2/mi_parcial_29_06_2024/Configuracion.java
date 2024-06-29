package oo2.mi_parcial_29_06_2024;

public abstract class Configuracion {
	protected Equipo equipo;

	public void crear() {
		this.equipo = new Equipo();
	}

	public abstract void addProcesador();

	public abstract void addRam();

	public abstract void addDisco();

	public abstract void addGrafica();

	public abstract void addGabinete();

	public Equipo completar() {
		return this.equipo;
	}

	// Estos dos métodos son para el punto 4
	public void addMonitor() {
	}

	public void addPerifericos() {
	}
}
