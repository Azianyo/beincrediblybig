<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="styleRecipe.css" >
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/JavaScript" src="js/index.js"></script>
<html>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <head>
            <title>Przepis</title>
            <link rel="stylesheet" href="styleRecipe.css" type="text/css">
            <div class="alert alert-success" role="alert"><img src="<%=request.getContextPath()%>/images/bialko_nagl.jpg" alt="nagl" class="img-thumbnail"><h1>Przepis</h1></div>
        </head>
        <body>
        <style type="text/css" media="print">
            .no-print { display: none; }
        </style>
        <div class="jumbotron">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <div class="media">
                        <div class="media-body">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <H2><b>Nazwa</b></H2><br>
                                    <b><c:out value="${przepis.nazwa}" /></b><br>
                                    <img src="<c:out value="${przepis.zdjecie}" />" alt="" height=400 width=400><br>
                                    <c:out value="${przepis.opis}" /><br><br>
                                    <table border=1>
                                        <thead>
                                        <tr>
                                            <th>Skladniki</th>
                                            <th>Ilosc</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${skladniki}" var="skladnik">
                                            <tr>
                                                <td><c:out value="${skladnik.ingredient.nazwa}" /></td>
                                                <td><c:out value="${skladnik.amount}" /></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table><br>
                                    <fieldset>
                                        Ilosc bickow: <c:out value="${przepis.ocena}"/>
                                    </fieldset><br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
        <nav>
            <ul class="pager">
                <form method="POST" action='FullRecipeController'>
                    <input type="hidden" name="id" value="<c:out value="${przepis.id_przepis}" />" />
                    <input type="submit" value="Przyznaj bicka" name="giveBiceps" class="btn btn-default btn-lg no-print"/>
                </form><br>
                <form>
                    <input type="button" onClick="window.print()" class="btn btn-default btn-lg no-print" value="Jadlospis w PDF">
                </form>
                <form method="POST" action='FullRecipeController'>
                    <input type="submit" value="Strona główna" class="btn btn-default btn-lg no-print" name="mainPage" />
                </form>
            </ul>
        </nav>
        </body>
    </div>
</div>
<footer id="footer">
    <p>Copyright by Koksownia &copy; 2015</p>
    <p>Strona by Wielki koksu</p>
</footer>
</html>
