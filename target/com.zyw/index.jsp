<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>欢迎页</title>
    <%@include file="WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<div id="Layer1" style="position:absolute; left:0px; top:0px; width:100%; height:100%">
    <img src="resources/timg.jpg" width="100%" height="100%"/>
</div>
<h1 class="title"style="width: 220px;height: 100px;margin:0 auto;position:relative;top:300px;font-size:20px;">欢迎来到图书借阅系统！</h1>
<div class="nav" style="width:250px;margin:0 auto;position:relative;top:400px;">
<ul class="nav nav-pills" >
    <li role="presentation" class="active"><a href="/books/list">查看书籍</a></li>
    <li role="presentation"><a href="Register.jsp">注册</a></li>
</ul>
</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</html>