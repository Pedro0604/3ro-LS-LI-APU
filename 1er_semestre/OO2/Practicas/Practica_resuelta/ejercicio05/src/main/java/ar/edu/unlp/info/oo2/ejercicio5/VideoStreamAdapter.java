package ar.edu.unlp.info.oo2.ejercicio5;

public class VideoStreamAdapter extends Media {
	private VideoStream videoStreamAdaptee;

	public VideoStreamAdapter() {
		super();
		this.videoStreamAdaptee = new VideoStream();
	}

	@Override
	public String play() {
		return this.videoStreamAdaptee.reproduce();
	}
}
