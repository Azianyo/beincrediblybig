<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>

<form method="POST" action='RecipeIngredientController' name="frmAddUser">
  ID PrzepisSkladnik : <input type="text" readonly="readonly" name="id_przepis_skladnik"
                       value="<c:out value="${RecipeToIngredient.id_przepis_skladnik}" />" /> <br />
  ID  Przepis: <input
        type="text" name="id_przepis"
        value="<c:out value="${RecipeToIngredient.id_przepis}" />" /> <br />
  ID Skladnik : <input
        type="text" name="id_skladnik"
        value="<c:out value="${RecipeToIngredient.id_skladnik}" />" /> <br />
  Ilosc : <input
        type="text" name="ilosc"
        value="<c:out value="${RecipeToIngredient.ilosc}" />" /> <br />
  <input type="submit" value="Submit" />
</form>
</body>
</html>
