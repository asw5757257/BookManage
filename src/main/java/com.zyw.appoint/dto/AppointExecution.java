package com.zyw.appoint.dto;

import com.zyw.appoint.enums.AppointStateEnum;

/**
 * @program: BookAppointment
 * @description: 预约成功类
 * @author: Cengyuwen
 * @create: 2019-06-03 20:14
 **/

public class AppointExecution {
    // 图书ID
    private long bookId;

    // 预约结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    public AppointExecution() {
    }

    public AppointExecution(long bookId, int state, String stateInfo) {
        this.bookId = bookId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public AppointExecution(long bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
