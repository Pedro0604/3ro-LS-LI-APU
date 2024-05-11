package ar.edu.unlp.info.oo2.ejercicio11;

public abstract class ProyectoState {
	protected Proyecto proyecto;

	public ProyectoState(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public void aprobarEtapa() {
	}

	public void modificarMargenDeGanancia(double margenDeGanancia) {
	}

	public void cancelarProyecto() {
		this.proyecto.appendToObjetivo("(Cancelado)");
		this.proyecto.setState(new Cancelado(this.proyecto));
	}

	public abstract String getNombre();
}
