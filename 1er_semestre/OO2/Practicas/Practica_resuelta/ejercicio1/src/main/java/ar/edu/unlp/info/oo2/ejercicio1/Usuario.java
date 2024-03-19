package ar.edu.unlp.info.oo2.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String screenName;
	private List<Tweetable> tweets;

	public Usuario(String screenName) {
		this.screenName = screenName;
		this.tweets = new ArrayList<>();
	}

	public String getScreenName() {
		return screenName;
	}

	public void eliminarTweets() {
		this.tweets.clear();
	}

	public Tweet tweet(String texto) {
		if (texto.length() < 1 || texto.length() > 280) {
			return null;
		}
		Tweet t = new Tweet(texto);
		this.tweets.add(t);
		return t;
	}

	public ReTweet reTweet(Tweet tweet) {
		ReTweet t = new ReTweet(tweet);
		this.tweets.add(t);
		return t;
	}

	public List<Tweetable> getTweets() {
		return this.tweets;
	}
}
