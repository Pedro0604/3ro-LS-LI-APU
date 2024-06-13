package oo2.parcial_25_06_2022;

public class CompletaState extends ExcursionState {
	public CompletaState(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.excursion.addUsuarioToListaDeEspera(unUsuario);
	}

	@Override
	public String getExtraInfo() {
		return "]";
	}

	@Override
	public String getName() {
		return "Completa";
	}
}
