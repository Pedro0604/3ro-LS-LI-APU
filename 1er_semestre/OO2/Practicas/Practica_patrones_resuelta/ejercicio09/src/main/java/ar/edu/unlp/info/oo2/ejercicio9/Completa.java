package ar.edu.unlp.info.oo2.ejercicio9;

public class Completa extends ExcursionState {
	public Completa(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribirUsuario(Usuario usuario) {
		this.excursion.addUsuarioToListaEspera(usuario);
	}

	@Override
	protected String getExtraInfo() {
		return "";
	}
}