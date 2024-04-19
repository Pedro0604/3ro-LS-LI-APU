package ar.edu.unlp.info.oo2.ejercicio12;

public class FourGConn {
	private String symb;

	public FourGConn() {
		super();
		this.symb = "4G";
	}

	public String getSymb() {
		return symb;
	}

	public String transmit(String data, long crc) {
		return "Data enviada por 4G";
	}
}
