document.getElementById("submitButton").addEventListener("click", register);
document.getElementById("login").addEventListener("click", login);

function register(){

    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;

    let xhr = new XMLHttpRequest();

    xhr.open("POST", "http://localhost:8080/project1/users");

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let authToken = xhr.getResponseHeader("Authorization");
            sessionStorage.setItem("token", authToken);
            window.location.href="dashboard.html";
        
        } else if (ShadowRoot.readyState === 4){
            console.log('something went wrong');
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `username=${username}&password=${password}&firstName=${firstName}&lastName=${lastName}&email=${email}&ur=${null}`
    xhr.send(requestBody);
}

function login(){
    window.location.href="login.html";
}