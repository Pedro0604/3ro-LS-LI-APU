package oo2.mi_parcial_29_06_2024.punto_4;

import oo2.mi_parcial_29_06_2024.Configuracion;
import oo2.mi_parcial_29_06_2024.Director;
import oo2.mi_parcial_29_06_2024.Equipo;

// Para poder agregar una configuración con diferentes pasos (que añade monitor
// y periféricos) hay que crear un nuevo director con dichos pasos e
// implementarlos en Configuracion (podrían estar vacíos en la clase
// abstracta y con la implementación pertinente en la clase correspondiente, en
// este caso en ConfiguracionGamer)
public class DirectorMonitorYPerifericos implements Director {
	@Override
	public Equipo construir(Configuracion configuracion) {
		configuracion.crear();
		configuracion.addProcesador();
		configuracion.addRam();
		configuracion.addDisco();
		configuracion.addGrafica();
		configuracion.addGabinete();
		configuracion.addMonitor();
		configuracion.addPerifericos();
		return configuracion.completar();
	}
}
