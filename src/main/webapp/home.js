function buttonGet() {
    let reqType = "GET";
    let search = document.getElementById("staffID").value;
    let url = "http://localhost:8080/StaffManager/api/Staff/getAStaffMember/" + search;
    makeRequest(reqType, url);
}

function resolved(result) {
    if (result.staffID !== null) {
        sessionStorage.setItem('staffID', result.staffID);
        sessionStorage.setItem('firstName', result.firstName);
        sessionStorage.setItem('lastName', result.lastName);
        document.location.href = 'checkin.html';
    }else{
        rejected("Staff Id Not Found")
    }
}

function rejected(reason) {
    alert("An Error occured. Staff member not found.");
    console.log(reason);
}

