package ar.edu.unlp.info.oo2.ejercicio20.imageFilters;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Monochrome extends Filter {
	public BufferedImage filter(BufferedImage image) {
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				Color color = new Color(image.getRGB(x, y));
				int avg = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
				image.setRGB(x, y, (new Color(avg, avg, avg, color.getAlpha()).getRGB()));
			}
		}
		return image;
	}
}
