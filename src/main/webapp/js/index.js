function getGreeting() {
    var now = new Date();
    var hours = now.getHours();
    console.log("Hours = " + hours);
    var msg;
    if (hours < 12) msg = "Good Morning";
    else if (hours < 18) msg = "Good Afternoon";
    else msg = "Good Evening";
    console.log("Greeting = " + msg);
    return msg;
}

$(document).ready(function () {
    document.getElementById("greeting").innerHTML = getGreeting();
});