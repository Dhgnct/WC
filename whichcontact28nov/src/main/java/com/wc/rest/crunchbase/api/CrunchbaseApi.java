package com.wc.rest.crunchbase.api;

import javax.ws.rs.core.MediaType;

import org.apache.commons.configuration.ConfigurationException;

import com.sun.istack.logging.Logger;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.projectconfig.Config;
import com.wc.rest.JerseyClientFactory;
import com.wc.rest.crunchbase.response.CruchbaseResponse;

public class CrunchbaseApi {

	private static String BASE_URL = null;
	final static Logger logger = Logger.getLogger(App.class);

	// get all organization details from API response
	public static CruchbaseResponse getAllOrganizations() {
		try {
			BASE_URL = Config.getInstance().getConfigure().getString("base-url");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = JerseyClientFactory.getClientInstance();
		String url = BASE_URL + "odm-organizations?user_key=901d92226dd11d3015b7ee06aee97a3b";
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		CruchbaseResponse output = response.getEntity(CruchbaseResponse.class);
		return output;

	}
}
