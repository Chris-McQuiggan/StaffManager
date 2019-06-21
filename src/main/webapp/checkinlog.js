function logOut() {
    sessionStorage.clear();
    document.location.href = 'home.html';
}
function allCheckIns() {
    let reqType = "GET";
    let url = "http://35.204.152.88:8888/StaffManager/api/CheckIn/getAllCheckIns/";
    makeRequest(reqType, url);
}
function resolved(result) {
    //create table tags and headings
    if (result[0] !== null && result[0] !== undefined) {
        let node = document.createElement("tbody");
        node.setAttribute("id", "tbody");
        document.getElementById("results").appendChild(node);
        let tr = "<tr>";
        tr += "<td>|-- ID --|</td><td>|------- Time In -------|</td><td>|------- Time Out -------|</td><td>|--- hours ---|</td><td>|-- Staff ID --|</td><td>|---- Delete ----|</td></tr>";
        for (let i = 0; i < result.length; i++) {
            //output to table
            let btn = '<input class="btn btn-info btn-sm col-8" type="button" id=result' + i + " value='Delete' onclick = 'deleteButton(" + '"' + result[i].logID + '"' + ")' >";
            tr += "<td>" + result[i].logID + "   </td><td>" + result[i].timeIn + "   </td><td>" + result[i].timeOut + "   </td><td>" + result[i].hours + "   </td><td>" + result[i].staffID + "   </td><td>" + btn + "</td></tr>";
        }
        tbody.innerHTML += tr;
    }else{
        const el = document.getElementById('results');
        while (el.firstChild) {
            el.removeChild(el.firstChild);
        }
        allCheckIns();
    }
}

function rejected(reason) {
    alert("An Error occured. Please check database.");
    console.log(reason);
}

function deleteButton(id) {
    let reqType = "DELETE";
    let url = "http://35.204.152.88:8888/StaffManager/api/CheckIn/deleteCheckIn/"+id;
    makeRequest(reqType, url);
}

allCheckIns();