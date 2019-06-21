function buttonGet() {
    let reqType = "GET";
    let search = document.getElementById("staffID").value;
    let url = "http://35.204.152.88:8888/StaffManager/api/Staff/getAStaffMember/" + search;
    makeRequest(reqType, url);
}

function resolved(result) {
    if (result.staffID !== null) {
        sessionStorage.setItem('staffID', result.staffID);
        sessionStorage.setItem('firstName', result.firstName);
        sessionStorage.setItem('lastName', result.lastName);
        sessionStorage.setItem('email', result.email);
        sessionStorage.setItem('jobRole', result.jobRole);
        sessionStorage.setItem('payTier', result.payTier);
        document.location.href = 'checkIn.html';
    }else{
        rejected("Staff Id Not Found")
    }
}

function rejected(reason) {
    alert("An Error occured. Staff member not found.");
    console.log(reason);
}

function newStaff(){
    document.location.href = 'newstaff.html';
}
function allStaff(){
    document.location.href = 'allstaff.html';
}
function allCheckIn(){
    document.location.href = 'checkinlog.html';
}
function checkedIn(){
    document.location.href = 'checkedinlist.html'
}

