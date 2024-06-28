package oo2.parcial_01_07_2023;

public class CreadaState extends TareaState {

	public CreadaState(TareaSimple tarea) {
		super(tarea);
	}

	@Override
	public void iniciar() {
		this.tarea.setFechaInicio(System.currentTimeMillis());
		this.tarea.setState(new IniciadaState(tarea));
	}
}
