<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
JSP表达式:用来将程序的输出，输出到客户端
<%=  变量或者表达式 %>
--%>
<%=new java.util.Date() %>

<hr>

<%--jsp脚本片段--%>

<%
  int sum = 0;
  for (int i=1;i<=100;i++){
      sum+=i;
  }
  out.print("<h1>SUM="+sum+"<h1>");
%>

<%
  int x=10;
  out.println(x);
%>
<%
  int y=100;
  out.println(y);
%>

<%--在代码中嵌入HTML元素--%>
<%--EL表达式--%>
 <%
    for(int i=0;i<=5;i++){
 %>
        <h1> hello,zty!| <%=i%> </h1>
    <%
    }
    %>

<hr>

<%--JSP声明--%>
<%!
    static{
    System.out.println("Loading Servlet!");
    }
    private int globalVar = 0;
    public void zty(){
    System.out.println("进入了方法zty！");
    }
%>
</body>
</html>