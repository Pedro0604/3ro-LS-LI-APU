package ar.edu.unlp.info.oo2.ejercicio24;

public abstract class ProcessStep {
	private boolean result;
	private boolean isDone;

	public ProcessStep() {
		this.result = false;
		this.isDone = false;
	}

	public void execute(MixingTank tank) {
		if (this.basicExecute(tank)) {
			this.setSuccess();
		} else {
			this.setFailure();
		}
		this.isDone = true;
	}

	protected abstract boolean basicExecute(MixingTank tank);

	private void setSuccess() {
		this.result = true;
	}

	private void setFailure() {
		this.result = false;
	}

	public boolean isDone() {
		return this.isDone;
	}

	public boolean isSuccessful() {
		return this.result;
	}
}