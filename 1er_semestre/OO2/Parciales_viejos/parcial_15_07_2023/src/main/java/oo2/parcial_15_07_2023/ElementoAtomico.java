package oo2.parcial_15_07_2023;

public abstract class ElementoAtomico extends Elemento {
	protected String texto, estilo;

	public ElementoAtomico(String texto) {
		this.texto = texto;
		this.estilo = "";
	}
}
