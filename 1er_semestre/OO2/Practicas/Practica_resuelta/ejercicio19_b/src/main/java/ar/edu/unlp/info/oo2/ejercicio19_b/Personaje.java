package ar.edu.unlp.info.oo2.ejercicio19_b;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.oo2.ejercicio19_b.armaduras.Armadura;
import ar.edu.unlp.info.oo2.ejercicio19_b.armas.Arma;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.Habilidad;

public class Personaje {
	private String nombre;
	private int puntosDeVida;
	private Arma arma;
	private Armadura armadura;
	private List<Habilidad> habilidades;

	public Personaje(String nombre, Arma arma, Armadura armadura) {
		this.nombre = nombre;
		this.arma = arma;
		this.armadura = armadura;
		this.puntosDeVida = 100;
		this.habilidades = new ArrayList<>();
	}

	public int getPuntosDeVida() {
		return puntosDeVida;
	}

	public String getNombre() {
		return nombre;
	}

	public void addHabilidad(Habilidad habilidad) {
		this.habilidades.add(habilidad);
	}

	public int atacarA(Personaje otroPersonaje) {
		System.out.println(this.nombre + " ataca a " + otroPersonaje.getNombre());
		return otroPersonaje.recibirDaño(this.arma);
	}

	public int recibirDaño(Arma armaAtacante) {
		int dañoRecibido = this.armadura.recibirDaño(armaAtacante);
		int vidaRestante = Math.max(this.puntosDeVida - dañoRecibido, 0);
		System.out.println("Ouchh! " + this.nombre + " recibió " + dañoRecibido + " punto"
				+ (dañoRecibido != 1 ? "s" : "") + " de daño y ahora le quedan " + vidaRestante + " punto"
				+ (vidaRestante != 1 ? "s" : "") + " de vida.");
		if (vidaRestante == 0) {
			System.out.println(this.nombre + " ha muerto! :(");
		}
		this.puntosDeVida = vidaRestante;
		return dañoRecibido;
	}

	public boolean tieneVida() {
		return this.puntosDeVida > 0;
	}

	// Este método no sigue las buenas prácticas a, pero alta paja seguirlas acá xd
	public void desafiarAMuerteA(Personaje otroPersonaje) {
		System.out.println(this.nombre + " desafía a muerte a " + otroPersonaje.nombre);
		if (this.tieneVida()) {
			if (otroPersonaje.tieneVida()) {
				if (!this.equals(otroPersonaje)) {
					while (this.tieneVida() && otroPersonaje.tieneVida()) {
						this.atacarA(otroPersonaje);
						if (otroPersonaje.tieneVida()) {
							otroPersonaje.atacarA(this);
						}
					}
					System.out.println("Fin del combate!");
					if (this.tieneVida()) {
						System.out.println(this.nombre + " es el ganador! :)");
						System.out.println(otroPersonaje.nombre + " es el perdedor y se re murió! :(");
					} else {
						System.out.println(otroPersonaje.nombre + " es el ganador! :)");
						System.out.println(this.nombre + " es el perdedor y se re murió! :(");
					}
				} else {
					System.out.println("No te podés suicidar :)");
				}
			} else {
				System.out.println("No podés matar a un muerto :|");
			}
		} else {
			System.out.println("Los fantasmas no hacen daño :(");
		}
		System.out.println();
	}
}
