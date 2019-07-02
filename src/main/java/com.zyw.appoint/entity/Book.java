package com.zyw.appoint.entity;

/**
 * @program: BookAppointment
 * @description: 图书类
 * @author: Cengyuwen
 * @create: 2019-06-03 19:50
 **/

public class Book {
    private long bookId;//图书ID
    private String name;//图书名称
    private int number;//馆藏数量
    private String introd;

    public Book() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIntrod() {
        return introd;
    }

    public void setIntrod(String introd) {
        this.introd = introd;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", introd='" + introd + '\'' +
                '}';
    }
}
