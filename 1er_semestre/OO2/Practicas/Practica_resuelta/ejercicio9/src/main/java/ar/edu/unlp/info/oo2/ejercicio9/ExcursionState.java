package ar.edu.unlp.info.oo2.ejercicio9;

public abstract class ExcursionState {
	protected Excursion excursion;

	public ExcursionState(Excursion excursion) {
		this.excursion = excursion;
	}

	public abstract void inscribirUsuario(Usuario usuario);

	@Override
	public String toString() {
		String baseStr = "Excursion [nombre=" + this.excursion.getNombre() + ", puntoEncuentro="
				+ this.excursion.getPuntoEncuentro() + ", fechaInicio=" + this.excursion.getFechaInicio().toString()
				+ ", fechaFin=" + this.excursion.getFechaFin().toString() + ", costo=" + this.excursion.getCosto();

		return baseStr + this.getExtraInfo() + "]";
	}

	protected abstract String getExtraInfo();
}
