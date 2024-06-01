package ar.edu.unlp.info.oo2.ejercicio1_b.i;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class JSONFormatter extends SimpleFormatter {

	@Override
	public String format(LogRecord record) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{\n");
		buffer.append("  \"message\": \"");
		buffer.append(record.getMessage());
		buffer.append("\",\n");
		buffer.append("  \"level\": \"");
		buffer.append(record.getLevel());
		buffer.append("\"\n");
		buffer.append("}\n\n");
		return buffer.toString();
	}
}
