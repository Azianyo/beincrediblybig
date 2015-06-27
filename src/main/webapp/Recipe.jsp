<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>

<form method="POST" action='RecipeController' name="frmAddUser">
  ID Przepisu : <input type="text" readonly="readonly" name="id_przepis"
                   value="<c:out value="${przepis.id_przepis}" />" /> <br />
  Nazwa : <input
        type="text" name="nazwa"
        value="<c:out value="${przepis.nazwa}" />" /> <br />
  Opis : <input
        type="text" name="opis"
        value="<c:out value="${przepis.opis}" />" /> <br />
  Ocena : <input
        type="text" name="ocena"
        value="<c:out value="${przepis.ocena}" />" /> <br />
  Typ : <input
        type="text" name="typ"
        value="<c:out value="${przepis.typ}" />" /> <br />
  Zdjecie : <input type="text" name="zdjecie"
                 value="<c:out value="${user.zdjecie}" />" /> <br />
  <input type="submit" value="Submit" />
</form>
</body>
</html>
