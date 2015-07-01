<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="Stylesheet" href="styleIndex.css">
	<script type="text/javascript" charset="UTF-8"></script>
	<title>Koksownia</title>
	<meta name="Description" content="Strona najlepszych koksiarzy" >
	<meta name="author" content="Wielki Koks">
</head>
<body>
<header id="header">
	<h1><a href="index.jsp" title="Strona główna">Koksownia</a></h1>
	<nav>
		<ul id="menu">
			<li><a href="http://www.menshealth.pl/dieta/8-rzeczy-ktore-buduja-miesnie,3341,1" title="8 rzeczy które budują mieśnie">Coś o żarciu</a></li>
			<li><a href="https://www.youtube.com/watch?v=jyjuUHNwWD4" title="Krzysiu...">Jak życ?</a></li>
			<li><a href="https://www.youtube.com/watch?v=ThyaLgEH3k0" title="Bruneika">Hyper Pump</a></li>
			<li><a href="https://www.youtube.com/watch?v=oEXSLWH36xA" title="Kobiety">Panie</a></li>
		</ul>
	</nav>
</header>
<h2>Kim będziesz jak dorośniesz?</h2>
<div id="Container">
	<form id="jadlospis" method="POST" action="RecipeController">
		<div id="koksImg">
			<label>
				<input type="radio" name="koks" id="koks" value="koks" />
				<img src="<%=request.getContextPath()%>/images/koks.jpeg" alt="Koks">
			</label>
			<label>
				<input type="radio" name="koks" id="maxi" value="maxi"/>
				<img src="<%=request.getContextPath()%>/images/maxiKoks.jpeg" alt="Koks">
			</label>
			<label>
				<input type="radio" name="koks" id="ultra" value="ultra" checked>
				<img src=<%=request.getContextPath()%>/images/ultraKoks.jpeg" alt="Koks">
			</label>
		</div>
		<h4>Czego nie trawisz?</h4>
		<div id="warzywa">
			<label id="warzywa">Warzywa:</label><br>
			<input type="checkbox" name="ingredientname" value="Marchewka" id="warzywa1">Marchewka<br>
			<input type="checkbox" name="ingredientname" value="Cebula" id="warzywa2">Cebula<br>
			<input type="checkbox" name="ingredientname" value="Papryka" id="warzywa3">Papryka<br>
			<input type="checkbox" name="ingredientname" value="Pietruszka" id="warzywa4">Pietruszka<br>
		</div>
		<div id="owoce">
			<label id="owoce">Owoce:</label><br>
			<input type="checkbox" name="ingredientname" value="Jablko" id="owoce1">Jabłko<br>
			<input type="checkbox" name="ingredientname" value="Pitahaja" id="owoce2">Pitahaja<br>
			<input type="checkbox" name="ingredientname" value="Gruszka" id="owoce3">Gruszka<br>
			<input type="checkbox" name="ingredientname" value="Poziomka" id="owoce4">Poziomka<br>
		</div>
		<div id="mieso">
			<label id="mieso">Mięso:</label><br>
			<input type="checkbox" name="ingredientname" value="Baranina" id="mieso1">Baranina<br>
			<input type="checkbox" name="ingredientname" value="Ryby" id="mieso2">Ryby<br>
			<input type="checkbox" name="ingredientname" value="Kurczak" id="mieso3">Kurczak<br>
			<input type="checkbox" name="ingredientname" value="Wolowina" id="mieso4">Wołowina<br>
		</div>
		<div id="nabial">
			<label id="nabial">Nabiał:</label><br>
			<input type="checkbox" name="ingredientname" value="Jogurt" id="nabial1">Jogurt<br>
			<input type="checkbox" name="ingredientname" value="Mleko" id="nabial2">Mleko<br>
			<input type="checkbox" name="ingredientname" value="Ser" id="nabial3">Ser<br>
			<input type="checkbox" name="ingredientname" value="Jaja" id="nabial4">Jaja<br>
		</div>
		<div id="inne">
			<label id="inne">Inne:</label><br>
			<input type="checkbox" name="ingredientname" value="Makaron" id="inne1">Makaron<br>
			<input type="checkbox" name="ingredientname" value="Pieczywo" id="inne2">Pieczywo<br>
			<input type="checkbox" name="ingredientname" value="Kuskus" id="inne3">Kuskus<br>
			<input type="checkbox" name="ingredientname" value="Ryz" id="inne4">Ryż<br>
		</div>
		<div id="wybor">
			<input type="submit"  name="action" id="wyszukaj" value="Wyszukaj przepis"/>
			<input type="submit"  name="action" id="uloz" value="Stworz diete"/>
		</div>
	</form>
</div>
<footer id="footer">
	<p>Copyright by Koksownia &copy; 2015</p>
	<p>Strona by Wielki koksu</p>
</footer>
</body>
</html>
