package com.monstermachines.connectionfw.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Configuration {

	private static Configuration instance;
	private ApplicationContext context;
	
	private Configuration() {
		this.context = new ClassPathXmlApplicationContext("ConnectionFrameworkConfiguration.xml");
	}
	
	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}
	
	public MappingConfiguration getMappingConfiguration(InformationItem item) {
		return (MappingConfiguration) this.context.getBean(item.getClass().getName());
	}
	
}
