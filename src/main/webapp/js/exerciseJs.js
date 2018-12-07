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