package com.monstermachines.connectionfw.core;

import org.apache.log4j.Logger;

public class IntegrationFramework {
	
	private static final Logger logger = Logger.getLogger(IntegrationFramework.class);

	private InformationItemProcessor processor;
	
	public IntegrationFramework() {
		this.processor = new InformationItemProcessor();
	}
	
	public IntegrationStatus update(Source source) {
		
		IntegrationStatus status = new IntegrationStatus();
		
		InformationItem item = null;
		while ((item = source.next()) != null) {
			status.setProcessedRows(status.getProcessedRows() + 1);
			try {
				save(item);
			} catch (Exception e) {
				status.addError(new IntegrationError(status.getProcessedRows(), e));
			}
		}
		
		return status;
	}
	
	private void save(InformationItem item) {
		String sql = this.processor.getSQLStament(item);
		execute(sql);
	}

	private void execute(String sql) {
		logger.debug(sql);
	}

}
