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
</head>
<body>

<form method="POST" action='IngredientController' name="frmAddIngedients">
  lolololo : <input type="text" readonly="readonly" name="id_skladnik"
                       value="<c:out value="${skladnik.id_skladnik}" />" /> <br />
  Nazwa : <input
        type="text" name="nazwa"
        value="<c:out value="${skladnik.nazwa}" />" /> <br />

  <input type="submit" value="Submit" />
</form>
</body>
</html>