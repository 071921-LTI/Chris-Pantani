document.getElementById('newRequest').addEventListener('click', newRequest);
document.getElementById('logout').addEventListener('click', logout);
document.getElementById('authorView').addEventListener('click', authorView);


let token = sessionStorage.getItem('token');
if(!token){
    window.location.href="login.html";
}

function newRequest(){
    window.location.href="reimCreate.html";
}

function authorView(){
    window.localation.href = "reimAuthor.html";
}

function logout() {
    window.location.href="login.html";
}