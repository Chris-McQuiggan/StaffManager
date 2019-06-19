function welcome() {
    let textnode = document.createTextNode(sessionStorage.getItem("firstName") + " " + sessionStorage.getItem("lastName"));
    let node = document.createElement("div");
    node.setAttribute("id", "name");
    node.appendChild(textnode);
    document.getElementById("pageTitle").appendChild(node);
}
function logGet() {
    let reqType = "GET";
    let url = "http://localhost:8080/StaffManager/api/CheckIn/getcheckedIn/";
    makeRequest(reqType, url);
}

function resolved(result) {
    console.log(result);
    let check;
    for (i in result) {
        if (result[i].staffID == sessionStorage.getItem("staffID")) {
            check = result[i];
        }
    }
    console.log(check)
    if (check !== null && check !== undefined) {
        sessionStorage.setItem("logID", check.logID);
        showCheckOut();
    } else {
        showCheckIn();
    }
}

function rejected(reason) {
    alert("An Error occured. Staff member not found.");
    console.log(reason);
}

function showCheckIn() {
    let node = document.createElement("input");
    node.setAttribute("id", "buttonin");
    node.setAttribute("class", "btn btn-info btn-lg col-12");
    node.setAttribute("type", "button");
    node.setAttribute("value", "Check in");
    node.setAttribute("onclick", "buttonCheckIn()");
    document.getElementById("checkIn-Out").appendChild(node);
}
function showCheckOut() {
    let node = document.createElement("input");
    node.setAttribute("id", "buttonout");
    node.setAttribute("class", "btn btn-info btn-lg col-12");
    node.setAttribute("type", "button");
    node.setAttribute("value", "Check out");
    node.setAttribute("onclick", "buttonCheckOut()");
    document.getElementById("checkIn-Out").appendChild(node);
}

function buttonCheckOut() {
 document.location.href = 'checkOut.html';
}
function buttonCheckIn() {
    document.location.href = 'checkedin.html';
}

welcome();
logGet();
