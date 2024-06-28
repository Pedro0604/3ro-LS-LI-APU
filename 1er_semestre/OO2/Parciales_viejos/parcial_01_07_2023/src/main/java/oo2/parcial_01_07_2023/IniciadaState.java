package oo2.parcial_01_07_2023;

public class IniciadaState extends TareaState {

	public IniciadaState(TareaSimple tarea) {
		super(tarea);
	}

	@Override
	public void completar() {
		this.tarea.setFechaFin(System.currentTimeMillis());
		this.tarea.setState(new CompletadaState(tarea));
	}
}
