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
        }
    }
    return numCorrect;
}