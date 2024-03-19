package ar.edu.unlp.info.oo2.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Mano {
	private String nombre;
	private List<Mano> ganaContra;

	public Mano(String nombre) {
		this.nombre = nombre;
		this.ganaContra = new ArrayList<>();
	}

	public void addGanaContra(Mano mano) {
		this.ganaContra.add(mano);
	}

	public boolean ganaA(Mano otraMano) {
		return this.ganaContra.contains(otraMano);
	}

	public String getNombre() {
		return this.nombre;
	}
}
