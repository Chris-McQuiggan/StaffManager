function logOut() {
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function create() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let jobrole = document.getElementById("jobrole").value;
    let paytier = document.getElementById("paytier").value;
    let obj = { firstName: firstName, lastName: lastName, email: email, jobRole: jobrole, payTier: paytier };
    let body = JSON.stringify(obj);
    let reqType = "POST";
    let url = "http://35.204.152.88:8888/StaffManager/api/Staff/addStaffMember/";
    makeRequest(reqType, url, body);
}
function resolved(result) {
    let node = document.createElement("div");
    let textnode = document.createTextNode("Welcome " + result.firstName + " " + result.lastName);
    node.appendChild(textnode);
    node.setAttribute("id", "successMessage");
    document.getElementById("pageTitle").appendChild(node);
}

function rejected(reason) {
    alert("An Error occured. Can't Create account");
    console.log(reason);
}

