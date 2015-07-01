<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" >
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/JavaScript" src="js/index.js"></script>
<html>
<head>
    <title>Lista wszystkich przepisow</title>
    <link rel="stylesheet" href="styleDiet.css" type="text/css">
    <div class="alert alert-success" role="alert"><img src="<%=request.getContextPath()%>/images/bialko_nagl.jpg" alt="nagl" class="img-thumbnail"><h1>Wszystkie przepisy w jednym miejscu</h1></div>
</head>
<body>
<style type="text/css" media="print" scoped>
    .no-print { display: none; }
</style>
<table border=1>
    <thead>
    <tr>
        <th>Id przepis</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Ocena</th>
        <th>Typ</th>
        <th>Zdjecie</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${przepisy}" var="przepis">
        <tr>
            <td><c:out value="${przepis.id_przepis}" /></td>
            <td><c:out value="${przepis.nazwa}" /></td>
            <td><c:out value="${przepis.opis}" /></td>
            <td><c:out value="${przepis.ocena}" /></td>
            <td><c:out value="${przepis.typ}" /></td>
            <td><img src="${przepis.zdjecie}" alt="" border=3 height=100 width=100></td>
            <td><form method="POST" action="FullRecipeController">
                <input type="hidden" name="id_przepis" value="<c:out value="${przepis.id_przepis}"/>">
                <input type="Submit" value="Pokaz przepis">
            </form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="RecipeController?action=insert">Add User</a></p>
<ul class="pager">
    <form>
        <input type="button" onClick="window.print()" class="btn btn-default btn-lg no-print" value="Przepisy w PDF">
    </form>
    <form method="POST" action='FullRecipeController'>
        <input type="submit" value="Strona główna" class="btn btn-default btn-lg no-print" name="mainPage" />
    </form>
</ul>
</body>
<footer id="footer">
    <p>Copyright by Koksownia &copy; 2015</p>
    <p> Strona by Wielki koksu</p>
</footer>
</html>
