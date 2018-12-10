<#import "/spring.ftl" as spring/>
<html lang="pl">
<head>
    <meta charset="utf-8" />
    <title> ASC -Liczby zmiennoprzecinkowe</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link rel="stylesheet" href="../css/menu.css" type="text/css" />

    <script type="text/javascript"  src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
    <script type="text/javascript" src="../js/exerciseJs.js"></script>
</head>
<body>

    <div id="container">
        <div class="logo">
            <b><h1>ARYTMETYKA SYSTEMÓW CYFROWYCH<br />
                LICZBY ZMIENNOPRZECINKOWE</h1></b>
        </div>
        <div id="imglogo" >
            <img src="../img/logo.png" alt="logopolsl" style="width: 131px; padding: 10px;" />
        </div>
        <div style="clear:both;"></div>
        <div id="content">
            <hr>
                <#list exercises as exercise>
                    ZADANIE ${exercise.id} : ${exercise.contents} </br>
                        <label>ODPOWIEDZ:</label>
                        <input id="exe_${exercise.id}" type="text" name="answer" size="50" maxlength"25" />
                        <div id="resultOK_${exercise.id}" style="color: green; display: none;">
                            <span class="ok_symbol">&#10004;</span>
                        </div>
                        <div id="resultBAD_${exercise.id}" style="color: red; display: none;">
                            <span class="bad_symbol">&#10006;</span>
                        </div>
                        </br>
                        <p style="font-size:10px">Odpowiedź zapisz w formacie Mxp^C (ex. 0.20x10^-3).</p>
                        </br>
                            ${exercise.result.answer}
                        <button id="button_${exercise.id}" onclick="checkSolution('${exercise.result.answer}',document.getElementById('exe_${exercise.id}').value, '${exercise.id}', '${exercise.result.id}' )">Sprawdź</button>
                        <button id= "buttonShow_${exercise.result.id}" type="submit" onclick="myFunction('answer_${exercise.result.id}')" hidden ="true">Pokarz rozwiązanie</button>
                        <div id="answer_${exercise.result.id}" style="display:none;">
                                ${exercise.result.step_1}<br/>
                                ${exercise.result.step_2}<br/>
                                ${exercise.result.step_3}<br/>
                                ${exercise.result.step_4}<br/>
                        </div>

                    <hr>
                </#list>
        </div>
        <div class="nav">
            <ul>
                <li><a class="active"><h3>TEORIA</h3></a></li>
                <li><a href="../theory/theoryadd.html">DODAWANIE</a></li>
                <li><a href="../theory/theorysub.html">ODEJMOWANIE</a></li>
                <li><a href="../theory/theorymulti.html">MNOŻENIE</a></li>
                <li><a href="../theory/theorydiv.html">DZIELENIE</a></li>
                <li><a href="../theory/theorynorm.html">NORMALIZACJA</a></li>
                <li><a href="../theory/theorydenorm.html">DENORMALIZACJA</a></li>
            </ul>
            <ul>
                <li><a class="active"><h3>ZADANIA</h3></a></li>
                <li><a href="/addition">DODAWANIE</a></li>
                <li><a href="/subtration">ODEJMOWANIE</a></li>
                <li><a href="/multiplation">MNOŻENIE</a></li>
                <li><a href="/division">DZIELENIE</a></li>
            </ul>
            <ul>
                <li></li>
                <li><a class="active" href="/test"><b>T E S T</b></a></li>
                <li></li>
            </ul>
        </div>
        <div id="footer">
        </div>

    </div>
</body>
</html>
