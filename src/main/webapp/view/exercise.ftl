<#import "/spring.ftl" as spring/>
<html lang="pl">
<head>
    <meta charset="utf-8" />
    <title> ASC -Liczby zmiennoprzecinkowe</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link rel="stylesheet" href="../css/menu.css" type="text/css" />
    <script type="text/javascript"  src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
    <script type="text/javascript">
        function myFunction(myDIV) {
            var x = document.getElementById(myDIV);

            if (x.style.display === "block") {
                x.style.display = "none";
            } else {
                x.style.display = "block";
            }
        }


// fieldId = exercise.id exeResult = exercise.result.answer resultId = exercise.result.id
        function checkSolution(exeResult, userResult, fieldId, resultId) {
            if(exeResult.localeCompare(userResult) === 0) {
                document.getElementById("resultOK_"+fieldId).hidden = false;
                document.getElementById("resultBAD_"+fieldId).hidden = true;
                document.getElementById("button_"+fieldId).disabled = true;
                document.getElementById("buttonShow_"+resultId).hidden = false;

            }else{
                document.getElementById("resultOK_"+fieldId).hidden = true;
                document.getElementById("resultBAD_"+fieldId).hidden = false;
                document.getElementById("button_"+fieldId).disabled = true;
                document.getElementById("buttonShow_"+resultId).hidden = false;
            }
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
                <#list exercises as exercise>
                    ZADANIE ${exercise.id} : ${exercise.contents} </br>
                        <label>ODPOWIEDZ:</label>
                        <input id="exe_${exercise.id}" type="text" name="answer" size="50" maxlength"30" />
                        <div id="resultOK_${exercise.id}" hidden="true">OK</div>
                        <div id="resultBAD_${exercise.id}" hidden="true">Wracaj do teori ciole</div>
                        </br>
                        <p style="min-font-size:4px ">Odpowiedz zapisz w formacie Mxp^C (ex. 0.20x10^-3)</p>
                        </br>
                            ${exercise.result.answer}
                        <button id="button_${exercise.id}" onclick="checkSolution('${exercise.result.answer}',document.getElementById('exe_${exercise.id}').value, '${exercise.id}', '${exercise.result.id}' )">Sprawdź</button>
                        <button id= "buttonShow_${exercise.result.id}" type="submit" onclick="myFunction('answer_${exercise.result.id}')" hidden ="true">Pokarz rozwiązanie</button>
                        <div id="answer_${exercise.result.id}" style="display:none;">BAAK BAKA</div>

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
