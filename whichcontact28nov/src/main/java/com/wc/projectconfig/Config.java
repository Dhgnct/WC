package com.wc.projectconfig;

import javax.naming.ConfigurationException;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Config {
	private static Config instance;
	private PropertiesConfiguration configure;

	private Config() throws ConfigurationException, org.apache.commons.configuration.ConfigurationException {
		configure = new PropertiesConfiguration("whichcontact.properties");
	}

	public static Config getInstance() throws org.apache.commons.configuration.ConfigurationException {
		if (null == instance) {
			try {
				instance = new Config();
			} catch (ConfigurationException ex) {
				throw new RuntimeException(ex);
			}
		}
		return instance;
	}

	public PropertiesConfiguration getConfigure() {
		return configure;
	}

	public void setConfig(PropertiesConfiguration configure) {
		this.configure = configure;
	}
}