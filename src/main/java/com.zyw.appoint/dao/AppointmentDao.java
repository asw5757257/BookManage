package com.zyw.appoint.dao;

import com.zyw.appoint.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: BookAppointment
 * @description: 预约
 * @author: Cengyuwen
 * @create: 2019-06-03 19:57
 **/
public interface AppointmentDao {
    /***
    * @Description:  通过图书ID和学生ID预约书籍，并插入
    * @Param: [bookId, studentId]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);
    /***
    * @Description:通过一个学生ID查询已经预约了哪些书。
    * @Param: [studentId]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    List<Appointment> quaryAndReturn(long studentId);

}
