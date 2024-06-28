package oo2.parcial_01_07_2023;

public class CompletadaState extends TareaState {

	public CompletadaState(TareaSimple tarea) {
		super(tarea);
	}

	@Override
	public long tiempoUtilizado() {
		return this.tarea.tiempoFinMenosInicio();
	}
}
