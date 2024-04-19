package ar.edu.unlp.info.oo2.ejercicio12;

public class WifiConn implements Connection {
	private String pict;

	@Override
	public String sendData(String data, int crc) {
		return "TODO";
	}

	@Override
	public String pict() {
		return this.pict;
	}
}
