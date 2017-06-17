package com.monstermachines.connectionfw.core;

public class IntegrationError {
	private int index;
	private Exception exception;
	
	public IntegrationError() {
	}
	
	public IntegrationError(int index, Exception exception) {
		this.index = index;
		this.exception = exception;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
}
