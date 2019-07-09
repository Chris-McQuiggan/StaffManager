function checkIn(){
    let obj = { timeIn: time(), staffID: sessionStorage.getItem("staffID") }
    let body = JSON.stringify(obj);
    let reqType = "POST";
    let url = "/StaffManager/api/CheckIn/newCheckIn/";
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
    textnode = document.createTextNode("Time In: " + result.timeIn);
    node.appendChild(textnode);
    document.getElementById("pageTitle").appendChild(node);
}

function rejected(reason) {
    alert("An Error occured. Can't Sign In");
    console.log(reason);
}

function logOut(){
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function time() {
    let today = new Date();
    let date = today.getFullYear() + '/' + (today.getMonth() + 1) + '/' + today.getDate();
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    let dateTime = date + ' ' + time;
    sessionStorage.setItem("timeIn", dateTime);
    return dateTime;
}
checkIn();
