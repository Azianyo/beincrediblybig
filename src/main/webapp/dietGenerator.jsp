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
        <th colspan=5>Poniedziałek</th>
        <th colspan=5>Wtorek</th>
        <th colspan=5>Sroda</th>
        <th colspan=5>Czwartek</th>
        <th colspan=5>Piatek</th>
        <th colspan=5>Sobota</th>
        <th colspan=5>Niedziela</th>
        <%--<th colspan=2>Action</th>--%>
    </tr>
    </thead>
  <tbody>

        <tr>
            <td><a href="IngredientController?action=edit&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">I (8.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">III (14.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>"> Przed Treningiem</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">Po treningu</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">V (22.00)</a></td>
            <td><a href="IngredientController?action=edit&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">I (8.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">III (14.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>"> Przed Treningiem</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">Po treningu</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">V (22.00)</a></td>
            <td><a href="IngredientController?action=edit&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">I (8.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">III (14.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>"> Przed Treningiem</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">Po treningu</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">V (22.00)</a></td>
            <td><a href="IngredientController?action=edit&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">I (8.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">III (14.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>"> Przed Treningiem</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">Po treningu</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">V (22.00)</a></td>
            <td><a href="IngredientController?action=edit&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">I (8.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">III (14.00)</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>"> Przed Treningiem</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">Po treningu</a></td>
            <td><a href="IngredientController?action=delete&id_skladnik=<c:out value="${skladnik.id_skladnik}"/>">V (22.00)</a></td>
        </tr>

    </tbody>

</table>
<p><a href="IngredientController?action=insert">Generuj PDF</a></p>
</body>
</html>
