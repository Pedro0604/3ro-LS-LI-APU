package ar.edu.unlp.info.oo2.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	private Usuario u;

	@BeforeEach
	void setUp() throws Exception {
		u = new Usuario("pepe");
	}

	@Test
	public void testTweet() {
		u.tweet("tweet1");
		assertEquals(1, u.getTweets().size());
	}

	@Test
	public void testTweetVacio() {
		assertNull(u.tweet(""));
		assertEquals(0, u.getTweets().size());
	}

	@Test
	public void testTweetMuyLargo() {
		assertNull(u.tweet(
				"klsdfjhklñsjfdhkalsjdhfkasjdhflkasdjfhkasldjhfdaskjhfawkljfhasdkjfhsdakljfhasrlkjfhaskljfhaskdjfhasdikñjfhasiuhfaeiuhfkjashksejahfiausehfkasjhfdkljsadhfliasujhfasiuehfaisejkhfaskjfdhdslkjhfskdjhfaksdjhfalsdkjhfsadikjhfaselkdjfhaslkdjhfasñlikjdefhaskldjhfaskñdjfhasñikldjhfñsoaujheropñuahesrfñoujahsfñosejhdf"));
		assertEquals(0, u.getTweets().size());
	}

	@Test
	public void testReTweet() {
		Tweet t = u.tweet("tweet1");
		ReTweet rt = u.reTweet(t);
		assertEquals(2, u.getTweets().size());
		assertEquals(t.getTexto(), rt.getTexto());
	}

	@Test
	public void testEliminarTweets() {
		Tweet t = u.tweet("tweet1");
		u.reTweet(t);
		u.eliminarTweets();
	}
}
