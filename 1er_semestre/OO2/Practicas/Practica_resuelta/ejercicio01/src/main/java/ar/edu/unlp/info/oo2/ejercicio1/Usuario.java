package ar.edu.unlp.info.oo2.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public void eliminarReferencias(List<Tweetable> tweetsRecibidos) {
		this.tweets = this.tweets.stream().filter(t -> !tweetsRecibidos.contains(t.getReferencia()))
				.collect(Collectors.toList());
		System.out.println(this.tweets.size());
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
