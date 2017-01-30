package com.wc.rest;

import com.sun.jersey.api.client.Client;

public class JerseyClientFactory {

	private static Client client;

	public static Client getClientInstance() {
		if (client == null) {
			client = Client.create();
		}
		return client;
	}
}
