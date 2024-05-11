package ar.edu.unlp.info.oo2.ejercicio19_b.armaduras;

import ar.edu.unlp.info.oo2.ejercicio19_b.armas.Arma;

public class ArmaduraDeCuero implements Armadura {
	@Override
	public int recibirDaño(Arma armaAtacante) {
		return armaAtacante.hacerDañoACuero();
	}
}