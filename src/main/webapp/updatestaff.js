function logOut() {
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function back() {
    document.location.href = 'checkIn.html';
}
function load() {
    document.getElementById("firstName").value = sessionStorage.getItem("firstName");
    document.getElementById("lastName").value = sessionStorage.getItem("lastName");
    document.getElementById("email").value = sessionStorage.getItem("email");
    document.getElementById("jobrole").value = sessionStorage.getItem("jobRole");
    document.getElementById("paytier").value = sessionStorage.getItem("payTier");

}
function update() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let jobrole = document.getElementById("jobrole").value;
    let paytier = document.getElementById("paytier").value;
    let obj = { firstName: firstName, lastName: lastName, email: email, jobRole: jobrole, payTier: paytier };
    let body = JSON.stringify(obj);
    let reqType = "PUT";
    let id = sessionStorage.getItem("staffID");
    let url = "http://35.204.152.88:8888/StaffManager/api/Staff/updateStaff/" + id + "/";
    makeRequest(reqType, url, body);
}
function resolved(result) {
    let textnode = document.createTextNode("Account Updated");
    let node = document.createElement("div");
    node.setAttribute("id", "successMessage");
    node.appendChild(textnode);
    document.getElementById("pageTitle").appendChild(node);
}

function rejected(reason) {
    alert("An Error occured. Can't Update account");
    console.log(reason);
}
load();
