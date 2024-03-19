package ar.edu.unlp.info.oo2.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReTweetTest {
	private ReTweet rt;
	private Tweet tweet;

	@BeforeEach
	void setUp() throws Exception {
		tweet = new Tweet("tweet1");
		rt = new ReTweet(tweet);
	}

	@Test
	public void testGetTexto() {
		assertEquals(tweet.getTexto(), rt.getTexto());
	}
}
