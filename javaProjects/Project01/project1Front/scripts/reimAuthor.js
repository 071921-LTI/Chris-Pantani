let token = sessionStorage.getItem("token");
if(token === null){
    window.location.href="login.html";
}



function ifManager(){
    if(token.split(":")[1] == 'Manager'){

    }
}

/*
function getReims() {
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/project1/reimbursements";

    xhr.open("GET", url);
    xhr.setRequestHeader("Authorization", token);

    let res = xhr.responseText;
    res = JSON.parse(res);
            
    createTable(res);

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status >= 200 && xhr.status <=299){
            
            
            let res = xhr.responseText;
            res = JSON.parse(res);
            
            createTable(res);
            

            let remTable = document.getElementById("remTable");
            for(i=0; i<res.length; i++){
                let tbrow = document.createElement('tr');
                tbrow.onclick = selectReim;
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
                resolver.innerHTML = res[i].resolver.firstName+ " " + res[i].resolver.lastName;
                submited.innerHTML = res[i].submitted;
                resolved.innerHTML = res[i].resolved;
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
        }else if (ShadowRoot.readyState === 4){
            console.log("something went wrong");
        }
        xhr.send();
    }
*/

    function getReim(){
        
        let xhr = new XMLHttpRequest();
        let url = "http://localhost:8080/project1/reimbursements";
        xhr.open("GET", url);
        xhr.setRequestHeader("Authorization", token);
        let res = xhr.responseText;
        res = JSON.parse(res);

        function createTable(res){
                        
            var col =[];
            for (var i =0; i<res.length; i++){
                for(var key in res[i]){
                    if(col.indexOf(key) === -1){
                        col.push(key);
                    }
                }
            }

            var table = documnet.createElement("table");
            var tr = table.insertRow(-1);
            
            for (var i =0; i<col.length; i++){
                var th = document.createElement("th");
                th.innerHtml=col[i];
                tr.appendChild(th);
            }

            for(var i =0; i<res.length; i++){
                tr= table.insertRow(-1);
                for(var j =0; j <col.length; j++){
                    var tableCell = tr.insertCell(-1);
                    tableCell.innerHtml = res[i][col[j]];
                }
            }
            var divContainer = document.getElementById("showData")
            divContainer.innerHtml="";
            divContainer.appendChild(table);

        }
        xhr.send;
}


