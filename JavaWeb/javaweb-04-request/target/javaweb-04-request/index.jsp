<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<h1>登录</h1>

<div style="text-align: center">
<%--    提交post表单至login页面--%>
    <form action="/root/login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好:
        <input type="checkbox" name="hobbys" value="女孩">女孩
        <input type="checkbox" name="hobbys" value="男孩">男孩

        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
