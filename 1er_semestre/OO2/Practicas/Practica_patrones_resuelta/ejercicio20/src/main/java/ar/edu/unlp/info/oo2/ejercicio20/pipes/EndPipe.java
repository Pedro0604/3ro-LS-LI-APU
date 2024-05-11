package ar.edu.unlp.info.oo2.ejercicio20.pipes;

import java.awt.image.BufferedImage;

import ar.edu.unlp.info.oo2.ejercicio20.imageFilters.ImageFilter;

public class EndPipe implements ImageFilter, ImageFilterPipeInterface {

	public void addPipeFrom(ImageFilterPipe newPipe, ImageFilterPipe aPipe) {
		aPipe.setNextPipe(newPipe);

	}

	public void setNextPipe(ImageFilterPipe newPipe) {
	}

	public void addFilter(ImageFilter next) {
	}

	public BufferedImage filter(BufferedImage image) {
		return image;
	}
}
