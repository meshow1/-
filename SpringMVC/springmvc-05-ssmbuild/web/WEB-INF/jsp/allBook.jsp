<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>书籍展示</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表——显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-mid-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示所有书籍</a>
        </div>
        <div class="col-mid-4 column"/>
        <div class="col-mid-4 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                <input type="text" name="queryBookName" class="form-control" placeholder="查询名称" required>
                <input type="submit" value="查询" class="btn bt-primary">
            </form>
        </div>
    </div>




    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                </tr>
                </thead>

                <tbody>
                    <c:forEach var="book" items="${list}">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.bookID}">修改</a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/book/deleteBook?id=${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
