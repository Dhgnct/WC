package com.wc.rest.crunchbase.response;

public class Paging {
	private int number_of_pages;
	private int current_page;
	private String sort_order;
	private int items_per_page;
	private String next_page_url;
	private String prev_page_url;

	private long total_items;

	public long getTotal_items() {
		return total_items;
	}

	public void setTotal_items(long total_items) {
		this.total_items = total_items;
	}

	public int getNumber_of_pages() {
		return number_of_pages;
	}

	public void setNumber_of_pages(int number_of_pages) {
		this.number_of_pages = number_of_pages;
	}

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

	public String getSort_order() {
		return sort_order;
	}

	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}

	public int getItems_per_page() {
		return items_per_page;
	}

	public void setItems_per_page(int items_per_page) {
		this.items_per_page = items_per_page;
	}

	public String getNext_page_url() {
		return next_page_url;
	}

	public void setNext_page_url(String next_page_url) {
		this.next_page_url = next_page_url;
	}

	public String getPrev_page_url() {
		return prev_page_url;
	}

	public void setPrev_page_url(String prev_page_url) {
		this.prev_page_url = prev_page_url;
	}

}
