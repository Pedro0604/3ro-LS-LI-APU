package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class State {
	protected ToDoItem toDoItem;

	public State(ToDoItem toDoItem) {
		this.toDoItem = toDoItem;
	}

	public void start() {

	}

	public void togglePause() throws RuntimeException {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}

	public void finish() {

	}

	public Duration workedTime(LocalDateTime startTime, LocalDateTime endTime) {
		return Duration.between(startTime, endTime == null ? LocalDateTime.now() : endTime);
	}

	public void addComment(String comment) {
		this.toDoItem.getComments().add(comment);
	}

	public abstract String getStateName();
}
