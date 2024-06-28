package oo2.parcial_15_07_2023;

public final class ListaDesplegable {
	private String style, text;

	public ListaDesplegable(String text) {
		this.style = "";
		this.text = text;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String print() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<list estilo=\"");
		buffer.append(this.style);
		buffer.append("\"/> ");
		buffer.append(this.text);
		buffer.append(" </list>");
		return buffer.toString();
	}
}
