package ar.edu.unlp.info.oo2.ejercicio12;

public class FourGConnAdapter implements Connection {
	private FourGConn adaptee;

	public FourGConnAdapter(FourGConn adaptee) {
		this.adaptee = adaptee;
	}

	public String sendData(String data, int crc) {
		return this.adaptee.transmit(data, crc);
	}

	public String pict() {
		return this.adaptee.getSymb();
	}
}
