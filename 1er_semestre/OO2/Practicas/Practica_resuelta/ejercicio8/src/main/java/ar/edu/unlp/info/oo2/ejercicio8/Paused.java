package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.LocalDateTime;

public class Paused extends State {
	public Paused(ToDoItem toDoItem) {
		super(toDoItem);
	}

	public void togglePause() {
		this.toDoItem.setState(new InProgress(this.toDoItem));
	}

	public void finish() {
		this.toDoItem.setEndTime(LocalDateTime.now());
		this.toDoItem.setState(new Finished(this.toDoItem));
	}

	@Override
	public String getStateName() {
		return "paused";
	}
}
