package com.zyw.appoint.service;

import com.zyw.appoint.dto.AppointExecution;
import com.zyw.appoint.entity.Appointment;
import com.zyw.appoint.entity.Book;
import com.zyw.appoint.entity.Student;

import java.util.List;

/**
 * @program: BookAppointment
 * @description: 图书service
 * @author: Cengyuwen
 * @create: 2019-06-03 20:11
 **/
public interface BookService {
    /***
    * @Description:  查询一本书
    * @Param: [bookId]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    Book getById(long bookId);
    /***
    * @Description:  查询所有书
    * @Param: []
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    List<Book> getList();
    /***
    * @Description: 登陆时查询数据库是否有该学生记录。
    * @Param: [studentId, password]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    Student validateStu(Long studentId, Long password);
    Student QuaryById(Long studentId);
    int InsertStu(Student student);
    /***
    * @Description: 按照图书名称查询
    * @Param: [name]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    List<Book> getSomeList(String name);
    /***
    * @Description:  查看某学生预约的所有图书
    * @Param: [studentId]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    List<Appointment> getAppointByStu(long studentId);
    /***
    * @Description:  预约图书
    * @Param: [bookId, studentId]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    AppointExecution appoint(long bookId, long studentId);

}
