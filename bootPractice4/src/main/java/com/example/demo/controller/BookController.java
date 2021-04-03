package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BookRepositorySupport;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookRepositorySupport bookRepositorySupport;
	
	
	@GetMapping("/list")
	@ResponseBody
	public List<Book> getBookListData() {
		
		List<Book> bookList = bookRepositorySupport.findByAll();
		System.out.println(bookList);
		
		return bookList;
	}
	
	@GetMapping("/{title}")
	@ResponseBody
	public List<Book> getBookData(@PathVariable(name="title") String title) {
		List<Book> bookList = bookRepositorySupport.findByTitle(title);
		return bookList;
		
	}
	
	@PostMapping
	public void addBookData(@RequestBody Book book) {
		bookRepository.save(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookData(@PathVariable(name="id") Long id) {
		bookRepository.deleteById(id);
	}
	
	
	
	
	
}
