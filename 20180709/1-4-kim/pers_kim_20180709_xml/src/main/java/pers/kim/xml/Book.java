package pers.kim.xml;

public class Book {
    private String bookName;
    private  String price;
    private  String author;
    private  String id;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookNmae) {
        this.bookName = bookNmae;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
