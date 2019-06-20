function logOut() {
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function checkedIn() {
    let reqType = "GET";
    let url = "http://localhost:8080/StaffManager/api/CheckIn/getCheckedIn";
    makeRequest(reqType, url);
}
function resolved(result) {
    //create table tags and headings
    let node = document.createElement("tbody");
    node.setAttribute("id", "tbody");
    document.getElementById("results").appendChild(node);
    let tr = "<tr>";
    tr += "<td>|-- Log --|</td><td>|------- Time In -------|</td><td>|------- Staff ID -------|</td></tr>";
        for(i in result){
        tr += "<td>" + result[i].logID + "</td><td>" + result[i].timeIn + "</td><td>" + result[i].staffID + "</td></tr>";
    }
    tbody.innerHTML += tr;
}

function rejected(reason) {
    alert("An Error occured. Please check database.");
    console.log(reason);
}

checkedIn();