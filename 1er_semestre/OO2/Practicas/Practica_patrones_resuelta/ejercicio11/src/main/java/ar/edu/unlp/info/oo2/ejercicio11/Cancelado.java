package ar.edu.unlp.info.oo2.ejercicio11;

public class Cancelado extends ProyectoState {
	public Cancelado(Proyecto proyecto) {
		super(proyecto);
	}

	@Override
	public void cancelarProyecto() {
	}

	@Override
	public String getNombre() {
		return "Cancelado";
	}
}