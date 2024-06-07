package oo2.parcial_16_07_2022.decorators;

import oo2.parcial_16_07_2022.HomeWeather;

public class RadiacionDecorator extends HomeWeatherDecorator {
	public RadiacionDecorator(HomeWeather homeWeather) {
		super(homeWeather);
	}

	@Override
	protected String displayRealData() {
		return "Radiación solar: " + this.homeWeather.getRadiacionSolar();
	}
}