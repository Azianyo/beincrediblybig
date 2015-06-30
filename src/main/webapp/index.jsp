<!doctype html>
<html>
<head>
  <title>W chuj wyjebane</title>
  <meta charset="UTF-8">
</head>
<body>
witness true greatness
<style type="text/css" media="print">
    .no-print { display: none; }
</style>

<form method="POST" action="FullRecipeController">
    <input type="text" name="id_przepis" value="id_przepis">
    <input type="Submit">
</form>


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
    <input type="Submit" value="Usun">
</form>

<h1 align="center">Uloz Diete</h1>
<form method="GET" action="RecipeController">
    Czego nie trawisz:
    <input TYPE=checkbox name=fruit VALUE=apples> Apples <BR>
    <input TYPE=checkbox name=fruit VALUE=grapes> Grapes <BR>
    <input TYPE=checkbox name=fruit VALUE=oranges> Oranges <BR>
    <input TYPE=checkbox name=fruit VALUE=melons> Melons <BR>
    <input type="hidden" name="action" value="CreateDiet">
    <input type="Submit" value = "Uloz Diete">
</form>

<form>
    <input type="button" onClick="window.print()" class="no-print" value="Wydrukuj lub ściągnij wypis w PDF">
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
    <input type="Submit" value="Usun">
</form>

<h1 align="center">Uzytkownik</h1>
<form method="POST" action="UserController">
    <input type="text" name="isAdmin" value="admin">
    <input type="text" name="email" value="email">
    <input type="password" name="haslo" value="haslo">
    <input type="text" name="id_uzytkownik">
    <input type="Submit">
</form>


<h1 align="center">Uzytkownik</h1>
<form method="GET" action="UserController">
    <input type="text" name="id_uzytkownik">
    <input type="hidden" name="action" value="delete">
    <input type="Submit" value="Usun konto">
</form>

<h1 align="center">Posilek</h1>
<form method="POST" action="MealController">
    <input type="text" name="nazwa" value="nazwa posilku">
    <input type="text" name="id_posilek">

    <input type="Submit">
</form>


<h1 align="center">Posilek</h1>
<form method="GET" action="MealController">
    <input type="text" name="id_posilek">
    <input type="hidden" name="action" value="delete">
    <input type="Submit" value="Usun">
</form>

<h1 align="center">Skladnik przepisu</h1>
<form method="POST" action="RecipeIngredientController">
    <input type="text" name="id_przepis_skladnik">
    <input type="text" name="id_przepis">
    <input type="text" name="id_skladnik">
    <input type="text" name="ilosc" value="ilosc">
    <input type="Submit">
</form>


<h1 align="center">Skladnik przepisu</h1>
<form method="GET" action="RecipeIngredientController">
    <input type="text" name="id_przepis_skladnik">
    <input type="hidden" name="action" value="delete">
    <input type="Submit" value="Usun">
</form>

<h1 align="center">Skladnik przepisu, ktorego nie chcesz</h1>
<form method="GET" action="RecipeController">
    <input type="text" name="name_skladnik" >
    <input type="hidden" name="action" value="SearchRecipes">
    <input type="Submit"value="Znajdz przepisy">
</form>

</body>
</html>
