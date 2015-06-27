<%--
  Created by IntelliJ IDEA.
  User: macie_000
  Date: 2015-06-27
  Time: 17:24
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
    <th>Id skladnik</th>
    <th>nazwa</th>

    <th colspan=2>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${skladniki}" var="skladnik">
    <tr>
      <td><c:out value="${skladnik.id_skladnik}" /></td>
      <td><c:out value="${skladnik.nazwa}" /></td>

      <td><a href="IngredientsController?action=edit&id_przepis=<c:out value="${skladnik.id_skladnik}"/>">Update</a></td>
      <td><a href="IngredientsController?action=delete&id_przepis=<c:out value="${skladnik.id_skladnik}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="IngredientController?action=insert">Add User</a></p>
</body>
</html>

