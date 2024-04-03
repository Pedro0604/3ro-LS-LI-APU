package ar.edu.unlp.info.oo2.ejercicio6_b;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private List<Topografia> topografias;

	public Client() {
		this.topografias = new ArrayList<>();
	}

	public void addTopografia(Topografia topografia) {
		this.topografias.add(topografia);
	}

	public double getProporcionAguaTopografia(int index) {
		return this.topografias.get(index).getProporcionAgua();
	}

	public double getProporcionTierraTopografia(int index) {
		return (1 - this.topografias.get(index).getProporcionAgua());
	}
}
