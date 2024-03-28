package ar.edu.unlp.info.oo2.ejercicio5;

public class MediaPlayer {
	private Media media;

	public void setMedia(Media media) {
		this.media = media;
	}

	public String play() {
		return media.play();
	}
}
