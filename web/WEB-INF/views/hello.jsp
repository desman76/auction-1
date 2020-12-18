<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello page</title>
    <%--<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/style/styles.css" />--%>
    <link href="${pageContext.request.contextPath}/WEB-INF/resources/style/style.css"/>
</head>
<body>
<h2>Hello, ${name}</h2>
<p style="font-size: 30px">h</p>
</body>
</html>
