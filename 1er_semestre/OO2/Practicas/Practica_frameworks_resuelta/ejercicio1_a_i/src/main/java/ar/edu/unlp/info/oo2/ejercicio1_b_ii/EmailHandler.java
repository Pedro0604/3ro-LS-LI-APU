package ar.edu.unlp.info.oo2.ejercicio1_b_ii;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import ar.edu.unlp.info.oo2.ejercicio1_b.i.JSONFormatter;

public class EmailHandler extends Handler {
	public EmailHandler() {
		this.setFormatter(new JSONFormatter());
	}

	@Override
	public void publish(LogRecord record) {
		if (!isLoggable(record)) {
			return;
		}
		Mailer.sendMail(this.getFormatter().format(record));
	}

	@Override
	public void flush() {
		//
	}

	@Override
	public void close() throws SecurityException {
		//
	}
}
