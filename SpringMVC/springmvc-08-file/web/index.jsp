<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  multipart/form-data代表二进制流的形式提交表单--%>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" value="upload">
  </form>
  </body>
</html>
