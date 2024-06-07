package oo2.parcial_08_08_2022;

public class CanceladoState extends ProyectoState {
	public CanceladoState(Proyecto proyecto) {
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
