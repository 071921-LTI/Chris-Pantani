document.getElementById("submitButton").addEventListener("click", createReim);
document.getElementById("back").addEventListener("click", back);

let token = sessionStorage.getItem("token");
if(token === null){
    window.location.href="login.html";
}

function createReim(){

    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let type = document.getElementById("type").value;
    
    console.log(amount);
    console.log(description);
    console.log(type);


    let token = sessionStorage.getItem("token");

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/project1/reimbursements");
    xhr.setRequestHeader("Authorization", token)

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status==200){
            console.log("succes");
        } else {
            console.log("something went wrong");
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `amount=${amount}&description=${description}&type=${type}`;
    xhr.send(requestBody);
    //window.location.href = "dashboard.html";
}

function back(){
    window.location.href="EmployeePortal.html";
}