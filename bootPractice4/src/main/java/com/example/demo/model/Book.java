package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
public class Book {
	
	public Book() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String writer;
	private String info;
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getInfo() {
		return info;
	}

	@Builder
	public Book(String title, String writer, String info) {
		this.title = title;
		this.writer = writer;
		this.info = info;
	}
}
