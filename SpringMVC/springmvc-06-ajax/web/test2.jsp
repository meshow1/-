<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>


<%--    通过点击按钮进行去调用函数，从而改变页面布局对页面局部进行更改，而不用刷新页面--%>
    <script>
        $(function () {
            $("#btn").click(function () {
                // post(url, data, function(data,status,xhr)（可选）, success)三个参数
                $.post("${pageContext.request.contextPath}/a2", function (data) {//data的意思是拿到的返回参数,不是前面的data
                    // console.log(data);
                    var html = "";
                    for (let i=0;i<data.length;i++){
                        html+="<tr>" +
                            "<td>"+data[i].name+"</td>"+
                            "<td>"+data[i].age+"</td>"+
                            "<td>"+data[i].sex+"</td>"+
                            "</tr>"
                    }
                    $("#content").html(html);//传给id为content
                });
            })
        });
    </script>
</head>
<body>

<input type="button" value="加载数据" id="btn">

<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
    </tbody>
</table>

</body>
</html>
