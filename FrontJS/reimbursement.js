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
        let data = await resp.json();
        let uRId = data.userRoleId;
        if (uRId == 1) {
            console.log("employee page");
            //window.location.href = 'employee.html'; https://stackoverflow.com/questions/503093/how-do-i-redirect-to-another-webpage

        } else if (uRole == 2) {
            console.log("finance manager page");
            //window.location.href = 'financemanager.html'; https://stackoverflow.com/questions/503093/how-do-i-redirect-to-another-webpage
        }

    } else {
        document.getElementById("login-row").innerText = "Oops, something went wrong. Please try logging in again.";
    }
    /*
    } else {
        //resetLogin();
        document.getElementById("login-row").innerText = "Holy Cow Batman! Please try logging in again.";
    }
    */

    function resetLogin() {
        console.log("@resetLogin");
        document.getElementById("login-row").innerText = "Oops, something went wrong. Please try logging in again.";
        //document.getElementById("loginbtn").reset();
    }
}