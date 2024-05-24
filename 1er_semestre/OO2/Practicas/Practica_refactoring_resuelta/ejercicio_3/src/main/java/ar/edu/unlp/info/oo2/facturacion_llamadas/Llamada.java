package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Llamada {
	private static final double IVA = 0.21;
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String origen, String destino, int duracion) {
		this.origen = origen;
		this.destino = destino;
		this.duracion = duracion;
	}

	public String getRemitente() {
		return destino;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getOrigen() {
		return origen;
	}

	public abstract int getPrecioPorSegundo();

	public abstract int getCostoEstablecerLlamada();

	public double getMonto() {
		return this.getDuracion() * this.getPrecioPorSegundo()
				+ (this.getDuracion() * this.getPrecioPorSegundo() * IVA) + this.getCostoEstablecerLlamada();
	}
}
