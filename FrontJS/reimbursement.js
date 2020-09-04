const url = "http://localhost:8080/project1/"

// Method = GET
//document.getElementById("viewopen").addEventListener("click", viewPendingFunc);
//document.getElementById("viewclosed").addEventListener("click", viewPastFunc);

//Method = POST
document.getElementById("loginbtn").addEventListener("click", loginFunc);
//document.getElementById("newrequest").addEventListener("click", loginFunc);
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
        document.getElementById("login-row").innerText = "Oops, something went wrong. Please try logging in again.";
        location.reset;
    }
}
/*
} else {
    //resetLogin();
    document.getElementById("login-row").innerText = "Holy Cow Batman! Please try logging in again.";
    }
*/

//document.getElementById("submitnewrequest").addEventListener("click", newReqFunc);

function newReqFunc() {
    window.location.href = 'newrequest.html';
}

//document.getElementById("newreq-form").addEventListener("click", addReqFunc);

async function addReqFunc() {
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let type = document.getElementById("type").value;
    let author = uId;
    let statusId = 1;
    let resolver = null;

    let rReq = {
        amount: amount,
        resolved: null,
        description: description,
        author: author,
        resolver: null,
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
            //findAllFunc()
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