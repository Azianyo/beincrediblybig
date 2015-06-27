
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
    <th>Id przepis skladnik</th>
    <th>Id przepis</th>
    <th>Id skladnik</th>
    <th>ilosc</th>
    <th colspan=2>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${przepis_skladnik}" var="przepis_skladnik">
    <tr>
      <td><c:out value="${przepis_skladnik.id_przepis_skladnik}" /></td>
      <td><c:out value="${przepis_skladnik.id_przepis}" /></td>
      <td><c:out value="${przepis_skladnik.id_skladnik}" /></td>
      <td><c:out value="${przepis_skladnik.ilosc}" /></td>
      <td><a href="RecipeIngredientController?action=edit&id_przepis_skladnik=<c:out value="${przepis_skladnik.id_przepis_skladnik}"/>">Update</a></td>
      <td><a href="RecipeIngredientController?action=delete&id_przepis_skladnik=<c:out value="${przepis_skladnik.id_przepis_skladnik}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="RecipeIngredientController?action=insert">Add User</a></p>
</body>
</html>

