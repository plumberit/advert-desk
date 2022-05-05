pass = localStorage.getItem("password_technofix");
email = localStorage.getItem("email_technofix");


//main page logo button
let goMainPageButton = document.getElementById('flex-1-1-4-img');
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


// get list
let getListButton = document.getElementById('flex-1-1-2-img');
getListButton.onclick = getList;

function getList() {
    if (email === null || email === '') {
        document.getElementById('getListTextEmail').value = "none";
    } else {
        document.getElementById('getListTextEmail').value = email;
    }

    if (pass === null || pass === '') {
        document.getElementById('getListTextPassword').value = "none";
    } else {
        document.getElementById('getListTextPassword').value = pass;
    }
    document.getElementById("getListForm").submit();
}

//logout
let logoutButton = document.getElementById('flex-1-1-3-img');
logoutButton.onclick = logout;

function logout() {
    localStorage.setItem("email_technofix", '');
    localStorage.setItem("password_technofix", '');

    document.getElementById('logoutTextEmail').value = "none";
    document.getElementById('logoutTextPassword').value = "none";

    document.getElementById("logoutForm").submit();
}