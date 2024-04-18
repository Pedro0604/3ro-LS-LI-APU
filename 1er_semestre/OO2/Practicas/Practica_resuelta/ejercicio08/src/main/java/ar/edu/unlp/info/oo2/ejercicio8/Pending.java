package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.Duration;
import java.time.LocalDateTime;

public class Pending extends State {
	public Pending(ToDoItem toDoItem) {
		super(toDoItem);
	}

	@Override
	public void start() {
		this.toDoItem.setState(new InProgress(this.toDoItem));
	}

	@Override
	public Duration workedTime(LocalDateTime startTime, LocalDateTime endTime) throws RuntimeException {
		throw new RuntimeException("El objeto ToDoItem no ha sido iniciado");
	}

	@Override
	public String getStateName() {
		return "pending";
	}
}
