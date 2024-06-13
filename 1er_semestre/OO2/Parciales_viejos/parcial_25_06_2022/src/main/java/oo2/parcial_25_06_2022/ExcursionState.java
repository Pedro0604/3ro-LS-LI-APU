package oo2.parcial_25_06_2022;

public abstract class ExcursionState {
	protected Excursion excursion;

	public ExcursionState(Excursion excursion) {
		this.excursion = excursion;
	}

	public abstract void inscribir(Usuario unUsuario);

	public String obtenerInformacion() {
		return "Excursion [nombre=" + this.excursion.getNombre() + ", fechaInicio=" + this.excursion.getFechaInicio()
				+ ", fechaFin=" + this.excursion.getFechaFin() + ", puntoEncuentro="
				+ this.excursion.getPuntoEncuentro() + ", costo=" + this.excursion.getCosto() + this.getExtraInfo();
	}

	protected abstract String getExtraInfo();

	public abstract String getName();
}
