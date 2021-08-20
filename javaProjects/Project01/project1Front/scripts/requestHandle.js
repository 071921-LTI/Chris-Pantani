document.getElementById('approve').addEventListener('click', approve);
document.getElementById('denied').addEventListener('click', denied);
document.getElementById('logout').addEventListener('click', logout);

let rid = document.getElementById("rid").value;
console.log(rid);

let token = sessionStorage.getItem('token');
if(!token){
    window.location.href="login.html";
}



function approve(){

    let token = sessionStorage.getItem('token');
    let rid = document.getElementById("rid").value;
    console.log(rid);

    let status = "Approved";

    console.log(status);
    

    let xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/project1/reimbursements");
    xhr.setRequestHeader("Authorization", token);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status==200){
            console.log("succes");
        } else {
            console.log("something went wrong");
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `rid=${rid}&status=${status}`;
    xhr.send(requestBody);
    //window.location.href = "dashboard.html";
}

function denied(){
    let status = "Denied";

    let xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/project1/reimbursements");
    xhr.setRequestHeader("Authorization", token)

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status==200){
            console.log("succes");
        } else {
            console.log("something went wrong");
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `rid=${rid}&status=${status}`;
    xhr.send(requestBody);
    window.location.href = "dashboard.html";
}

function logout() {
    window.location.href="login.html";
}