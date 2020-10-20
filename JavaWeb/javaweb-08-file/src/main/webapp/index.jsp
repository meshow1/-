<%--
  Created by IntelliJ IDEA.
  User: apple丶eye
  Date: 2020/10/12
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--通过表单(表单名为upload.do)上传文件get有传输大小限制，选择post,
  如果包含文件上传enctype需要设置为 enctype="multipart/form-data"

  ${pageContext.request.contextPath}表示页面路径

    application/x-www-form-urlencoded	在发送前编码所有字符（默认）
    multipart/form-data	不对字符编码。在使用包含文件上传控件的表单时，必须使用该值。
    text/plain	空格转换为 "+" 加号，但不对特殊字符编码。--%>
<form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
    <p><input type="file" name="file1"></p>
    <p><input type="submit"> | <input type="reset"></p>
</form>

</body>
</html>
