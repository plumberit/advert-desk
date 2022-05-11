let loginButton = document.getElementById("loginAdminButton");
loginButton.onclick = handlePassword;

function handlePassword() {
    let email = document.getElementById("loginAdminEmail_open").value;
    let password = document.getElementById("loginAdminPassword_open").value;
    let hash = CryptoJS.MD5(password).toString();
    localStorage.setItem("password_technofix", hash);
    document.getElementById("loginAdminEmail_hide").value = email;
    document.getElementById("loginAdminPassword_hide").value = hash;
}