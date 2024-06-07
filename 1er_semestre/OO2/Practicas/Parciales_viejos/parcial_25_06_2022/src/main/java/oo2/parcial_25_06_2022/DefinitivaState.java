package oo2.parcial_25_06_2022;

public class DefinitivaState extends ExcursionState {
	public DefinitivaState(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		if (this.excursion.getCantidadUsuarios() < this.excursion.getCupoMax()) {
			this.excursion.addUsuario(unUsuario);
		} else {
			this.excursion.setState(new CompletaState(excursion));
		}
	}

	@Override
	public String obtenerInformacion() {
		// TODO Auto-generated method stub
		return null;
	}
}
