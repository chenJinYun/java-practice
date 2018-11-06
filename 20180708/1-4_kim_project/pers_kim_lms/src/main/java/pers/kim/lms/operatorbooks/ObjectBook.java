package pers.kim.lms.operatorbooks;

import java.io.Serializable;

public class ObjectBook implements Serializable {
    private String uid;
    private String book_name;
    private String price;
    private String author;

    public ObjectBook(String uid, String book_name, String price, String author) {
        this.uid = uid;
        this.book_name = book_name;
        this.price = price;
        this.author = author;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
