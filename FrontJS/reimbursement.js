const url = "http://localhost:8080/project1/"

// Method = GET
//document.getElementById("viewopen").addEventListener("click", viewPendingFunc);
//document.getElementById("viewclosed").addEventListener("click", viewPastFunc);

//Method = POST
document.getElementById("loginbtn").addEventListener("click", loginFunc);
//document.getElementById("submitnewrequest").addEventListener("click", loginFunc);
//document.getElementById("logoutbtn").addEventListener("click", loginFunc);

//Method = PUT
//document.getElementById("changestatus").addEventListener("click", loginFunc);

async function loginFunc() {
    /*
    if (document.getElementById("username").value == "" || document.getElementById("password").value == "") {
        alert('Please fill in all details');
        resetLogin();
    } else {
        */
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

    console.log(resp);

    if (resp.status == 200) {
        document.getElementById("login-row").innerText = "You have successfully logged in.";
        let data = await resp.json();
        let uId = userId
        let uRole = data.userRole;
        console.log(uRole);
        if (uRole == "Employee") {
            console.log("employee page");
            window.location.href = 'employee.html'; //https://stackoverflow.com/questions/503093/how-do-i-redirect-to-another-webpage

        } else if (uRole == "Finance Manager") {
            console.log("finance manager page");
            window.location.href = 'financemanager.html'; //https://stackoverflow.com/questions/503093/how-do-i-redirect-to-another-webpage
        }
        console.log(resp);
    } else {
        location.reload().document.getElementById("new-msg").innerText = "Oops, something went wrong. Please login again.";
        /*
        function newMsg() {
            document.getElementById("new-msg").innerText = "Oops, something went wrong. Please try logging in again."
        }
        newMsg();
        */
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
            if (avenger.homeBase != null) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = avenger.homeBase.homeBase;
                row.appendChild(cell7);
            } else {
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }
            document.getElementById("avbody").appendChild(row);
        }
    }
}

function newReqFunc() {
    window.location.href = 'newrequest.html';
}

async function addNewReqFunc() {
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let typeId = document.getElementById("type").value;
    let author = uId;


    let rReq = {
        amount: amount,
        description: description,
        author: author,
        statusId: 1,
        typeId: typeId
    }

    console.log(rReq)

    let resp = await fetch(url + "newrequesr", {
        method: 'POST',
        body: JSON.stringify(rReq),
        credentials: "include"
    })

    if (resp.status === 201) {
        console.log("Request was successgully submitted.")
        showRFunc()
    } else {
        document.getElementById("login-row").innerText = "Request was not successfully submitted.";
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
    document.getElementById("login-row").innerText = "Oops, something went wrong. Please try logging in again.";
    //document.getElementById("loginbtn").reset();
}