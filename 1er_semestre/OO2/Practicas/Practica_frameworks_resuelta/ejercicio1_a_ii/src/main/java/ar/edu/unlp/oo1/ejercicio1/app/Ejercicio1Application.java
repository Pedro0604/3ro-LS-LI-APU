package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import ar.edu.unlp.info.oo2.ejercicio1_b.i.JSONFormatter;
import ar.edu.unlp.info.oo2.ejercicio1_b.i.UpperCaseSimpleFormater;
import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {

	public static void main(String[] args) throws SecurityException, IOException {
		// Crea handler con UpperCaseSimpleFormatter del ejercicio 1_b_i
		Handler consoleUpperCaseHandler = new ConsoleHandler();
		consoleUpperCaseHandler.setFormatter(new UpperCaseSimpleFormater());

		// Crea handler con JSONFormatter del ejercicio 1_b_i
		Handler consoleJSONHandler = new ConsoleHandler();
		consoleJSONHandler.setFormatter(new JSONFormatter());

		Logger modelLogger = Logger.getLogger("modelo");
		FileHandler modelLoggerHandler = new FileHandler("model.log", true);
		modelLogger.addHandler(modelLoggerHandler);
		modelLogger.addHandler(consoleUpperCaseHandler);
		modelLogger.addHandler(consoleJSONHandler);

		Logger UILogger = Logger.getLogger("UI");
		UILogger.addHandler(consoleUpperCaseHandler);
		UILogger.addHandler(consoleJSONHandler);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WallPostUI();
			}
		});
	}

}
