<html lang="pl">
<head>
    <meta charset="utf-8" />
    <title> ASC -Liczby zmiennoprzecinkowe</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link rel="stylesheet" href="../css/menu.css" type="text/css" />
    <script type="text/javascript"  src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

    <script type="text/javascript" src="../js/testJs.js"></script>
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
            <button id="buttonStartTest" onclick="showTest('formTest')">START TEST</button>
                <div id="formTest" hidden="true">
                    <div id="clock" style="text-align: center;">01:00</div>
                    <hr>
                    <#list test as ex>
                    ZADANIE ${ex.id} : ${ex.contents}
                    <br />
                    <label>ODPOWIEDZ:</label>
                    <input id="exe_${ex.id}" type="text" name="answer" size="50" maxlength"30" />
                    <br />
                    <p style="font-size:10px">Odpowiedz zapisz w formacie Mxp^C (ex. 0.20x10^-3)</p>
                        ${ex.result.answer}
                    <div id="user_result_${ex?index}" hidden="true">exe_${ex.id}</div>
                    <div id="ex_result_${ex?index}" hidden="true">${ex.result.answer}</div>
                        <hr>
                </#list>
                </br>
                <button id="buttonEndTest" onclick="endTest()">END TEST</button>
            </div>
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