package oo2.mi_parcial_29_06_2024;

public class DirectorNormal implements Director {
	@Override
	public Equipo construir(Configuracion configuracion) {
		configuracion.crear();
		configuracion.addProcesador();
		configuracion.addRam();
		configuracion.addDisco();
		configuracion.addGrafica();
		configuracion.addGabinete();
		return configuracion.completar();
	}
}
