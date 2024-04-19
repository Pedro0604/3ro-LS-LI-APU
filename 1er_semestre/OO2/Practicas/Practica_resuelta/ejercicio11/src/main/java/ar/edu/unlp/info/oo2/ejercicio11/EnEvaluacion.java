package ar.edu.unlp.info.oo2.ejercicio11;

public class EnEvaluacion extends ProyectoState {
	public EnEvaluacion(Proyecto proyecto) {
		super(proyecto);
	}

	@Override
	public void aprobarEtapa() {
		if (this.proyecto.precioProyecto() > 0) {
			this.proyecto.setState(new Confirmado(this.proyecto));
		}
	}

	@Override
	public void modificarMargenDeGanancia(double margenDeGanancia) {
		if (margenDeGanancia >= 0.11 && margenDeGanancia <= 0.15) {
			this.proyecto.setMargenDeGanancia(margenDeGanancia);
		}
	}

	@Override
	public String getNombre() {
		return "En evaluación";
	}
}