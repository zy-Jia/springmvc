<%--
  Created by IntelliJ IDEA.
  User: gyofu
  Date: 2022/1/15
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var user = {
                "id":1,
                "name":"张三"
            };
            $.ajax({
                url:"/data/json",
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                dataType:"JSON",
                success:function (data){
                    alert(data.id + "---" + data.name);
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
