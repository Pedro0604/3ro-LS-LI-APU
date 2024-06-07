package oo2.parcial_16_07_2022.decorators;

import oo2.parcial_16_07_2022.HomeWeather;

public class PresionDecorator extends HomeWeatherDecorator {
	public PresionDecorator(HomeWeather homeWeather) {
		super(homeWeather);
	}

	@Override
	protected String displayRealData() {
		return "Presión atmosférica: " + this.homeWeather.getPresion();
	}
}
