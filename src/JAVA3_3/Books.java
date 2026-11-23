package JAVA3_3;

import java.sql.Date;

public class Books {
    private int bookNum;
    private int isbn;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private String bookYn;
    private String bookCategory;
    private Date bookInDate;

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookYn() {
        return bookYn;
    }

    public void setBookYn(String bookYn) {
        this.bookYn = bookYn;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Date getBookInDate() {
        return bookInDate;
    }

    public void setBookInDate(Date bookInDate) {
        this.bookInDate = bookInDate;
    }
}
