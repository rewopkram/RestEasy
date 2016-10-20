package com.msp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

	private Long id;
	private String author;
	private String text;
	
	public Comment() { }
	
	public Comment(Long id, String author, String text) {
		super();
		this.id = id;
		this.author = author;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
