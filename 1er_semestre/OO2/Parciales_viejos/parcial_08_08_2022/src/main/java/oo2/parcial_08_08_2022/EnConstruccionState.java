package oo2.parcial_08_08_2022;

public class EnConstruccionState extends ProyectoState {
	public EnConstruccionState(Proyecto proyecto) {
		super(proyecto);
	}

	@Override
	public void aprobarEtapa() throws Exception {
		if (this.proyecto.precioProyecto() > 0) {
			this.proyecto.setState(new EnEvaluacionState(proyecto));
		} else {
			throw new Exception("El precio del proyecto debe ser mayor a cero para poder iniciarlo");
		}
	}

	@Override
	public void moficarMargenGanancia(double margenGanancia) {
		if (margenGanancia >= 0.08 && margenGanancia <= 0.1) {
			this.proyecto.setMargenGanancia(margenGanancia);
		}
	}

	@Override
	public String getNombre() {
		return "En construcción";
	}
}
