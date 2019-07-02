<%@ taglib prefix="width" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册页</title>
    <%@include file="WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<div class="zhuce" style="width: 600px;margin:0 auto;position: relative;height: 600px;background-color: silver">
<form action="<%= request.getContextPath()%>/books/register" id="register">
<div class="input-group" style="width: 300px;margin:0 auto;position: relative;top:200px">
    <span class="input-group-addon" id="basic-addon1">学号</span>
    <input type="text"id="studentId"name="studentId" class="form-control" placeholder="10位学号" aria-describedby="basic-addon1" onblur="checkId();">
</div>
    <div id="id_ok" style="width:50px;position: relative;left:450px;top:180px" ></div>
    <span id="id_span" style="color: red;position: relative;left:250px;top:200px;"></span>
<div class="input-group"style="width: 300px;margin:0 auto;position: relative;top:230px">
    <span class="input-group-addon">密码</span>
    <input type="password" id="password" name="password"class="form-control"placeholder="6位密码"aria-label="Amount (to the nearest dollar)" onblur="checkpwd();">
</div>
    <div  style="width: 50px;margin:0 auto;position:relative;top:260px">
    <input class="btn btn-default"id="to_register" type="button" value="注册">
    </div>
</form>
    <span id="submit_span" style="color: red;width: 50px;margin:0 auto;position:relative;left:250px;top:280px"></span>
</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    //检验学号
    var v = 0;
    var flag1 = false;
    function checkId() {
        var Id = $("#studentId").val();
        if (Id=='')
        {
            $("#id_span").text("请输入学生学号！");
            $("#id_ok").text("");
        }
        else
        {
            $.ajax({
                type: 'post',
                url: '/books/checkId',
                data: {"Id": Id},
                dataType: 'json',
                success: function (data) {
                    var val = data['message'];
                    if (val == "success") {
                        $("#id_span").text("");
                        $("#id_ok").text("√").css("color", "green");
                        /*var content = $("#phone_ok").text();
                        if (content == "√") {
                            var hgt = $("#regist-left").height();
                            if (v == 1) {
                                $("#regist-left").height(hgt - 30);
                                $("#regist-right").height(hgt - 30);
                            }
                            v = 0;
                        }*/
                        flag1 = true;
                    }else{

                        $("#id_span").text("该学号已经注册！");
                        $("#id_ok").text("");
                        /*var hgt = $("#regist-left").height();
                        if(v==0){
                            $("#regist-left").height(hgt+30);
                            $("#regist-right").height(hgt+30);
                            v++;
                        }*/
                        flag1 =  false;
                    }
                }
            })
        }
        return flag1;
    }
    //检验密码是否填写
    var flag2 = false;
    function checkpwd()
    {
        var pwd = $("password").val();
        if(pwd == '')
        {
            flag2 = false;
        }
        else
        {
            flag2 = true;
        }
        return flag2;
    }

    //检查信息填写完整
    $("#to_register").click (function()
    {  var Id = $("#studentId").val();
       var Pwd  = $("#password").val();
       var bool = true;
        if (Id.length!=10||Pwd.length!=6)
        {
            alert ("用户名或密码长度错误");
            bool = false;
        }

        if(checkId()&&checkpwd()&&bool)
        {
            $("#register").submit();
            alert ("注册成功!");
        }else {
            $("#submit_span").text("请将信息填写完整！").css("color","red");
        }
    })

</script>
</html>
