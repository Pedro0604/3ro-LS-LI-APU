package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
	@SuppressWarnings("unused")
	private String name;
	private LocalDateTime startTime, endTime;
	private List<String> comments;
	private State state;

	/**
	 * Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
	 */
	public ToDoItem(String name) {
		this.name = name;
		this.startTime = LocalDateTime.now();
		this.endTime = null;
		this.comments = new ArrayList<>();
		this.state = new Pending(this);
	}

	public List<String> getComments() {
		return comments;
	}

	public LocalDateTime getStartTime() {
		return this.startTime;
	}

	public LocalDateTime getEndTime() {
		return this.endTime;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getStateName() {
		return this.state.getStateName();
	}

	/**
	 * Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
	 * pending. Si se encuentra en otro estado, no hace nada.
	 */
	public void start() {
		this.state.start();
	}

	/**
	 * Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress si su
	 * estado es paused. Caso contrario (pending o finished) genera un error
	 * informando la causa específica del mismo.
	 */
	public void togglePause() {
		this.state.togglePause();
	}

	/**
	 * Pasa el ToDoItem a finished, siempre y cuando su estado actual sea
	 * in-progress o paused. Si se encuentra en otro estado, no hace nada.
	 */
	public void finish() {
		this.state.finish();
	}

	/**
	 * Retorna el tiempo que transcurrió desde que se inició el ToDoItem (start)
	 * hasta que se finalizó. En caso de que no esté finalizado, el tiempo que haya
	 * transcurrido hasta el momento actual. Si el ToDoItem no se inició, genera un
	 * error informando la causa específica del mismo.
	 */
	public Duration workedTime() {
		return this.state.workedTime(this.startTime, this.endTime);
	}

	/**
	 * Agrega un comentario al ToDoItem siempre y cuando no haya finalizado. Caso
	 * contrario no hace nada."
	 */
	public void addComment(String comment) {
		this.state.addComment(comment);
	}
}
