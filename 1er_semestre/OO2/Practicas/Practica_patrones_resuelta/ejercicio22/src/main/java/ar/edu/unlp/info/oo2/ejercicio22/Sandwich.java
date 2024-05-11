package ar.edu.unlp.info.oo2.ejercicio22;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
	private List<AbstractElemento> elementos;

	public Sandwich(AbstractElemento pan, AbstractElemento aderezo, AbstractElemento principal,
			AbstractElemento adicional) {
		this.elementos = new ArrayList<>();
		this.elementos.add(pan);
		this.elementos.add(aderezo);
		this.elementos.add(principal);
		this.elementos.add(adicional);
	}

	public double getPrecio() {
		return this.elementos.stream().mapToDouble(e -> e.getPrecio()).sum();
	}
}
