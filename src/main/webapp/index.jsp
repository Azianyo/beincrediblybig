<!doctype html>
<html>
<head>
  <title>kurwa mać</title>
  <meta charset="UTF-8">
</head>
<body>
Janek, kurwa, ja to wrzucam


<h1 align="center">Coupons categories</h1>
<form method="POST" action="RecipeController?action=insert">
  <input type="text" name="nazwa" value="nazwa przepisu">
  <input type="text" name="opis" value="opis">
  <input type="text" name="ocena" value="ocena">
  <input type="text" name="typ" value="typ">
  <input type="text" name="zdjecie" value="zdjecie">
  <input type="text" name="id_przepis">
  <input type="Submit">
</form>


<h1 align="center">Coupons categories</h1>
<form method="GET" action="RecipeController?action=delete">
    <input type="text" name="przepis_id">
    <input type="Submit">
</form>


</body>
</html>
