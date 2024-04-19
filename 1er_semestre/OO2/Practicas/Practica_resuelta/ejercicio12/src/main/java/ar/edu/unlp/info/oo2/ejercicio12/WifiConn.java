package ar.edu.unlp.info.oo2.ejercicio12;

public class WifiConn implements Connection {
	private String pict;

	public WifiConn() {
		this.pict = "Wifi";
	}

	@Override
	public String sendData(String data, long crc) {
		return "Data enviada por Wifi";
	}

	@Override
	public String pict() {
		return this.pict;
	}
}
