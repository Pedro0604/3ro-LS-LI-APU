package ar.edu.unlp.info.oo2.ejercicio20.pipes;

import java.awt.image.BufferedImage;

import ar.edu.unlp.info.oo2.ejercicio20.imageFilters.ImageFilter;

public interface ImageFilterPipeInterface {

	public BufferedImage filter(BufferedImage image);

	public void addFilter(ImageFilter next);

	public void setNextPipe(ImageFilterPipe newPipe);

	public void addPipeFrom(ImageFilterPipe newPipe, ImageFilterPipe aPipe);

}
