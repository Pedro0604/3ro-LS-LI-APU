package ar.edu.unlp.info.oo2.ejercicio1;

public class ReTweet implements Tweetable {
	private Tweet tweetDeOrigen;

	public ReTweet(Tweet tweetDeOrigen) {
		this.tweetDeOrigen = tweetDeOrigen;
	}

	public String getTexto() {
		return this.tweetDeOrigen.getTexto();
	}

	@Override
	public Tweet getReferencia() {
		return this.tweetDeOrigen;
	}
}
