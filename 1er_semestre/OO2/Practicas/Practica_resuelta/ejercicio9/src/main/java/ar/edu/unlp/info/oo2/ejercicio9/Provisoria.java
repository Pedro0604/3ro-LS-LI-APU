package ar.edu.unlp.info.oo2.ejercicio9;

public class Provisoria extends ExcursionState {
	public Provisoria(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribirUsuario(Usuario usuario) {
		this.excursion.addUsuario(usuario);
		if (this.excursion.isAtCupoMin()) {
			this.excursion.setState(new Definitiva(this.excursion));
		}
	}

	@Override
	protected String getExtraInfo() {
		return ", cantidadUsuariosFaltantesParaCupoMin=" + this.excursion.getCantUsuariosToCupoMin();
	}
}
