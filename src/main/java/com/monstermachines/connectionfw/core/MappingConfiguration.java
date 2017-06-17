package com.monstermachines.connectionfw.core;

import java.util.List;

public class MappingConfiguration {

	private String targetTable;
	private List<InformationMappingField> fieldsMapping;
	
	public String getTargetTable() {
		return targetTable;
	}
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}
	public List<InformationMappingField> getFieldsMapping() {
		return fieldsMapping;
	}
	public void setFieldsMapping(List<InformationMappingField> fieldsMapping) {
		this.fieldsMapping = fieldsMapping;
	}
	
}
