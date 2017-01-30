package com.wc.rest.crunchbase.response;

public class CruchbaseResponse {

	private Metadata metadata;
	private OrganizationData data;

	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public OrganizationData getData() {
		return data;
	}
	public void setData(OrganizationData data) {
		this.data = data;
	}
}
