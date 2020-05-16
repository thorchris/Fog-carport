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

function myFunction3() {
    var claddingCheckbox = document.getElementById("claddingCheckbox");
    var shedCheckbox = document.getElementById("shedCheckbox");
    var claddingDropdowns = document.getElementById("carportDropdowns");
    var numberOfCladdingSides = document.getElementById("numberOfCladdingSides");
    var numberOfCladdingSides1 = document.getElementById("numberOfCladdingSides1");

    if (shedCheckbox.checked && claddingCheckbox.checked === true) {
        claddingDropdowns.style.display = "block";
        numberOfCladdingSides1.style.display = "block";
    } else if (claddingCheckbox.checked === true) {
        claddingDropdowns.style.display = "block";
        numberOfCladdingSides.style.display = "block";
    } else {
        claddingDropdowns.style.display = "none";
        numberOfCladdingSides.style.display = "none";
        numberOfCladdingSides1.style.display = "none";
    }
}
