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

// войти в админ акк button
let loginAdminButton = document.getElementById('flex-1-1-3-text');
loginAdminButton.onclick = loginAdmin;

function loginAdmin() {
    if (email === null || email === '') {
        document.getElementById('loginAdminTextEmail').value = "none";
    } else {
        document.getElementById('loginAdminTextEmail').value = email;
    }

    if (pass === null || pass === '') {
        document.getElementById('loginAdminTextPassword').value = "none";
    } else {
        document.getElementById('loginAdminTextPassword').value = pass;
    }
    document.getElementById("loginAdminForm").submit();
}

// make an order
let makeOrderButton = document.getElementById('flex-1-3-button');
let makeOrderButtonText = document.getElementById('flex-1-3-button-text');
makeOrderButton.onclick = makeOrder;
makeOrderButtonText.onclick = makeOrder;

function makeOrder() {
    if (email === null || email === '') {
        document.getElementById('makeOrderTextEmail').value = "none";
    } else {
        document.getElementById('makeOrderTextEmail').value = email;
    }

    if (pass === null || pass === '') {
        document.getElementById('makeOrderTextPassword').value = "none";
    } else {
        document.getElementById('makeOrderTextPassword').value = pass;
    }
    document.getElementById("makeOrderForm").submit();
}