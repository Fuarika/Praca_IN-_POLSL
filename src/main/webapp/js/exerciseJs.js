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
        document.getElementById("resultOK_"+fieldId).style.display = "inline";
        document.getElementById("button_"+fieldId).disabled = true;
        document.getElementById("buttonShow_"+resultId).hidden = false;
        document.getElementById("exe_"+fieldId).style.backgroundColor = "lightgreen";
        document.getElementById("exe_"+fieldId).style.color = "black";
        document.getElementById("exe_"+fieldId).disabled = true;

    }else{
        document.getElementById("resultBAD_"+fieldId).style.display = "inline";
        document.getElementById("button_"+fieldId).disabled = true;
        document.getElementById("buttonShow_"+resultId).hidden = false;
        document.getElementById("exe_"+fieldId).style.backgroundColor = "#ee5555";
        document.getElementById("exe_"+fieldId).style.color = "black";
        document.getElementById("exe_"+fieldId).disabled = true;
    }
}