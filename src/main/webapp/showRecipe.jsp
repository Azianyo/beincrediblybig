<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Przepis na bicka</title>
</head>
  <body>
  <td><img src="${przepis.zdjecie}" alt="" border=3 height=400 width=400></td>
  <table border=1>
    <thead>
    <tr>
      <th>Skladniki</th>
        <th> Ilosc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${skladniki}" var="skladnik">
      <tr>
        <td><c:out value="${skladnik.nazwa}" /></td>
          <td><c:out value="${ilosc}" /></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <br>
  <fieldset>
    <c:out value="${przepis.opis}"/>
  </fieldset>
  <fieldset>
      Ilosc bickow: <c:out value="${przepis.ocena}"/>
  </fieldset>
  <br>
    <form method="POST" action='FullRecipeController'>
        <input type="hidden" name="id" value="<c:out value="${przepis.id_przepis}" />" />
      <input type="submit" value="Przyznaj bicka" name="giveBiceps" />
    </form>
    <form method="POST" action='FullRecipeController'>
      <input type="submit" value="Strona główna" name="mainPage" />
    </form>
  </body>
</html>
