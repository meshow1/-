<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
 <head>
     <title>Title</title>
 </head>

<body>
<%
    String name="姜";
%>

name:<%=name%>
</body>
</html>

<%-- JSP本质就是servlet!!!!,JSP会生成java，class文件，转为java程序
 可以观察 tomcat目录下C:\Users\apple丶eye\AppData\Local\JetBrains\IntelliJIdea2020.2\tomcat\Unnamed_JavaWeb\work\Catalina\localhost\root\org\apache\jsp的源码
 其中定义了

     _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
    可以直接使用--%>