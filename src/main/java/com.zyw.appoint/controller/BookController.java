package com.zyw.appoint.controller;

import com.zyw.appoint.dto.AppointExecution;
import com.zyw.appoint.dto.Result;
import com.zyw.appoint.entity.Appointment;
import com.zyw.appoint.entity.Book;
import com.zyw.appoint.entity.Student;
import com.zyw.appoint.enums.AppointStateEnum;
import com.zyw.appoint.exception.NoNumberException;
import com.zyw.appoint.exception.RepeatAppointException;
import com.zyw.appoint.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: BookAppointment
 * @description: 控制器
 * @author: Cengyuwen
 * @create: 2019-06-04 18:34
 **/
@Controller
@RequestMapping("/books")
public class BookController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookService bookService;
    //获取图书列表
    @RequestMapping(value="/list",method = RequestMethod.GET)
    private String List(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list", list);
        return "list";
    }

    //搜索是否有某图书
    @RequestMapping(value="/search",method = RequestMethod.POST)
    private void  search(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //接收页面的值
        //String name=req.getParameter("name");
        String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        name=name.trim();
        //向页面传值
        req.setAttribute("name", name);
        req.setAttribute("list", bookService.getSomeList(name));
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }

    //查看某图书的详细情况
    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model){
        if(bookId==null){
            return "redict:/book/list";
        }
        Book book=bookService.getById(bookId);
        if(book==null){
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        System.out.println(book);
        return "detail";
    }
    @RequestMapping("/checkId")
    @ResponseBody
    public Map<String, Object> checkId(Model model, @RequestParam(value = "Id", required = false) long id)
    {
        Map resultMap=new HashMap();
        Student student =null;
        student = bookService.QuaryById(id);
        System.out.println(student);
        if (student == null)
        {
            resultMap.put("message", "success");

            return resultMap;
        }else {
            resultMap.put("message", "failed");
            return resultMap;
        }


    }

    //验证输入的用户名、密码是否正确
    @RequestMapping(value="/verify", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Map validate(Long studentId, Long password){   //(HttpServletRequest req,HttpServletResponse resp){
        Map resultMap=new HashMap();
        Student student =null;
        System.out.println("验证函数");
        student =bookService.validateStu(studentId,password);

        System.out.println("输入的学号、密码："+studentId+":"+password);
        System.out.println("查询到的："+student.getStudentId()+":"+student.getPassword());

        if(student!=null){
            System.out.println("SUCCESS");
            resultMap.put("result", "SUCCESS");
            return resultMap;
        }else{
            resultMap.put("result", "FAILED");
            return resultMap;
        }
    }
    //注册
    @RequestMapping("/register")
    public String do_register(Model model,@RequestParam(value = "studentId",required = false) Long id,
                                            @RequestParam(value = "password",required = false) Long pwd)
    {
        Student student = new Student(id,pwd);
        int result = bookService.InsertStu(student);
       // return "redirect:/list.jsp";
        return "redirect:/books/list";
    }
    //执行预约的逻辑
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<AppointExecution> execute(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId){
        Result<AppointExecution> result;
        AppointExecution execution=null;

        try{//手动try catch,在调用appoint方法时可能报错
            execution=bookService.appoint(bookId, studentId);
            result=new Result<AppointExecution>(true,execution);
            return result;

        } catch(NoNumberException e1) {
            execution=new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
            result=new Result<AppointExecution>(true,execution);
            return result;
        }catch(RepeatAppointException e2){
            execution=new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
            result=new Result<AppointExecution>(true,execution);
            return result;
        }catch (Exception e){
            execution=new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
            result=new Result<AppointExecution>(true,execution);
            return result;
        }
    }
    @RequestMapping(value ="/appoint")
    private String appointBooks(@RequestParam("studentId") long studentId,Model model){

        List<Appointment> appointList=new ArrayList<>();
        appointList=bookService.getAppointByStu(studentId);
        model.addAttribute("appointList", appointList);
        return "appointBookList";
    }
}
