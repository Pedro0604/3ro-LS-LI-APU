package ar.edu.unlp.info.oo2.ejercicio9;

public class Definitiva extends ExcursionState {
	public Definitiva(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribirUsuario(Usuario usuario) {
		this.excursion.addUsuario(usuario);
		if (this.excursion.isAtCupoMax()) {
			this.excursion.setState(new Completa(this.excursion));
		}
	}

	@Override
	protected String getExtraInfo() {
		return ", " + this.excursion.getAllMails() + ", cantidadUsuariosFaltantesParaCupoMax="
				+ this.excursion.getCantUsuariosToCupoMax();
	}
}