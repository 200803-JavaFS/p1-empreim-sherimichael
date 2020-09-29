const url = "http://localhost:8080/project1/"

//*****************  Login feature  ************************

document.getElementById("loginbtn").addEventListener("click", loginFunc);

async function loginFunc() {
    console.log("@loginFunc");

    let uname = document.getElementById("username").value;
    let pword = document.getElementById("password").value;

    let user = {
        username: uname,
        password: pword
    }

    //console.log(user);

    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: 'include'
    })

    //console.log("fetch api login response");
    //console.log(resp);

    if (resp.status == 200) {
        let data = await resp.json();
        console.log(resp);
        let uRoleId = data;
        sessionStorage.setItem("uRoleId", uRoleId);
        console.log("URoleId: " + uRoleId);
        if (uRoleId == 1) {
            //console.log("to employee portal");
            window.location.href ="employee.html";
    
        } else if (uRoleId == 2) {
            //console.log("to manager portal");
            window.location.href = "manager.html";
            
            
        } else { console.log("Holy Cow, Batman!"); }
    } else {
        alert('Oops. Something went wrong. Please login again.')
        resetLogin();
    }    

    function resetLogin() {
        console.log("@resetLogin");
        location.reload();
    }
}
