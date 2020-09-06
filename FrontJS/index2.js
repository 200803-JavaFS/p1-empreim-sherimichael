const url = "http://localhost:8080/project1/"

document.getElementById("employeeportal").hidden = true; 
document.getElementById("newrequest").hidden = true;
    
document.getElementById("loginbtn").addEventListener("click", loginFunc);
// Method = GET
//document.getElementById("viewopen").addEventListener("click", viewPendingFunc);
//document.getElementById("viewclosed").addEventListener("click", viewPastFunc);

//Method = POST
//document.getElementById("loginbtn").addEventListener("click", loginFunc);
//document.getElementById("logoutbtn").addEventListener("click", loginFunc);

//Method = PUT
//document.getElementById("changestatus").addEventListener("click", loginFunc);

async function loginFunc() {
    console.log("@loginFunc");
    
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username: usern,
        password: userp
    }

    //console.log(user);

    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: 'include'
    })

    console.log("feth api login response");
    console.log(resp);

    if (resp.status == 200) {
        document.getElementById("login-row").innerText = "You have successfully logged in.";
        let data = await resp.text();
        console.log(resp);
        let uRoleId = data;
        sessionStorage.setItem("uRoleId", uRoleId);
        console.log(uRoleId);
        if (uRoleId == 1) {
            location.href='employeeportal.html';
    
        } else if (uRoleId == 2) {
            location.href = 'financemanager.html'; 
            console.log("@financemanager.html");
            
        } else { console.log("Holy Cow, Batman!"); }
    } else {
        resetLogin();
    }
}
function showEmployeePortalFunc(){
    console.log("@showEmployeePortalFunc");
    document.getElementById("login").hidden = true;
    document.getElementById("employeeportal").hidden = false;
    document.getElementById("newreques").hidden = true;  
}

function switchFunc(){

    //let axn= document.getElementById("raction").value;
    //console.log(axn);
    
    switch (document.getElementById("raction").value){
        case "10":
            console.log("submit new request");
            //document.getElementById("employeeportal").hidden = true;
            //document.getElementById("newrequest").hidden = false; 
            break;
        case "11":
            console.log("view pending requests");
            break;
        case "12":
            console.log("view past requests");
            break;
        case "13":
            console.log("logout");
            break;
    }
}

async function addFunc() {
    console.log("@addFunc in employee.js");
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let tId = document.getElementById("type").value; //https://stackoverflow.com/questions/1085801/get-selected-value-in-dropdown-list-using-javascript
    var typeId = tId.options[tId.selectedIndex].value;
    let author = uId;// this will be a problem - need to pull id from server


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

    if (resp.status === 201) {
        alert('Your request was successfully submitted');
        console.log("Request was successgully submitted.")
        //showRFunc()
    } else {
        document.getElementById("new-msg").innerText = "Request was not successfully submitted.";
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

function resetLogin() {
    console.log("@resetLogin");
    document.getElementById("new-msg").innerText = "Oops, something went wrong. Please try logging in again.";
    //location.reload();
}