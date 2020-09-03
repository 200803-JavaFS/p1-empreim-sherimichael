const url = "http://localhost:8080/project1/"
const proxyurl = "https://cors-anywhere.herokuapp.com/"

document.getElementById("loginbtn").addEventListener("click", loginFunc);

async function loginFunc() {
    //alert("Submit button working");

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
        //goToStaff();

    } else {
        //resetLogin();
        document.getElementById("login-row").innerText = "Batman";
    }

    function resetLogin() {
        console.log("@resetLogin");
        document.getElementById("login-row").innerText = "Oops, something went wrong. Please try logging in again.";
        //document.getElementById("loginbtn").reset();
    }

    async function goToStaff() {
        console.log("@goToStaff in reimbursement.js");
        let resp = await fetch(url + "allOk", {
            method: 'GET',
            body: JSON.stringify(user),
            credentials: "include"
        })
    }
    console.log(resp.status);
    /*

    if (resp.status === 200) {
        let result = await resp.json();
        let userId = result.userId;
        sessionStorage.setItem("userId", userId);
        let uRole = result.userRoleId.roleId;

        if (uRole == 1) {
            console.log("employee page");

        } else if (uRole == 2) {
            console.log("finance manager page");

        }

    } else {
        document.getElementById("login-row").innerText = "Oops, something went wrong. Please try logging in again.";
    }
    */
}