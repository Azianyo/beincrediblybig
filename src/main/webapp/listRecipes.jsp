
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
    <th>Id przepis</th>
    <th>nazwa</th>
    <th>opis</th>
    <th>ocena</th>
    <th>typ</th>
    <th colspan=2>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${przepisy}" var="przepis">
    <tr>
      <td><c:out value="${przepis.id_przepis}" /></td>
      <td><c:out value="${przepis.nazwa}" /></td>
      <td><c:out value="${przepis.opis}" /></td>
      <td><c:out value="${przepis.email}" /></td>
      <td><a href="RecipeController?action=edit&id_przepis=<c:out value="${przepis.id_przepis}"/>">Update</a></td>
      <td><a href="RecipeController?action=delete&id_przepis=<c:out value="${przepis.id_przepis}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="RecipeController?action=insert">Add User</a></p>
</body>
</html>
