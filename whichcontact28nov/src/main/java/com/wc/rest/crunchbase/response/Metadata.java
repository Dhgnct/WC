package com.wc.rest.crunchbase.response;

public class Metadata {
	
	private int version;
	private String www_path_prefix;
	private String image_path_prefix;

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getWww_path_prefix() {
		return www_path_prefix;
	}
	public void setWww_path_prefix(String www_path_prefix) {
		this.www_path_prefix = www_path_prefix;
	}
	public String getImage_path_prefix() {
		return image_path_prefix;
	}
	public void setImage_path_prefix(String image_path_prefix) {
		this.image_path_prefix = image_path_prefix;
	}
	
}

