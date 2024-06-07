package oo2.parcial_25_06_2022;

public abstract class ExcursionState {
	protected Excursion excursion;

	public ExcursionState(Excursion excursion) {
		this.excursion = excursion;
	}

	public abstract void inscribir(Usuario unUsuario);

	public abstract String obtenerInformacion();
}
