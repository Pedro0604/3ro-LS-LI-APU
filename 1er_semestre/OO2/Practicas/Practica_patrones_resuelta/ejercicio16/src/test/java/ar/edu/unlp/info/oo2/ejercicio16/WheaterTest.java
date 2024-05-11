package ar.edu.unlp.info.oo2.ejercicio16;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio16.decorators.MaximaTemperaturaDecorator;
import ar.edu.unlp.info.oo2.ejercicio16.decorators.MinimaTemperaturaDecorator;
import ar.edu.unlp.info.oo2.ejercicio16.decorators.PresionDecorator;
import ar.edu.unlp.info.oo2.ejercicio16.decorators.PromedioTemperaturasDecorator;
import ar.edu.unlp.info.oo2.ejercicio16.decorators.RadiacionSolarDecorator;
import ar.edu.unlp.info.oo2.ejercicio16.decorators.TemperaturaDecorator;

public class WheaterTest {
	private WheaterData ej;

	@BeforeEach
	void setUp() throws Exception {
		List<Double> temperaturasPrevias = new ArrayList<>();
		temperaturasPrevias.add(80.6);
		temperaturasPrevias.add(86.9);
		temperaturasPrevias.add(86.9);
		temperaturasPrevias.add(89.6);

		ej = new HomeWheaterStation(86, 1008, 200, temperaturasPrevias);
	}

	@Test
	public void testDisplay() {
		// Ejemplo 1
		WheaterData stack = new RadiacionSolarDecorator(ej);
		stack = new PresionDecorator(stack);
		stack = new TemperaturaDecorator(stack, false);
		System.out.println(stack.displayData());

		// Ejemplo 2
		stack = new RadiacionSolarDecorator(ej);
		stack = new PresionDecorator(stack);
		stack = new TemperaturaDecorator(stack, true);
		System.out.println(stack.displayData());

		// Ejemplo 3
		stack = new PromedioTemperaturasDecorator(ej, true);
		stack = new RadiacionSolarDecorator(stack);
		stack = new PresionDecorator(stack);
		stack = new TemperaturaDecorator(stack, true);
		System.out.println(stack.displayData());

		// Ejemplo 4
		stack = new PromedioTemperaturasDecorator(ej, false);
		stack = new RadiacionSolarDecorator(stack);
		stack = new PresionDecorator(stack);
		stack = new TemperaturaDecorator(stack, false);
		System.out.println(stack.displayData());

		// Ejemplo 5
		stack = new MaximaTemperaturaDecorator(ej, true);
		stack = new MinimaTemperaturaDecorator(stack, true);
		stack = new PromedioTemperaturasDecorator(stack, true);
		stack = new RadiacionSolarDecorator(stack);
		stack = new PresionDecorator(stack);
		stack = new TemperaturaDecorator(stack, true);
		System.out.println(stack.displayData());

		// Ejemplo 6
		stack = new MaximaTemperaturaDecorator(ej, true);
		stack = new MinimaTemperaturaDecorator(stack, true);
		stack = new RadiacionSolarDecorator(stack);
		stack = new PresionDecorator(stack);
		stack = new TemperaturaDecorator(stack, true);
		System.out.println(stack.displayData());

		// Ejemplo 7
		stack = new PromedioTemperaturasDecorator(ej, true);
		stack = new MaximaTemperaturaDecorator(stack, true);
		stack = new MinimaTemperaturaDecorator(stack, true);
		stack = new RadiacionSolarDecorator(stack);
		stack = new PresionDecorator(stack);
		stack = new TemperaturaDecorator(stack, true);
		System.out.println(stack.displayData());
	}
}
