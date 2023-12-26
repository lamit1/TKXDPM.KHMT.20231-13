package org.example.models;

import java.util.Date;

public class Book extends Media {
    private String id;
    private String author;
    private String coverType;
    private String publisher;
    private Date publishDate;
    private int numOfPages;
    private String language;
    private String bookCategory;

    public Book(String name, double price, boolean rushDelivery, double weight, int availabel, String imageUrl, String category, String author, String coverType, String publisher, Date publishDate, int numOfPages, String language, String bookCategory) {
        super(name, price, rushDelivery, weight, availabel, imageUrl, category);
        this.author = author;
        this.coverType = coverType;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.numOfPages = numOfPages;
        this.language = language;
        this.bookCategory = bookCategory;
    }
}
