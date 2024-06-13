package oo2.parcial_08_08_2022;

public class EnEvaluacionState extends ProyectoState {
	public EnEvaluacionState(Proyecto proyecto) {
		super(proyecto);
	}

	@Override
	public void aprobarEtapa() throws Exception {
		this.proyecto.setState(new ConfirmadoState(proyecto));
	}

	@Override
	public void moficarMargenGanancia(double margenGanancia) {
		if (margenGanancia >= 0.11 && margenGanancia <= 0.15) {
			this.proyecto.setMargenGanancia(margenGanancia);
		}
	}

	@Override
	public String getNombre() {
		return "En evaluación";
	}
}
