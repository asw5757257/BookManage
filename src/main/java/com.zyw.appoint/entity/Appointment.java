package com.zyw.appoint.entity;

import java.util.Date;

/**
 * @program: BookAppointment
 * @description: 预定
 * @author: Cengyuwen
 * @create: 2019-06-03 19:51
 **/

public class Appointment {
    private long bookId;
    private long studentId;
    private Date appointTime;
    // 多对一的复合属性
    private Book book;// 图书实体

    public Appointment() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "bookId=" + bookId +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                ", book=" + book +
                '}';
    }
}
