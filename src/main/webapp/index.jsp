<!DOCTYPE html>
<html lang="pl">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="Stylesheet" href="styleIndex.css">
	<script src="skrypt.js"></script>
	<title>Koksownia</title>
	<meta name="Description" content="Strona najlepszych koksiarzy" >
	<meta name="author" content="Wielki Koks">
</head>
<body>
<header id="header">
	<h1><a href="index.html" title="Strona głowna">Koksownia</a></h1>
	<nav>
		<ul id="menu">
			<li><a href="http://www.menshealth.pl/dieta/8-rzeczy-ktore-buduja-miesnie,3341,1" title="8 rzeczy które budują mieśnie">Cos o zarciu</a></li>
			<li><a href="https://www.youtube.com/watch?v=jyjuUHNwWD4" title="Krzysiu...">Jak zyc?</a></li>
			<li><a href="https://www.youtube.com/watch?v=ThyaLgEH3k0" title="Bruneika">Hyper Pump</a></li>
			<li><a href="https://www.youtube.com/watch?v=bTHFjLYE6MA" title="Spejson">Jak pic?</a></li>
			<li><a href="https://www.youtube.com/watch?v=oEXSLWH36xA" title="Kobiety">Panie</a></li>
		</ul>
	</nav>
</header>
<h2>Kim bedziesz jak dorosniesz?</h2>
<div id="Container">
	<form id="jadlospis">
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
				<input type="checkbox" name="warzywa" id="warzywa1">Marchewka<br>
				<input type="checkbox" name="warzywa" id="warzywa2">Cebula<br>
				<input type="checkbox" name="warzywa" id="warzywa3">Papryka<br>
				<input type="checkbox" name="warzywa" id="warzywa4">Pietruszka<br>
			</div>
			<div id="owoce">
			<label id="owoce">Owoce:</label><br>
				<input type="checkbox" name="owoce" id="owoce1">Jablko<br>
				<input type="checkbox" name="owoce" id="owoce2">Pitahaja<br>
				<input type="checkbox" name="owoce" id="owoce3">Gruszka<br>
				<input type="checkbox" name="owoce" id="owoce4">Poziomka<br>
			</div>
			<div id="mieso">
			<label id="mieso">Mieso:</label><br>
				<input type="checkbox" name="mieso" id="mieso1">Baranina<br>
				<input type="checkbox" name="mieso" id="mieso2">Ryby<br>
				<input type="checkbox" name="mieso" id="mieso3">Kurczak<br>
				<input type="checkbox" name="mieso" id="mieso4">Wolowina<br>
			</div>
			<div id="nabial">
			<label id="nabial">Nabial:</label><br>
				<input type="checkbox" name="nabial" id="nabial1">Jogurt<br>
				<input type="checkbox" name="nabial" id="nabial2">Mleko<br>
				<input type="checkbox" name="nabial" id="nabial3">Ser<br>
				<input type="checkbox" name="nabial" id="nabial4">Jaja<br>
			</div>
			<div id="inne">
				<label id="inne">Inne:</label><br>
				<input type="checkbox" name="inne" id="inne1">Makaron<br>
				<input type="checkbox" name="inne" id="inne2">Pieczywo<br>
				<input type="checkbox" name="inne" id="inne3">Kuskus<br>
				<input type="checkbox" name="inne" id="inne4">Ryz<br>
			</div>
			<div id="wybor">
				<input type="submit" name="wyszukaj" id="wyszukaj" value="Wyszukaj przepis"/>
				<input type="submit" name="uloz" id="uloz" value="Stworz diete"/>
			</div>
		</form>
	</div>
<footer id="footer">
	<p>Copyright by Koksownia &copy; 2015</p>
	<p>Strona by Wielki koksu</p>
</footer>
</body>
</html>
