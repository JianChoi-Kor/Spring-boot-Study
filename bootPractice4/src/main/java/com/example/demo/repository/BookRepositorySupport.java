package com.example.demo.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.demo.model.Book;
import com.example.demo.model.QBook;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Configuration
public class BookRepositorySupport extends QuerydslRepositorySupport {
	
	private final JPAQueryFactory queryFactory;
	
	public BookRepositorySupport(JPAQueryFactory queryFactory) {
		super(Book.class);
		this.queryFactory = queryFactory;
	}
	
	public List<Book> findByTitle(String title) {
		QBook book = QBook.book;
		
		return from(book)
				.where(book.title.eq(title))
				.fetch();
	}
	
	public List<Book> findByAll() {
		QBook book = QBook.book;
		
		return queryFactory
				.selectFrom(book)
				.fetch();
	}
}


