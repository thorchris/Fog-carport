function myFunction1() {
    var shedCheckbox = document.getElementById("shedCheckbox");
    var shedDropdowns = document.getElementById("shedDropdowns");
    if (shedCheckbox.checked == true) {
        shedDropdowns.style.display = "block";
    } else {
        shedDropdowns.style.display = "none";
    }

}

function myFunction2(){
    var roofCheckbox = document.getElementById("roofCheckbox");
    var roofDropdowns = document.getElementById("roofDropdowns");
    if (roofCheckbox.checked == true) {
        roofDropdowns.style.display = "block";
    } else {
        roofDropdowns.style.display = "none";
    }
}

function myFunction3(){
    var claddingCheckbox = document.getElementById("claddingCheckbox");
    var claddingDropdowns = document.getElementById("carportDropdowns");
    if (claddingCheckbox.checked == true) {
        claddingDropdowns.style.display = "block";
    } else {
        claddingDropdowns.style.display = "none";
    }
}