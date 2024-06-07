package oo2.parcial_08_08_2022;

public abstract class ProyectoState {
	protected Proyecto proyecto;

	public ProyectoState(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public void aprobarEtapa() throws Exception {
	}

	public void moficarMargenGanancia(double margenGanancia) {
	}

	public void cancelarProyecto() {
		this.proyecto.appendToObjetivo("(Cancelado)");
		this.proyecto.setState(new CanceladoState(proyecto));
	}

	public abstract String getNombre();
}
