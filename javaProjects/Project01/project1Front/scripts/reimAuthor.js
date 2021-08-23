document.getElementById("back").addEventListener("click", back);


let token = sessionStorage.getItem("token");

if(token === null){
    window.location.href="login.html";
}

//window.onload = function getReims();

getReims();
console.log("testing");

function ifManager(){
    if(token.split(":")[1] == 'Manager'){

    }
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

                if(res.resolved = null){
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

function back (){
    window.location.href = "EmployeePortal.html"
}


    
