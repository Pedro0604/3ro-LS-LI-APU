package ar.edu.unlp.info.oo2.ejercicio19.armaduras;

import ar.edu.unlp.info.oo2.ejercicio19.armas.Arma;

public class ArmaduraDeHierro implements Armadura {
	@Override
	public int recibirDaño(Arma armaAtacante) {
		return armaAtacante.hacerDañoAHierro();
	}
}