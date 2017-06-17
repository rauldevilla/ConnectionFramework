package com.monstermachines.connectionfw.core;

public enum FieldName {
	VEHICLE_MODEL_CODE("model_code"),
	VEHICLE_MODEL_NAME("model_name"),
	;
	
	private String dbName;

	private FieldName(String dbName) {
		this.dbName = dbName;
	}
	
	@Override
	public String toString() {
		return this.dbName;
	}
}
