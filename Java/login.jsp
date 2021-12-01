<%--
  Created by IntelliJ IDEA.
  User: banyue
  Date: 2021/11/14
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/loginServlet" method="post">
username:<input type="text" name="username"/>
    <br/>
    password:<input type="password" name="pwd"/>
    <br/>
    <input type="submit" value="登录">
    <br/>
    消息提示：${msg}

</form>
</body>
</html>
