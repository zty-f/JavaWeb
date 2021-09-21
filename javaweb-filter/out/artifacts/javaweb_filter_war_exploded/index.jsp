<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2021/8/16
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>当前有
    <span><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%>
  </span>人在线！</h1>
  </body>
</html>
