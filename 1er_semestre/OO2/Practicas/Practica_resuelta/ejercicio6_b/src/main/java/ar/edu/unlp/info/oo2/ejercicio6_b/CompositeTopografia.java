package ar.edu.unlp.info.oo2.ejercicio6_b;

import java.util.ArrayList;
import java.util.List;

public class CompositeTopografia extends Topografia {
	private List<Topografia> children;

	public CompositeTopografia() {
		this.children = new ArrayList<>();
	}

	public boolean addTopografia(Topografia child) {
		int childCount = this.children.size();
		if (childCount < 4)
			this.children.add(child);
		return childCount < 4;
	}

	public void removeAllTopografias() {
		this.children.clear();
	}

	public List<Topografia> getChildren() {
		return this.children;
	}

	@Override
	public double getProporcionAgua() {
		double prop = this.children.stream().mapToDouble(c -> c.getProporcionAgua()).sum() / 4;
		return prop;
	}

	public int getChildCount() {
		return this.children.size();
	}

	public boolean isEqualTo(Topografia topografia) {
		if (topografia.getChildren() != null && topografia.getChildCount() == this.getChildCount()) {
			boolean isEqual = true;
			for (int i = 0; i < this.getChildCount(); i++) {
				if (!this.children.get(i).isEqualTo(topografia.getChildren().get(i))) {
					isEqual = false;
				}
			}
			return isEqual;
		}
		return false;
	}
}
