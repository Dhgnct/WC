package com.wc.rest.crunchbase.response;

import java.util.List;

public class OrganizationData {

	private Paging paging;
	private List<Organization> items;

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public List<Organization> getItems() {
		return items;
	}

	public void setItems(List<Organization> items) {
		this.items = items;
	}
}
