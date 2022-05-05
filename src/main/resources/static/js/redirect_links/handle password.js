if (document.getElementById("guide").innerText==="true") {

    let email = localStorage.getItem("email_technofix");
    let password = localStorage.getItem("password_technofix");

    document.getElementById('goMainPageTextEmail').value = email;
    document.getElementById('goMainPageTextPassword').value = password;

} else{

    localStorage.setItem("email_technofix", '');
    localStorage.setItem("password_technofix", '');

    document.getElementById('goMainPageTextEmail').value = "none";
    document.getElementById('goMainPageTextPassword').value = "none";
}
document.getElementById("goMainPageForm").submit();