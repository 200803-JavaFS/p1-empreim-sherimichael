const url = "http://localhost:8080/project1/"

// Method = GET
//document.getElementById("viewopen").addEventListener("click", viewPendingFunc);
//document.getElementById("viewclosed").addEventListener("click", viewPastFunc);

//Method = POST
document.getElementById("employeeportal").style.display = "none";
document.getElementById("newreqform").style.display = "none";
document.getElementById("loginbtn").addEventListener("click", loginFunc);

//document.getElementById("logoutbtn").addEventListener("click", loginFunc);

//Method = PUT
//document.getElementById("changestatus").addEventListener("click", loginFunc);

async function loginFunc() {
    console.log("@loginFunc");

    var usern = document.getElementById("username").value;
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
        document.getElementById("new-msg").innerText = "You have successfully logged in.";
        let data = await resp.text();
        console.log(resp);
        let uRoleId = data;
        sessionStorage.setItem("uRoleId", uRoleId);
        //let userId = data.userId;
        //sessionStorage.setItem("userId", userId);
        console.log(uRoleId);
        if (uRoleId == 1) {
            showEmployeePortal();
            //location.href = 'employeeportal.html'; //https://stackoverflow.com/questions/503093/how-do-i-redirect-to-another-webpage
            //console.log("@employeeportal.html");
    
        } else if (uRoleId == 2) {
            //location.href = 'financemanager.html'; 
            //console.log("@financemanager.html");
            
        } else { console.log("Holy Cow, Batman!"); }
    } else {
        resetLogin();
    }
}

function showEmployeePortal(){
    document.getElementById("login").style.display = "none";
    document.getElementById("employeeportal").style.display = "block";
    document.getElementById("empaxn").addEventListener("click", getEmpAxnFunc);
}

function getEmpAxnFunc(){
    const axns = document.querySelectorAll('input[name="empaxn"]');
    document.getElementById("employeeportal").style.display = "none";
    let axn;
    for (const ta of axns) {
        if (a.checked) {
            axn = a.value;
            break;
        }
    }
    console.log(axn);

    switch (axn) {
        case 1:
            document.getElementById("newreqform").style.display = "block";
            document.getElementById("submitnewrequest").addEventListener("click", addFunc);
            break;
        case 2:
            viewPendingFunc()
            break;
        case 3:
            //addFuxn();
            break;
        case 4:
            logoutFuxn();
            break;
    }
}

async function addFunc() {
    console.log("@addFunc");
    let email = document.getElementById("email").value;
    console.log(email);
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let author=uname;
    
    const types = document.querySelectorAll('input[name="type"]');
    //document.getElementById("employeeportal").style.display = "none";
    let typeId;
    for (const t of types) {
        if (t.checked) {
            typeId = t.value;
            break;
        }
    }
    console.log(typeId);
    
    let rReq = {
        amount: amount,
        description: description,
        typeId: typeId,
        statusId: 1,
        author: uname,       
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
        showRFunc();
    } else {
        console.log("Request was not successfully submitted.");
    }
}

async function showRFunc() {

    document.getElementById("rbody").innerText = "";

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
        document.getElementById("rbody").appendChild(row);
    }
}

async function viewPendingFunc() {
    let statusId = 1;
    let resp = await fetch(url + "reimbrsement" + "/" + statusId, {
        method: 'GET',
        body: JSON.stringify(body),
        credentials: 'include'
    })
}

async function logoutFunc() {
    let resp = await fetch(url + "logout", {
        method: "POST",
        credentials: "include"
    })
    if (resp.status === 200) {
        location.reload();
    } else {
        document.getElementById("new-msg").innerText = "Oops, something went wrong. Please try logging out again.";
    }
}
function resetLogin() {
    console.log("@resetLogin");
    document.getElementById("new-msg").innerText = "Oops, something went wrong. Please try logging in again.";
    //location.reload();
}