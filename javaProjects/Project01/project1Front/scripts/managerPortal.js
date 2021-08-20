document.getElementById('requestad').addEventListener('click', requestad);
document.getElementById('logout').addEventListener('click', logout);
document.getElementById('deleteEmp').addEventListener('click', deleteEmp);


let token = sessionStorage.getItem('token');
if(!token){
    window.location.href="login.html";
}

function requestad(){
    window.location.href="requestHandle.html";
}

function deleteEmp(){
    window.localation.href = "empHandle.html";
}

function logout() {
    window.location.href="login.html";
}