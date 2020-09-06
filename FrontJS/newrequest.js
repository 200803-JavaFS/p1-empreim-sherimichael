const url = "http://localhost:8080/project1/"

var typeId;
document.getElementById("submitnewrequest").addEventListener("click", addFunc);

async function addFunc() {
    console.log("@addFunc in newrequest.js");
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    
    const types = document.querySelectorAll('input[name="type"]');
    let type;
    for (const t of types) {
        if (t.checked) {
            type = t.value;
            break;
        }
    }
    switch (type) {
        case "lodging":
            typeId = 1;
            break;
        case "travel":
            typeId = 2;
            break; 
        case "food":
            typeId = 3;
            break;
        case "other":
            typeId = 4;
            break;   
    }
    console.log(type);
    console.log(typeId);
    let author = 0;
    let uRoleId = sessionStorage.getItem("uRoleId", uRoleId);
    console.log(uRoleId);


    let rReq = {
        amount: amount,
        description: description,
        author: author,
        statusId: 1,
        typeId: typeId
    }

    console.log(rReq)

    let resp = await fetch(url + "reimbursement", {
        method: 'POST',
        body: JSON.stringify(rReq),
        credentials: "include"
    })

    console.log(resp);

    if (resp.status === 201) {
        alert('Your request was successfully submitted');
        console.log("Request was successgully submitted.")
        //showRFunc()
    } else {
        console.log("Request was not successfully submitted.");
    }
}

async function showRFunc() {

    document.getElementById("").innerText = "";

    let resp = await fetch(url + "reimbursement", {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let data = await resp.json();

        for (let reimbursement of data) {
            console.log(reimbursement);

            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimbursement.reimbId;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.submitted;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.resolved;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursement.description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursement.author;
            row.appendChild(cell6);

            let cell7 = document.createElement("td");
            cell6.innerHTML = reimbursement.resolver;
            row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell6.innerHTML = reimbursement.status_id;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell6.innerHTML = reimbursement.type_id;
            row.appendChild(cell9);
        }
        document.getElementById("avbody").appendChild(row);
    }
}





async function viewPendingFunc() {
    let resp = await fetch(url + "status", {
        method: 'POST',
        body: JSON.stringify(uId),
        credentials: 'include'
    })
}
