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
    <th>Id posilek</th>
    <th>nazwa</th>
    <th colspan=2>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${posilki}" var="posilek">
    <tr>
      <td><c:out value="${posilek.id_posilek}" /></td>
      <td><c:out value="${posilek.nazwa}" /></td>
      <td><a href="RecipeController?action=edit&id_posilek=<c:out value="${posilek.id_posilek}"/>">Update</a></td>
      <td><a href="RecipeController?action=delete&id_posilek=<c:out value="${posilek.id_posilek}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="MealController?action=insert">Add User</a></p>
</body>
</html>
