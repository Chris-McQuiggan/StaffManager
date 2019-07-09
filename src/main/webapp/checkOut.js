function logOut() {
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function checkOut() {
    let obj = {timeOut: time(), hours: hours()};
    let body = JSON.stringify(obj);
    let reqType = "PUT";
    let id = sessionStorage.getItem("logID");
    let url = "/StaffManager/api/CheckIn/checkOut/" + id;
    makeRequest(reqType, url, body);
}
function resolved(result) {
    let textnode = document.createTextNode("Success");
    let node = document.createElement("div");
    node.setAttribute("id", "successMessage");
    node.appendChild(textnode);
    document.getElementById("pageTitle").appendChild(node);
    node = document.createElement("div");
    node.setAttribute("id", "timeStamp");
    textnode = document.createTextNode("Time Out: " + result.timeOut);
    node.appendChild(textnode);
    document.getElementById("pageTitle").appendChild(node);
}

function rejected(reason) {
    alert("An Error occured. Can't Sign Out");
    console.log(reason);
}
function hours() {
    let timeIn = new Date(sessionStorage.getItem("timeIn"));
    let timeOut = new Date(sessionStorage.getItem("timeOut"));
    let difference = timeOut-timeIn;
    let hours = parseFloat((difference/(1000*60*60)).toFixed(0));
    return hours;
}
function time() {
    let today = new Date();
    let date = today.getFullYear() + '/' + (today.getMonth() + 1) + '/' + today.getDate();
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    let dateTime = date + ' ' + time;
    sessionStorage.setItem("timeOut", dateTime);
    return dateTime;
}
function CheckedIn(){
    
}

checkOut();
