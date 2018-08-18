

function sayHiToLogger(){
let username=
    document.getElementById("exampleUserName").value;
    localStorage("username", username);
    const user = localStorage.getItem("username");

    let message = "welcome " +user;


    document.getElementById("welcome").innerHTML = message;

}
/*
function welcomeMessage() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (this.status == 200) {
                document.getElementById("welcome").innerHTML = xhr.responseText;
            } else {
                console.log("error");
            }
        }
    }
    xhr.open('GET', '/Reservation/controller/LogingServlet');
    xhr.send();
}*/
