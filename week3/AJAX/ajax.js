// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

function getData() {

    let userInput = document.getElementById('dataInput').value;

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = receiveData;

    xhr.open('GET', apiURL + userInput);

    xhr.send();

    function receiveData(){
        if(xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300){
            let response = xhr.responseText;
            response = JSON.parse(response);
            populateData(response);

            let list = document.getElementById("list");
            str = "";
            for(key in response.data) {
                str += `<li>${response.data[species].name}</li>`;
            }
            //list.innerHTML = str;
            console.log(str);
        }
        else {
            console.log("file not found")
        }
    }
  
}

function populateData(response) {
    console.log(response);

    
    // Display pokemon information in the section tag of my html document
}