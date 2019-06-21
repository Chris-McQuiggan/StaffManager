function logOut() {
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function deleteAcc(){
    let reqType = "DELETE";
    let id = sessionStorage.getItem("staffID");
    let url = "http://35.204.152.88:8888/StaffManager/api/Staff/deleteStaffMember/" + id + "/";
    makeRequest(reqType, url);
}
function resolved(result) {
    let textnode = document.createTextNode("Account Deleted");
    let node = document.createElement("div");
    node.setAttribute("id", "successMessage");
    node.appendChild(textnode);
    document.getElementById("pageTitle").appendChild(node);
}

function rejected(reason) {
    alert("An Error occured. Can't Delete account");
    console.log(reason);
}

deleteAcc();