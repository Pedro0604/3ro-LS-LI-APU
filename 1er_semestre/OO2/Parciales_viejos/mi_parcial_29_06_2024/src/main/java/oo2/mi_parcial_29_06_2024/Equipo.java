package oo2.mi_parcial_29_06_2024;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private List<Componente> componentes;
	private Catalogo catalogo;
	private final double IVA = 0.21;

	public Equipo() {
		this.componentes = new ArrayList<>();
		this.catalogo = new Catalogo();
	}

	public void addComponente(String componente) {
		this.componentes.add(this.catalogo.getComponente(componente));
	}

	public double getConsumo() {
		return this.componentes.stream().mapToDouble(componente -> componente.getConsumo()).sum();
	}

	public double getPrecio() {
		return this.componentes.stream().mapToDouble(componente -> componente.getPrecio()).sum() * (1 + this.IVA);
	}
}
