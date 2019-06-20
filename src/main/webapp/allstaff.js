function logOut() {
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function allStaff() {
    let reqType = "GET";
    let url = "http://localhost:8080/StaffManager/api/Staff/getAllStaff/";
    makeRequest(reqType, url);
}
function resolved(result) {
    //create table tags and headings
    let node = document.createElement("tbody");
    node.setAttribute("id", "tbody");
    document.getElementById("results").appendChild(node);
    let tr = "<tr>";
    tr += "<td>|-- ID --|</td><td>|------- First Name -------|</td><td>|------- Last Name -------|</td><td>|----------------- Email -----------------|</td><td>|----- Job Role -----|</td><td>|-- Pay Tier --|</td></tr>";
    for (let i = 0; i < result.length; i++) {
        //output to table
        // let btn = '<input class="btn btn-info btn-sm col-8" type="button" id=result' + i + " value='More Details' onclick = 'moreButton(" + '"' + result[i].staffID + '"' + ")' >";
        tr += "<td>" + result[i].staffID + "   </td><td>" + result[i].firstName + "   </td><td>" + result[i].lastName + "   </td><td>" + result[i].email + "   </td><td>" + result[i].jobRole + "   </td><td>" + result[i].payTier + "   </td></tr>";
    }
    tbody.innerHTML += tr;
}

function rejected(reason) {
    alert("An Error occured. Please check database.");
    console.log(reason);
}

allStaff();