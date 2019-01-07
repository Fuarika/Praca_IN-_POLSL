function disabledStartButton(){
    document.getElementById("buttonStartTest").disabled = true;
}

function showTest(testId){
    if (confirm("Chesz podejsc do testu?")){
        document.getElementById(testId).hidden = false;
        disabledStartButton();
        startCount();
    }else {
        document.getElementById(testId).hidden = true;

    }
}

function endTest(){
    var p = countCorrectAnswer();
    alert("Udało cię się zdobyć " + p + "/5 punktow!");
    document.getElementById("buttonEndTest").disabled = true;
}

function countCorrectAnswer(){
    var numCorrect = 0;

    for (var i=0; i<5; i++){
        var exResult = document.getElementById("ex_result_" + i).innerHTML;
        var userResultField = document.getElementById("user_result_" + i).innerHTML;
        var userR = document.getElementById(userResultField).value;

        if(exResult.localeCompare(userR) == 0){

            numCorrect++;
            document.getElementById(userResultField).style.backgroundColor = "lightgreen";

        }else {
            document.getElementById(userResultField).style.backgroundColor = "#ee5555";
        }
        document.getElementById(userResultField).style.color = "black";
        document.getElementById(userResultField).disabled = true;
    }
    return numCorrect;
}

function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    var clock = setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            alert("Czas minął!!");
            endTest();
        }
        if (document.getElementById("buttonEndTest").disabled === true){
            clearInterval(clock);
        }

    }, 1000);
}

function startCount() {
  var fiveMinutes = 60 * 15,
    display = document.querySelector('#clock');
   startTimer(fiveMinutes, display);
}


