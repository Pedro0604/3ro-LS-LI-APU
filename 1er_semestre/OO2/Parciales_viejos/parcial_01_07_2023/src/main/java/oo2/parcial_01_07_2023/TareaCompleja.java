package oo2.parcial_01_07_2023;

import java.util.ArrayList;
import java.util.List;

public class TareaCompleja extends Tarea {
	private List<Tarea> tareas;

	public TareaCompleja(String nombre) {
		super(nombre);
		this.tareas = new ArrayList<>();
	}

	@Override
	public int estimacionTotal() {
		return this.tareas.stream().mapToInt(tarea -> tarea.estimacionTotal()).sum();
	}

	@Override
	public long getFechaInicio() {
		return -1;
	}

	@Override
	public long getFechaFin() {
		return -1;
	}

	public void addTarea(Tarea tarea) {
		this.tareas.add(tarea);
	}

	@Override
	public void iniciar() {
		this.tareas.forEach(tarea -> tarea.iniciar());
	}

	@Override
	public void completar() {
		this.tareas.forEach(tarea -> tarea.completar());
	}

	@Override
	public long tiempoUtilizado() {
		return this.tareas.stream().mapToLong(tarea -> tarea.tiempoUtilizado()).sum();
	}
}
