package ar.edu.unlp.info.oo2.ejercicio11;

public class EnConstruccion extends ProyectoState {
	public EnConstruccion(Proyecto proyecto) {
		super(proyecto);
	}

	@Override
	public void aprobarEtapa() {
		if (this.proyecto.precioProyecto() > 0) {
			this.proyecto.setState(new EnEvaluacion(this.proyecto));
		} else {
			throw new RuntimeException("El precio es cero :(");
		}
	}

	@Override
	public void modificarMargenDeGanancia(double margenDeGanancia) {
		if (margenDeGanancia >= 0.08 && margenDeGanancia <= 0.1) {
			this.proyecto.setMargenDeGanancia(margenDeGanancia);
		}
	}

	@Override
	public String getNombre() {
		return "En construcción";
	}
}
