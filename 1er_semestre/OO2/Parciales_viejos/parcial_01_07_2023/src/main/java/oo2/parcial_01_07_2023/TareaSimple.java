package oo2.parcial_01_07_2023;

public class TareaSimple extends Tarea {
	private int duracionEstimada;
	private long fechaInicio, fechaFin;
	private TareaState state;

	public TareaSimple(String nombre, int duracionEstimada) {
		super(nombre);
		this.duracionEstimada = duracionEstimada;
		this.fechaInicio = -1;
		this.fechaFin = -1;
		this.state = new CreadaState(this);
	}

	@Override
	public int estimacionTotal() {
		return duracionEstimada;
	}

	@Override
	public long getFechaInicio() {
		return fechaInicio;
	}

	@Override
	public long getFechaFin() {
		return fechaFin;
	}

	public void setFechaInicio(long fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(long fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void iniciar() {
		this.state.iniciar();
	}

	@Override
	public void completar() {
		this.state.completar();
	}

	public void setState(TareaState state) {
		this.state = state;
	}

	@Override
	public long tiempoUtilizado() {
		return this.state.tiempoUtilizado();
	}

	public long tiempoFinMenosInicio() {
		return this.fechaFin - this.fechaInicio;
	}
}
