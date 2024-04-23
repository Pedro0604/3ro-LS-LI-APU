package ar.edu.unlp.info.oo2.ejercicio20.imageFilters;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Darken extends Filter {
	public BufferedImage filter(BufferedImage image) {
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				Color color = new Color(image.getRGB(x, y));
				image.setRGB(x, y, (color.darker().getRGB()));
			}
		}
		return image;
	}
}
