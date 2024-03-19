package ar.edu.unlp.info.oo2.ejercicio2;

import java.util.List;

public class pruebita {

	public static void main(String[] args) {
		Juego juego = new Juego();
		List<Mano> manos = juego.getManos();

		for (int i = 0; i < manos.size(); i++) {
			for (int j = 0; j < manos.size(); j++) {
				System.out.println(manos.get(i).getNombre() + " + " + manos.get(j).getNombre() + " = "
						+ juego.jugar(manos.get(i), manos.get(j)));
			}
		}
	}

}
