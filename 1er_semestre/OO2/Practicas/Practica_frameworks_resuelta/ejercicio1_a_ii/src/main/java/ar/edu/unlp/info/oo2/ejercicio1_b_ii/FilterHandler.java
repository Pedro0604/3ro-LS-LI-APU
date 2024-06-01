package ar.edu.unlp.info.oo2.ejercicio1_b_ii;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;

public class FilterHandler extends ConsoleHandler {
	private List<String> filteredWords;

	public FilterHandler() {
		this.filteredWords = new ArrayList<>();
	}

	public void addFilteredWord(String word) {
		this.filteredWords.add(word);
	}

	public void removeFilteredWord(String word) {
		this.filteredWords.remove(word);
	}

	@Override
	public void publish(LogRecord record) {
		if (!isLoggable(record)) {
			return;
		}

		String message = record.getMessage();
		for (String word : filteredWords) {
			message = message.replaceAll("(?i)" + word, "***");
		}
		record.setMessage(message);
	}
}
