package com.monstermachines.connectionfw.core;

import java.util.ArrayList;
import java.util.List;

public class IntegrationStatus {
	
	private List<IntegrationError> errors = new ArrayList<>();
	private int processedRows = 0;
	
	public int getProcessedRows() {
		return this.processedRows;
	}
	
	public void setProcessedRows(int processedRows) {
		this.processedRows = processedRows;
	}
	
	public void addError(IntegrationError error) {
		this.errors.add(error);
	}

	public IntegrationError[] getErrors() {
		
		if (this.errors.size() == 0) {
			return null;
		}
		
		IntegrationError[] errorsArray = new IntegrationError[this.errors.size()];
		return this.errors.toArray(errorsArray);
	}
	
}
