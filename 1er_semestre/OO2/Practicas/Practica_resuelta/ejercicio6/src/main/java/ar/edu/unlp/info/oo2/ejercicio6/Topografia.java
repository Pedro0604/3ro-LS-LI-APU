package ar.edu.unlp.info.oo2.ejercicio6;

import java.util.List;

public abstract class Topografia {
	public Topografia() {
	}

	public abstract double getProporcionAgua();

	public double getProporcionTierra() {
		return (1 - this.getProporcionAgua());
	}

	public boolean isEqualTo(Topografia topografia) {
		if (this.getChildCount() == topografia.getChildCount())
			return this.getProporcionAgua() == topografia.getProporcionAgua();
		return false;
	}

	public int getChildCount() {
		return -1;
	}

	public List<Topografia> getChildren() {
		return null;
	}
}
