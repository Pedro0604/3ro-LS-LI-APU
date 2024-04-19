package ar.edu.unlp.info.oo2.ejercicio11;

public class Confirmado extends ProyectoState {
	public Confirmado(Proyecto proyecto) {
		super(proyecto);
	}

	@Override
	public String getNombre() {
		return "Confirmado";
	}
}