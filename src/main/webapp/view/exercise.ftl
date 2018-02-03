<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>EXERCISE</title>
</head>
<body>
<h2>TASK</h2>


<#list exercises as exercise>
ZADANIE : ${exercise.contents} </br>
<form action="*">
    <label>ODPOWIEDZ:</label> <input type="text" name="answer" size="50" maxlength"30" />
    </br> <p style="min-font-size:4px ">Odpowiedz zapisz w formacie Mxp^C (ex. 0.20x10^-3)</p>
    </br><button type="submit">SPRAWDŹ</button>
</form>
<hr>
</#list>


</body>
</html>