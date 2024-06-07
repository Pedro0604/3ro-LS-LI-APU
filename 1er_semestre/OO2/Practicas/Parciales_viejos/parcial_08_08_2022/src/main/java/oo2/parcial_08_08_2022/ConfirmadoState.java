package oo2.parcial_08_08_2022;

public class ConfirmadoState extends ProyectoState {
	public ConfirmadoState(Proyecto proyecto) {
		super(proyecto);
	}

	@Override
	public String getNombre() {
		return "Confirmado";
	}
}
