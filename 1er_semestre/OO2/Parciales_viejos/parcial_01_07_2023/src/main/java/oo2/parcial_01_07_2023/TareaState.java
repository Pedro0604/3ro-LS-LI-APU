package oo2.parcial_01_07_2023;

public abstract class TareaState {
	protected TareaSimple tarea;

	public TareaState(TareaSimple tarea) {
		this.tarea = tarea;
	}

	public void iniciar() {
	}

	public void completar() {
	}

	public long tiempoUtilizado() {
		return 0;
	}
}
