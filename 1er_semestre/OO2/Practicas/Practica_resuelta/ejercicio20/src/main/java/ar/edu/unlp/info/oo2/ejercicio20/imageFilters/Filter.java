package ar.edu.unlp.info.oo2.ejercicio20.imageFilters;

import java.awt.image.BufferedImage;

public abstract class Filter implements ImageFilter {
	abstract public BufferedImage filter(BufferedImage image);
}
