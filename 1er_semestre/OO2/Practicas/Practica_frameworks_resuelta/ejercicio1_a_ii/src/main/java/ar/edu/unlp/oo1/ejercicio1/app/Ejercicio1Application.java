package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {

	public static void main(String[] args) throws SecurityException, IOException {
		Logger modelLogger = Logger.getLogger("modelo");
		FileHandler modelLoggerHandler = new FileHandler("model.log", true);
		modelLogger.addHandler(modelLoggerHandler);

		Logger UILogger = Logger.getLogger("UI");

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WallPostUI();
			}
		});
	}

}
