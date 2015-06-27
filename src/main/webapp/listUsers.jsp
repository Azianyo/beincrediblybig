
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
    <th>Id uzytkownika</th>
    <th>admin</th>
    <th>email</th>
    <th>haslo</th>
    <th colspan=2>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user">
    <tr>
      <td><c:out value="${user.id_uzytkownik}" /></td>
      <td><c:out value="${user.isAdmin}" /></td>
      <td><c:out value="${user.email}" /></td>
      <td><c:out value="${user.haslo}" /></td>
      <td><a href="UserController?action=edit&id_uzytkownik=<c:out value="${user.id_uzytkownik}"/>">Update</a></td>
      <td><a href="UserController?action=delete&id_uzytkownik=<c:out value="${user.id_uzytkownik}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="UserController?action=insert">Add User</a></p>
</body>
</html>
