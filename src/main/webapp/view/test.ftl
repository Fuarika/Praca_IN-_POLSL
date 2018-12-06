<html lang="pl">
<head>
    <meta charset="utf-8" />
    <title> ASC -Liczby zmiennoprzecinkowe</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link rel="stylesheet" href="../css/menu.css" type="text/css" />
    <script type="text/javascript"  src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

    <script type="text/javascript">

        function disabledStartButton(){
            document.getElementById("buttonStartTest").disabled = true;
        }

        function showTest(testId){
            if (confirm("Chesz podejsc do testu?")){
                document.getElementById(testId).hidden = false;
                disabledStartButton();
            }else {
                document.getElementById(testId).hidden = true;
                //uruchomienie zegarka
            }
        }

        function endTest(){
            var p = countCorretAswer();
            alert("Udało cię się zdobyć " + p + "/5 punktow!");
            document.getElementById("buttonEndTest").disabled = true;
        }

        function countCorretAswer(){
            var numCorrect = 0;

            for (var i=0; i<5; i++){
                var exResult = document.getElementById("ex_result_" + i).innerHTML;
                var userResult = document.getElementById("user_result_" + i).innerHTML;
                if(exResult.localeCompare(userResult) === 0){
                    numCorrect++;
                }
            }
            return numCorrect;
        }
    </script>
</head>
<body>

    <div id="container">
        <div class="logo">
            <b><h1>ARYTMETYKA SYSTEMÓW CYFROWYCH<br />
                LICZBY ZMIENNOPRZECINKOWE</h1></b>
        </div>
        <div id="imglogo" >
            <img src="../img/logo.png" alt="logopolsl" style="width: 160px; padding: 10px;" />
        </div>
        <div style="clear:both;"></div>
        <div id="content">
            <button id="buttonStartTest" onclick="showTest('formTest')">START TEST</button>
                <div id="formTest" hidden="true">
                    <div id="clock"></div>
                    <#list test as ex>
                    ZADANIE ${ex.id} : ${ex.contents}
                    <br />
                    <label>ODPOWIEDZ:</label>
                    <input id="exe_${ex.id}" type="text" name="answer" size="50" maxlength"30" />
                    <br />
                    <p >Odpowiedz zapisz w formacie Mxp^C (ex. 0.20x10^-3)</p>
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