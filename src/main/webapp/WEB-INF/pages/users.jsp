<%-- 
    Document   : Student
    Created on : Nov 20, 2015, Nov 20, 2015 12:12:12 AM
    Author     : apanasovich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>Welcome : ${pageContext.request.userPrincipal.name} 
                 | <a href="<c:url value="/logout" />" > Logout</a></h2>  
	</c:if>
        <h1>All user</h1>

        <c:forEach items="${users}" var="user">
            ${user.name}<br> ${user.department.name}
        </c:forEach>

    </body>
</html>
