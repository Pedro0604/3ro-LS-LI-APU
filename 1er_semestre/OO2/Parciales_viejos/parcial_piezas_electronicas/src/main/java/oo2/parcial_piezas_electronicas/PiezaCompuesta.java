package oo2.parcial_piezas_electronicas;

import java.util.ArrayList;
import java.util.List;

public class PiezaCompuesta extends Pieza {
	private List<Pieza> piezas;
	private Configuracion config;

	// Por default la configuración va a ser media
	public PiezaCompuesta(String nombre) {
		super(nombre);
		this.piezas = new ArrayList<>();
		this.config = new PotenciaMedia();
	}

	public void addPieza(Pieza p) {
		this.piezas.add(p);
	}

	public void setConfiguracion(Configuracion config) {
		this.config = config;
	}

	@Override
	public double capacidadBateria() {
		return this.piezas.stream().mapToDouble(pieza -> pieza.capacidadBateria()).average().orElse(0)
				* (1 + this.config.porcentajeVariacionBateria());
	}

	@Override
	public double potencia() {
		return this.piezas.stream().mapToDouble(pieza -> pieza.potencia()).average().orElse(0)
				* (1 + this.config.porcentajeVariacionPotencia());
	}
}
