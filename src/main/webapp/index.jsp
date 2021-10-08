<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/12
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IMDb Top 250</title>
</head>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
    $(function(){
        $("#btn1").click(function(){
            $.ajax({
                url:"movies/findAll",
                contentType:"application/json;charset=UTF-8",
                type:"get",
                success:function (data) {
                    console.log(data)
                }
            })
            alert("testJqAjax")
        });
    });
</script>
<body>
<button id="btn1">testJqPost</button>
<img src="images/567.jpg">
</body>
</html>
