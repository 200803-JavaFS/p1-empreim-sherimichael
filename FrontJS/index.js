const url = "http://localhost:8080/project1/"

// Method = GET
//document.getElementById("viewopen").addEventListener("click", viewPendingFunc);
//document.getElementById("viewclosed").addEventListener("click", viewPastFunc);

//Method = POST
document.getElementById("loginbtn").addEventListener("click", loginFunc);

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
            location.href = 'employeeportal.html'; //https://stackoverflow.com/questions/503093/how-do-i-redirect-to-another-webpage
            console.log("@employeeportal.html");
    
        } else if (uRoleId == 2) {
            location.href = 'financemanager.html'; 
            console.log("@financemanager.html");
            
        } else { console.log("Holy Cow, Batman!"); }
    } else {
        resetLogin();
    }
}

function resetLogin() {
    console.log("@resetLogin");
    document.getElementById("new-msg").innerText = "Oops, something went wrong. Please try logging in again.";
    //location.reload();
}