package ar.edu.unlp.info.oo2.ejercicio1_b.i;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class UpperCaseSimpleFormater extends SimpleFormatter {

	@Override
	public String format(LogRecord record) {
		return super.format(record).toUpperCase() + "\n";
	}
}
