package com.zyw.appoint.dao;

import com.zyw.appoint.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: BookAppointment
 * @description: 对于书籍的持久层操作
 * @author: Cengyuwen
 * @create: 2019-06-03 19:53
 **/

public interface BookDao {
    /***
    * @Description:  根据id查询书籍
    * @Param: [id]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    Book queryById(long id);
    List<Book> querySome(String name);
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    /***
    * @Description:  减少数量用返回值判断
    * @Param: [bookId]
    * @Author: Cengyunwen
    * @Date: 2019/6/3
    */
    int reduceNumber(long bookId);

}
