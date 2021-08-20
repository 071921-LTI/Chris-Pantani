document.getElementById("submitButton").addEventListener("click", login);

function login(){

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let xhr = new XMLHttpRequest();

    xhr.open("POST", "http://localhost:8080/project1/auth");

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let authToken = xhr.getResponseHeader("Authorization");

            sessionStorage.setItem("token", authToken);
            console.log(authToken);
            
            let tokArr = authToken.split(":");
            console.log(tokArr[1]);
            
             if(tokArr[1] === "Manager"){
                window.location.href = 'managerPortal.html';
            } else if(tokArr[1] === "Employee"){
                window.location.href = 'employeePortal.html';
            }


        } else if (ShadowRoot.readyState === 4){
            console.log('Something went wrong...');
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `username=${username}&password=${password}`;
    xhr.send(requestBody);
}