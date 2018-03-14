<%@ page language="java" contentType="text/html; charset=UTF-8" import="bean.user"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
<% out.println("hello wrold"); %>
<p>为实现中华民族的伟大复兴而努力奋斗</p>
<form action="firstsevlet" method="post">
<P>用户名:<input name="username" type=""text"></P>
<p>密&nbsp;&nbsp;码:<input name="password" type=""password"></p>
<p><input type="submit" vaule="提交"/><input type="reset" vaule="重置"></p>
</form>
</body>
</html>