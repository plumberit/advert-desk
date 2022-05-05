pass = localStorage.getItem("password_technofix");
email = localStorage.getItem("email_technofix");

//main page logo button
let goMainPageButton = document.getElementById('flex-1-1-1-img');
goMainPageButton.onclick = goMainPage;

function goMainPage() {
    if (email === null || email === '') {
        document.getElementById('goMainPageTextEmail').value = "none";
    } else {
        document.getElementById('goMainPageTextEmail').value = email;
    }

    if (pass === null || pass === '') {
        document.getElementById('goMainPageTextPassword').value = "none";
    } else {
        document.getElementById('goMainPageTextPassword').value = pass;
    }
    document.getElementById("goMainPageForm").submit();
}