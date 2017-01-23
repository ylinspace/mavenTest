<%@ page contentType="text/html;charset=utf-8" language="java" %>

<%@ page import="java.sql.*" %>

<html>
<title>
这是forward后面的页面
</title>
<head></head>


<body>
这是forward后面的页面
<%=request.getParameter("age") %>

</body>
</html>