package ar.edu.unlp.info.oo2.ejercicio20.pipes;

import java.awt.image.BufferedImage;

import ar.edu.unlp.info.oo2.ejercicio20.imageFilters.ImageFilter;

public class ImageFilterPipe implements ImageFilter, ImageFilterPipeInterface {
	protected ImageFilterPipeInterface nextPipe;
	private ImageFilter filter;

	public ImageFilterPipe(ImageFilter aFilter) {
		filter = aFilter;
		nextPipe = new EndPipe();
	}

	public void addFilter(ImageFilter next) {
		nextPipe.addPipeFrom(new ImageFilterPipe(next), this);
	}

	public void addPipeFrom(ImageFilterPipe newPipe, ImageFilterPipe aPipe) {
		nextPipe.addPipeFrom(newPipe, this);

	}

	public void setNextPipe(ImageFilterPipe newPipe) {
		nextPipe = newPipe;
	}

	public BufferedImage filter(BufferedImage image) {
		return nextPipe.filter(filter.filter(image));
	}
}
