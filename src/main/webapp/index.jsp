<!doctype html>
<html>
<head>
  <title>kurwa mać</title>
  <meta charset="UTF-8">
</head>
<body>
witness true greatness


<h1 align="center">Przepisy</h1>
<form method="POST" action="RecipeController">
  <input type="text" name="nazwa" value="nazwa przepisu">
  <input type="text" name="opis" value="opis">
  <input type="text" name="ocena" value="ocena">
  <input type="text" name="typ" value="typ">
  <input type="text" name="zdjecie" value="zdjecie">
  <input type="text" name="id_przepis">
  <input type="Submit">
</form>


<h1 align="center">przepis</h1>
<form method="GET" action="RecipeController">
    <input type="text" name="id_przepis">
    <input type="hidden" name="action" value="delete">
    <input type="Submit">
</form>

<h1 align="center">Skladnik</h1>
<form method="POST" action="IngredientController">
    <input type="text" name="nazwa" value="nazwa skladnika">
    <input type="text" name="id_skladnik">

    <input type="Submit">
</form>


<h1 align="center">Skladnik</h1>
<form method="GET" action="IngredientController">
    <input type="text" name="id_skladnik">
    <input type="hidden" name="action" value="delete">
    <input type="Submit">
</form>

<h1 align="center">SkladnikPrzepis</h1>
<form method="POST" action="RecipeIngredientController">
    <input type="text" name="nazwa" value="nazwa skladnika">
    <input type="text" name="id_przepis_skladnik">

    <input type="Submit">
</form>


<h1 align="center">SkladnikPrzepis</h1>
<form method="GET" action="RecipeIngredientController">
    <input type="text" name="id_przepis_skladnik">
    <input type="hidden" name="action" value="delete">
    <input type="Submit">
</form>
</body>
</html>
