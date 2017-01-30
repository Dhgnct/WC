package com.wc.organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class OrganizationDetails {

	@Id
	@Column(name = "uuid")
	private String uuid;

	@Column(name = "name")
	private String name;

	@Column(name = "domain")
	private String domain;

	@Column(name = "homepage_url")
	private String homepage_url;

	@Column(name = "country_code")
	private String country_code;

	public OrganizationDetails() {

	}

	public OrganizationDetails(String uuid , String name, String domain, String homepage_url, String country_code) {
		this.setId(uuid);
		this.setName(name);
		this.setDomain(domain);
		this.setHomepageUrl(homepage_url);
		this.setCountryCode(country_code);
	
	}

	public String getId() {
		return uuid;
	}

	public void setId(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getHomepageUrl() {
		return homepage_url;
	}

	public void setHomepageUrl(String homepage_url) {
		this.homepage_url = homepage_url;
	}

	public String getCountryCode() {
		return country_code;
	}

	public void setCountryCode(String country_code) {
		this.country_code = country_code;
	}



}