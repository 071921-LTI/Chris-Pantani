document.getElementById('approve').addEventListener('click', approve);
document.getElementById('denied').addEventListener('click', denied);
document.getElementById('logout').addEventListener('click', logout);
document.getElementById('back').addEventListener('click', back);

let token = sessionStorage.getItem('token');
if(!token){
    window.location.href="login.html";
}


let rid = document.getElementById("rid").value;
console.log(rid);

let arStatus;

getReims();






function approve(){

    let token = sessionStorage.getItem('token');
    let rid = document.getElementById("rid").value;
    console.log(rid);

    let status = "Approved";
    let statusId = 2;
    console.log(status);

    let statusData = {
        statusId:  statusId,
        status:  status
    }

    let arStatus = {
        status: statusData,
        id : rid
    }

 
    
    console.log(arStatus)

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

    //xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //let requestBody = `rid=${rid}&status=${status}`;
    xhr.send(JSON.stringify(arStatus));

    //xhr.send(requestBody);
    //window.location.href = "dashboard.html";
}







function denied(){
    let token = sessionStorage.getItem('token');
    let rid = document.getElementById("rid").value;
    console.log(rid);

    let status = "Denied";
    let statusId = 3

    let statusData = {
        statusId:  statusId,
        status:  status
    }

    let deStatus = {
        status: statusData,
        id : rid
    }

    console.log(deStatus)

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

//    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(JSON.stringify(deStatus));
//    let requestBody = `rid=${rid}&status=${status}`;
//   xhr.send(requestBody);
//    window.location.href = "dashboard.html";
}


function getReims() {
    console.log("inside function");
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/project1/reimbursements";

    xhr.open("GET", url);
    xhr.setRequestHeader("Authorization", token);

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status >= 200 && xhr.status <=299){
            
            
            let res = xhr.responseText;
            res = JSON.parse(res);
            
            //createTable(res);
            

            let remTable = document.getElementById("remTable");

            console.log(res);

            for(i=0; i<res.length; i++){
                let tbrow = document.createElement('tr');
                //tbrow.onclick = selectReim;
                tbrow.setAttribute("id",res[i].Id);


                let id = document.createElement("td");
                let amount = document.createElement("td");
                let description = document.createElement("td");
                let submited = document.createElement("td");
                let resolved = document.createElement("td");
                let author = document.createElement("td");
                let resolver = document.createElement("td");
                let type = document.createElement("td");
                let status = document.createElement("td");

                id.innerHTML = res[i].id;
                amount.innerHTML = res[i].amount;
                description.innerHTML = res[i].description;
                author.innerHTML = res[i].author.firstName + " " + res[i].author.lastName;
                
                if(res[i].resolver === null){
                    resolver.innerHTML = "";
                } else{
                    resolver.innerHTML = res[i].resolver.firstName+ " " + res[i].resolver.lastName;
                }
                
                submited.innerHTML = res[i].submitted;

                if(res.resolved === null){
                    resolved.innerHTML = "";
                } else {
                    resolved.innerHTML = res[i].resolved;
                }
                

                type.innerHTML = res[i].type.type;
                status.innerHTML = res[i].status.status;

                tbrow.appendChild(id);
                tbrow.appendChild(amount);
                tbrow.appendChild(description);
                tbrow.appendChild(submited);
                tbrow.appendChild(resolved);
                tbrow.appendChild(author);
                tbrow.appendChild(resolver);
                tbrow.appendChild(type);
                tbrow.appendChild(status);
                remTable.appendChild(tbrow);
                
            }
        }else if (xhr.readyState === 4){
            console.log("something went wrong");
        }
        
    }
    xhr.send();
}


function logout() {
    window.location.href="login.html";
}

function back() {
    window.location.href="ManagerPortal.html";
}