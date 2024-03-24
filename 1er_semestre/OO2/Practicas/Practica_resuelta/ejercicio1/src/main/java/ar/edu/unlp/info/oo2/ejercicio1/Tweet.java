package ar.edu.unlp.info.oo2.ejercicio1;

public class Tweet implements Tweetable {
	private String texto;

	public Tweet(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	@Override
	public Tweet getReferencia() {
		return this;
	}
}
