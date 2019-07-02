package com.zyw.appoint.dao;

import com.zyw.appoint.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @program: BookAppointment
 * @description: 学生操作
 * @author: Cengyuwen
 * @create: 2019-06-03 19:58
 **/
public interface StudentDao {
    /***
    * @Description:向数据库验证输入的密码是否正确
    * @Param: [studentId, password]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    Student quaryStudent(@Param("studentId") long studentId, @Param("password") long password);
    Student quaryById(long studentId);
    int insertStu(@Param("studentId") long studentId, @Param("password") long password);
}
