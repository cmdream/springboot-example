<%--
  Created by IntelliJ IDEA.
  User: gril
  Date: 2018/12/14
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 导入standard.jar，引入jstl表达式 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>


<!-- session -->
<%--<%
    String name = (String)session.getAttribute("name");
    out.print("    "+name+"    " + request.getServletContext().getAttribute("age"));
%>--%>


<%--<span>路径：<%=request.getRealPath("/")%></span>
<% String path = request.getContextPath();
    System.out.print("    ==========="+path);
%>
    <table border="1">
        <tr><td>id</td></tr>
        <c:forEach items="${list}" var="p">

            <tr>
                <td>${p.id=='110109' ? 'yes':'no' }</td>
            </tr>

        </c:forEach>

    </table>--%>
</body>
</html>
