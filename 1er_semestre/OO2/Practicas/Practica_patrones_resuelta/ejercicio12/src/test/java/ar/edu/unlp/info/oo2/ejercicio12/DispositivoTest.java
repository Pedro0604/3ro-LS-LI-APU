package ar.edu.unlp.info.oo2.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DispositivoTest {
	private Dispositivo dWifi, d4g, dWifi32, d4g32;

	@BeforeEach
	void setUp() throws Exception {
		dWifi = new Dispositivo(new CRC16_Calculator(), new WifiConn());
		d4g = new Dispositivo(new CRC16_Calculator(), new FourGConnAdapter());
		dWifi32 = new Dispositivo(new CRC32_Calculator(), new WifiConn());
		d4g32 = new Dispositivo(new CRC32_Calculator(), new FourGConnAdapter());
	}

	@Test
	public void testSend() {
		System.out.println("Envio por Wifi");
		assertEquals("Data enviada por Wifi", dWifi.send("Hola"));

		System.out.println("Envio por 4G");
		assertEquals("Data enviada por 4G", d4g.send("Hola"));

		System.out.println("Wifi 16 es igual a Wifi 32");
		assertEquals(dWifi.send("Hola"), dWifi32.send("Hola"));

		System.out.println("4G 16 es igual a 4G 32");
		assertEquals(d4g.send("Hola"), d4g32.send("Hola"));
	}

	@Test
	public void testChangeConnection() {
		System.out.println("Cambio a 4G");
		dWifi.changeConnection(new FourGConnAdapter());
		assertEquals("Data enviada por 4G", dWifi.send("Hola"));

		System.out.println("Cambio a Wifi");
		dWifi.changeConnection(new WifiConn());
		assertEquals("Data enviada por Wifi", dWifi.send("Hola"));
	}

	@Test
	public void testChangeCRCCalculator() {
		System.out.println("Cambio a CRC 16");
		dWifi32.changeCRCCalculator(new CRC16_Calculator());
		dWifi32.send("Chau");

		System.out.println("Cambio a CRC 32");
		dWifi32.changeCRCCalculator(new CRC32_Calculator());
		dWifi32.send("Chau");
	}
}
