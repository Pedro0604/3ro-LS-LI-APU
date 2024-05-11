package ar.edu.unlp.info.oo2.ejercicio12;

public class Dispositivo {
	private Display display;
	private Ringer ringer;
	private CRCCalculator crcCalculator;
	private Connection connection;

	public Dispositivo(CRCCalculator crcCalculator, Connection connection) {
		this.display = new Display();
		this.ringer = new Ringer();
		this.crcCalculator = crcCalculator;
		this.connection = connection;
	}

	public String send(String data) {
		long crc = this.crcCalculator.crcFor(data);
		return this.connection.sendData(data, crc);
	}

	public void changeConnection(Connection newConnection) {
		this.connection = newConnection;
		this.display.showBanner(this.connection.pict());
		this.ringer.ring();
	}

	public void changeCRCCalculator(CRCCalculator newCRCCalculator) {
		this.crcCalculator = newCRCCalculator;
	}
}
