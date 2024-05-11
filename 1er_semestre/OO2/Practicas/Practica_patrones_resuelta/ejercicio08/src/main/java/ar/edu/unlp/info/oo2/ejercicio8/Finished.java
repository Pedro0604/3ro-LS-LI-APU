package ar.edu.unlp.info.oo2.ejercicio8;

public class Finished extends State {
	public Finished(ToDoItem toDoItem) {
		super(toDoItem);
	}

	public void addComment(String comment) {
	}

	@Override
	public String getStateName() {
		return "finished";
	}
}