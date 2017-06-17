package com.monstermachines.connectionfw.core;

import java.lang.reflect.Method;

public class InformationItemProcessor {

	public String getSQLStament(InformationItem item) {
		MappingConfiguration configuration = Configuration.getInstance().getMappingConfiguration(item);
		
		StringBuilder sql = new StringBuilder("INSERT INTO ");
		
		sql.append(configuration.getTargetTable());
		sql.append(getFieldNamesForInsert(configuration));
		sql.append(getFielValuesForInsert(configuration, item));
		
		return sql.toString();
	}
	
	private static String getFieldNamesForInsert(MappingConfiguration configuration) {
		StringBuilder fieldNames = new StringBuilder("(");
		for (InformationMappingField field : configuration.getFieldsMapping()) {
			fieldNames.append(field.getField()).append(", ");
		}
		return fieldNames.substring(0, fieldNames.length() - 2) + ") ";
	}
	
	private static String getFielValuesForInsert(MappingConfiguration configuration, InformationItem item) {
		StringBuilder fieldValues = new StringBuilder("(");
		String fieldValue = null;
		for (InformationMappingField field : configuration.getFieldsMapping()) {
			fieldValue = invokeGetter(field.getGetter(), item);
			fieldValues.append("'").append(fieldValue).append("', ");
		}
		return fieldValues.substring(0, fieldValues.length() - 2) + ") ";
	}

	private static String invokeGetter(String getter, InformationItem item) {
		Object value = null;
		try {
			Method getterMethod = item.getClass().getMethod(getter);
			value = getterMethod.invoke(item);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return value.toString();
	}
	
}
