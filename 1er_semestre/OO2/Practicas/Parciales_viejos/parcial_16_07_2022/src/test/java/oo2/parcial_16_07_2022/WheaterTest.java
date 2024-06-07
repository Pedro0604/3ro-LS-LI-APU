package oo2.parcial_16_07_2022;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oo2.parcial_16_07_2022.decorators.PresionDecorator;
import oo2.parcial_16_07_2022.decorators.PromedioTemperaturasCelsius;
import oo2.parcial_16_07_2022.decorators.RadiacionDecorator;
import oo2.parcial_16_07_2022.decorators.TemperaturaCelsiusDecorator;

public class WheaterTest {
	private HomeWeather ej;

	@BeforeEach
	void setUp() throws Exception {
		List<Double> temperaturasPrevias = new ArrayList<>();
		temperaturasPrevias.add(76.0);
		temperaturasPrevias.add(78.0);
		temperaturasPrevias.add(79.0);
		temperaturasPrevias.add(75.0);

		ej = new HomeWeatherStationAdapter(new HomeWeatherStation(82.4, 1008, 500, temperaturasPrevias));
	}

	@Test
	public void testDisplay() {
		// Ejemplo 1
		HomeWeather stack = new PresionDecorator(ej);
		System.out.println(stack.displayData());

		// Ejemplo 2
		stack = new PresionDecorator(ej);
		stack = new RadiacionDecorator(stack);
		System.out.println(stack.displayData());

		// Ejemplo 3
		stack = new RadiacionDecorator(ej);
		stack = new TemperaturaCelsiusDecorator(stack);
		stack = new PromedioTemperaturasCelsius(stack);
		System.out.println(stack.displayData());
	}
}
