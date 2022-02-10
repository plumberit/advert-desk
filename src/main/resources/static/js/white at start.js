email = localStorage.getItem("email_technofix");
pass = localStorage.getItem("password_technofix");

if (email === null || email === '') {
    document.getElementById('email').value = "none";
} else {
    document.getElementById('email').value = email;
}

if (pass === null || pass === '') {
    document.getElementById('password').value = "none";
} else {
    document.getElementById('password').value = pass;
}

document.getElementById("DeleteUserForm").submit();

