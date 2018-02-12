<#import "spring.ftl" as ex />
<html lang="pl">
<head>
    <title>BLECH</title>
    <link rel="stylesheet" href="<@ex.url 'css/styl.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@ex.url 'css/menu.css'/>" type="text/css"/>
    <meta charset="UTF-8">

</head>
<aside><div class="aside" style="float: center; width:80%; height: 100%; background-color: #24406d;">
    <img class="logo" src="img/logo.png" alt="polsllogo">
    <p></p>
    <ul>
        <li><a class="active">TEORIA</a></li>
        <li><a href="theoryadd.html"><h2>DODAWANIE</h2></a></li>
        <li><a href="theorysub.html" style="margin-left: -3px"><h2>ODEJMOWANIE</h2></a></li>
        <li><a href="theorymulti.html" style="margin-left: 4px"><h2>MNOŻENIE</h2></a></li>
        <li><a href="theorydiv.html" style="margin-left: 5px"><h2>DZIELENIE</h2></a></li>
        <li><a href="theorynorm.html" style="margin-left: -3px"><h2>NORMALIZACJA</h2></a></li>
        <li><a href="theorydenorm.html" style="margin-left: -13px"><h2>DENORMALIZACJA</h2></a></li>
    </ul>
    <p></p>
    <ul>
        <li><a class="active">ZADANIA</a></li>
        <li><a href="#news"><h2>DODAWANIE</h2></a></li>
        <li><a href="#contact" style="margin-left: -3px"><h2>ODEJMOWANIE</h2></a></li>
        <li><a href="#about" style="margin-left: 4px"><h2>MNOŻENIE</h2></a></li>
        <li><a href="#about" style="margin-left: 5px"><h2>DZIELENIE</h2></a></li>
    </ul>
    <p></p>
    <ul>
        <li></li>
        <li><a class="active" href="#test"><b>T E S T</b></a></li>
        <li></li>
    </ul>
</div></aside>
<header>
    <div class="header"><a href="#mainpage" style="text-decoration: none;">
        <h1>ARYTMETYKA SYSTEMÓW CYFROWYCH</h1>
        <h1>LICZBY ZMIENNOPRZECINKOWE</h1></a>
        <div style="border-bottom: 1px solid #252525; width: 90%; float: center; margin-left: 25px;">
        </div>
    </div>
</header>
<section>
    <#list exercises as exercise>
    ZADANIE : ${exercise.contents} </br>
    <form action="*">
        <label>ODPOWIEDZ:</label> <input type="text" name="answer" size="50" maxlength"30" />
        </br> <p style="min-font-size:4px ">Odpowiedz zapisz w formacie Mxp^C (ex. 0.20x10^-3)</p>
        </br><button type="submit">SPRAWDŹ</button>
    </form>
    <hr>
</#list>
</section>
<footer> </footer>
</body>
</html>
