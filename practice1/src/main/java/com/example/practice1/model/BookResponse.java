package com.example.practice1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String title;
    private String info;
    private Boolean completed;
    private String url;

    public BookResponse(BookEntity bookEntity) {
        this.id = bookEntity.getId();
        this.title = bookEntity.getTitle();
        this.info = bookEntity.getInfo();
        this.completed = bookEntity.getCompleted();

        this.url = "http://localhost:8080" + this.id;
    }
}
