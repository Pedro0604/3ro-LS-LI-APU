package ar.edu.unlp.info.oo2.ejercicio_22_con_builder;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
	private List<Elemento> elementos;

	public Sandwich() {
		this.elementos = new ArrayList<>();
	}

	public void addElemento(Elemento elemento) {
		this.elementos.add(elemento);
	}

	public double getPrecio() {
		return this.elementos.stream().mapToDouble(e -> e.getPrecio()).sum();
	}
}
