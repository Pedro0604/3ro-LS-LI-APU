package ar.edu.unlp.info.oo2.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	private List<Mano> manos;

	public Juego() {
		Mano piedra = new Mano("Piedra");
		Mano papel = new Mano("Papel");
		Mano tijera = new Mano("Tijera");
		Mano lagarto = new Mano("Lagarto");
		Mano spock = new Mano("Spock");

		this.manos = new ArrayList<>();
		this.manos.add(piedra);
		this.manos.add(papel);
		this.manos.add(tijera);
		this.manos.add(lagarto);
		this.manos.add(spock);

		piedra.addGanaContra(tijera);
		piedra.addGanaContra(lagarto);
		papel.addGanaContra(piedra);
		papel.addGanaContra(spock);
		tijera.addGanaContra(papel);
		tijera.addGanaContra(lagarto);
		lagarto.addGanaContra(papel);
		lagarto.addGanaContra(spock);
		spock.addGanaContra(tijera);
		spock.addGanaContra(piedra);
	}

	public String jugar(Mano mano1, Mano mano2) {
		return mano1.ganaA(mano2) ? mano1.getNombre() : mano2.ganaA(mano1) ? mano2.getNombre() : "Empate";
	}

	public List<Mano> getManos() {
		return this.manos;
	}
}
