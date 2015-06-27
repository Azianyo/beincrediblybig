<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>

<form method="POST" action='UserController' name="frmAddUser">
  ID Uzytkownika : <input type="text" readonly="readonly" name="id_uzytkownik"
                       value="<c:out value="${user.id_uzytkownik}" />" /> <br />
  Admin Status : <input
        type="text" name="isAdmin"
        value="<c:out value="${user.isAdmin}" />" /> <br />
  Email : <input
        type="text" name="email"
        value="<c:out value="${user.email}" />" /> <br />
  Haslo : <input
        type="password" name="haslo"
        value="<c:out value="${user.haslo}" />" /> <br />

  <input type="submit" value="Submit" />
</form>
</body>
</html>
