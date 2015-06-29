<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 2015-06-29
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Users</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>id</th>
        <th>nazwa</th>
        <th>opis</th>
        <th>typ</th>


        <%--<th colspan=2>Action</th>--%>
    </tr>
    </thead>
  <tbody>


    <c:forEach items="${Posilkipierwsze}" var="przepis">
         <tr>
            <td><c:out value="${przepis.id_przepis}" /></td>
            <td><c:out value="${przepis.nazwa}" /></td>
            <td><c:out value="${przepis.opis}" /></td>
            <td><c:out value="${przepis.typ}" /></td>
        </tr>
    </c:forEach>

        <%--<tr>
            <td><a href="IngredientController?action=edit&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">I (8.00)</a></td>

        </tr>--%>

    </tbody>

</table>
<p><a href="IngredientController?action=insert">Generuj PDF</a></p>
</body>
</html>
