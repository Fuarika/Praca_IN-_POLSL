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
            <a href="/" style="text-decoration: none;">
            <b><h1>ARYTMETYKA SYSTEMÓW CYFROWYCH<br />
                LICZBY ZMIENNOPRZECINKOWE</h1></b>
        </a>
        </div>
        <div id="imglogo" >
            <a href="https://www.polsl.pl/Strony/Witamy.aspx">
                <img src="/img/logo.png" alt="logopolsl" style="width: 131px; padding: 10px;" />
            </a>
        </div>
        <div style="clear:both;"></div>
        <div class="content">
            <hr>
            <h1>instrukcja</h1>
            <ul style="list-style-type: none;">
                <li>1) Test składa się z 5 zadań i trwa 15 minut.</li>
                <li>2) Poprawnie rozwiązanie zadania daje 1 punkt.</li>
                <li>3) W przypadku wcześniejszego napisania testu nacisknij przycisk <b>KONIEC</b>.</li>
                <li>4) Po wciścięciu przycisku <b>START</b> i potwierdzeniu chęci udziału w teście, rozpocznię się odliczanie czasu. </li>
                <li><p style="color: crimson; text-transform: uppercase; margin-top: -1px;"> <b>Pamiętaj o zapianiu wyniku w formie znormalizowanej !!</b></b></p> </li>
            </ul>
            <div style="text-align: center; margin-left -300px; margin-top: 20px;">
                <button id="buttonStartTest" onclick="showTest('formTest')" ><b>START</b></button>
            </div>
                <div id="formTest" hidden="true">
                    <div id="clock" style="text-align: center; margin-top: 20px;">15:00</div>
                    <hr>
                    <#list test as ex>
                        <b>ZADANIE ${ex?counter}</b> : ${ex.contents}
                        <br />
                        <label>ODPOWIEDŹ:</label>
                        <input id="exe_${ex.id}" type="text" name="answer" size="50" maxlength"30" />
                        <br />
                        <p style="font-size:10px">Odpowiedź zapisz w formacie Mxp^C (ex. 0.20x10^-3)</p>
                        <div id="user_result_${ex?index}" hidden="true">exe_${ex.id}</div>
                        <div id="ex_result_${ex?index}" hidden="true">${ex.result.answer}</div>
                        <hr>
                </#list>
                    <div style="text-align: center; margin-left -300px;">
                        <button id="buttonEndTest" onclick="endTest()"><b>KONIEC</b></button>
                    </div>
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