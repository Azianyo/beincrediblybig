<!doctype html>
<html>
<head>
  <title>kurwa ma</title>
  <meta charset="UTF-8">
</head>
<body>
Janek, kurwa, ja to wrzucam


<h1 align="center">Coupons categories</h1>
<form method="POST" action="RecipeController">
  <input type="text" name="nazwa" value="nazwa przepisu">
  <input type="text" name="opis" value="opis">
  <input type="text" name="ocena" value="ocena">
  <input type="text" name="typ" value="typ">
  <input type="text" name="zdjecie" value="zdjecie">
  <input type="Submit">
</form>
<br><br>
<p><a href="RecipeController?action=insert"></a></p>

<h1 align="center">Coupons categories</h1>
<form method="POST" action="RecipeController">
  <input type="text" name="nazwa" value="nazwa przepisu">
  <input type="text" name="opis" value="opis">
  <input type="text" name="ocena" value="ocena">
  <input type="text" name="typ" value="typ">
  <input type="text" name="zdjecie" value="zdjecie">
  <input type="text" name="id_przepisu" value="Nr przepisu">
  <input type="Submit">
</form>
<p><a href="RecipeController?action=insert"></a></p>
</body>
</html>
