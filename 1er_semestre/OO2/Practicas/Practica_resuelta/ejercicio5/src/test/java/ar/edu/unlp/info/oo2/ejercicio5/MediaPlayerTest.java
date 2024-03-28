package ar.edu.unlp.info.oo2.ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaPlayerTest {
	private MediaPlayer m;

	@BeforeEach
	void setUp() throws Exception {
		m = new MediaPlayer();
	}

	@Test
	public void testAudio() {
		m.setMedia(new Audio());
		assertEquals("Audiooooo!", m.play());
	}

	@Test
	public void testVideoFile() {
		m.setMedia(new VideoFile());
		assertEquals("Video Fileee!", m.play());
	}

	@Test
	public void testVideoStream() {
		m.setMedia(new VideoStreamAdapter());
		assertEquals("Video Streaaam!", m.play());
	}
}
