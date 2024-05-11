package ar.edu.unlp.info.oo2.ejercicio23;

import java.util.List;

public class AerOOlinea {
	private List<Pasaje> pasajes;

	public void addPasaje(Pasaje p) {
		this.pasajes.add(p);
	}

	public boolean removePasaje(Pasaje p) {
		return this.pasajes.remove(p);
	}

}
