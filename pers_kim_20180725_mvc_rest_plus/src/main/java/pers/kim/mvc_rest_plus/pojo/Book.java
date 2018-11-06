package pers.kim.mvc_rest_plus.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Create on 7/25/2018
 *
 * @Author Kim
 */
public class Book implements Serializable {
    private Integer id;
    private String name;
    private double price;
    private Date publishDate;
    private String author;

    public Book() {
    }

    public Book(Integer id, String name, double price, Date publishDate, String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
