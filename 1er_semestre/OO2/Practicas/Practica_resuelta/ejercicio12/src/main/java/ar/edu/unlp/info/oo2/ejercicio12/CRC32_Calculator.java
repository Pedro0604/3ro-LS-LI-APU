package ar.edu.unlp.info.oo2.ejercicio12;

import java.util.zip.CRC32;

public class CRC32_Calculator implements CRCCalculator {
	@Override
	public long crcFor(String data) {
		CRC32 crc = new CRC32();
		String datos = data;
		crc.update(datos.getBytes());
		System.out.println("32: " + crc.getValue());
		return crc.getValue();
	}
}
