package oo2.parcial_25_06_2022;

public class DefinitivaState extends ExcursionState {
	public DefinitivaState(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.excursion.addUsuario(unUsuario);

		if (this.excursion.getCantidadUsuarios() == this.excursion.getCupoMax()) {
			this.excursion.setState(new CompletaState(excursion));
		}
	}

	@Override
	public String getExtraInfo() {
		return ", mails=[" + this.excursion.getMailsUsuarios() + "] , cantidadHastaCupoMax="
				+ this.excursion.getUsuariosHastaCupoMax() + "]";
	}

	@Override
	public String getName() {
		return "Definitiva";
	}
}
