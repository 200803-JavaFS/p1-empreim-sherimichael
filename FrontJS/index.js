const url = "http://localhost:8080/project1/"
const eTable = document.getElementsByTagName("table")[0];
const mTable = document.getElementsByTagName("table")[1];

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
        //console.log("URoleId: " + uRoleId);
        document.getElementById("login").setAttribute("hidden", true);
        etable.removeAttribute("hidden");
        
        let button = document.createElement('button');
        button.className = "btn btn-success";
        button.id = "logoutbtn";
        button.innerText = "Logout";
        button.onclick = logout;
        document.getElementsByTagName("h1")[0].appendChild(button);
            
        if (uRoleId == 1) {
            //view closed/resolved (approved & denied) requests
            let cBtn = document.createElement('button');
            cBtn.className = "btn btn-success";
            cBtn.id = "closedBtn";
            cBtn.innerText = "View Resolved Requests";
            cBtn.onclick = resolvedRs;
            cBtn.getElementsByTagName("h1")[0].appendChild(cBtn);

            //view pending requests
            let pBtn = document.createElement('button');
            pBtn.className = "btn btn-success";
            pBtn.id = "pendingBtn";
            pBtn.innerText = "View Pending Requests";
            pBtn.onclick = pendingRs;
            pBtn.getElementsByTagName("h1")[0].appendChild(pBtn);

            //submit new reimbursement
            let newBtn = document.createElement('button');
            newBtn.className = "btn btn-success";
            newBtn.id = "newReqBtn";
            newBtn.innerText = "VSubmit New Request";
            newBtn.onclick = addR;
            newBtn.getElementsByTagName("h1")[0].appendChild(newBtn);

        } else if (uRoleId == 2) {
           
           
            
            
        } else { console.log("Holy Cow, Batman!"); }
    } else {
        alert('Oops. Something went wrong. Please login again.')
        document.getElementById("login").reset();
    }    
}
