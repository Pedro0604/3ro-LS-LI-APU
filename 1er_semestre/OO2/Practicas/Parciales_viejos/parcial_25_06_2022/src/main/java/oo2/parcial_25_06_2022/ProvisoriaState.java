package oo2.parcial_25_06_2022;

public class ProvisoriaState extends ExcursionState {
	public ProvisoriaState(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.excursion.addUsuario(unUsuario);
		if (this.excursion.getCantidadUsuarios() == this.excursion.getCupoMin()) {
			this.excursion.setState(new DefinitivaState(excursion));
		}
	}

	@Override
	public String obtenerInformacion() {
		return "Excursion [nombre=" + this.excursion.getNombre() + ", fechaInicio=" + this.excursion.getFechaInicio()
				+ ", fechaFin=" + this.excursion.getFechaFin() + ", puntoEncuentro="
				+ this.excursion.getPuntoEncuentro() + ", costo=" + this.excursion.getCosto() + "]";
	}
}
