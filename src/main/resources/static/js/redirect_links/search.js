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

//look advert
let buttonNumber;
let buttons = document.getElementsByTagName("button");
for (let i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener("click", function() {
        buttonsControl(this, i);
    }, false);
}

function buttonsControl(button, i) {
    buttonNumber = button.id;
    if(button.id==='search_button') {

    } else {
        lookAdvert();
    }
}

function lookAdvert() {
    if (email === null || email === '') {
        document.getElementById('lookAdvertTextEmail').value = "none";
    } else {
        document.getElementById('lookAdvertTextEmail').value = email;
    }

    if (pass === null || pass === '') {
        document.getElementById('lookAdvertTextPassword').value = "none";
    } else {
        document.getElementById('lookAdvertTextPassword').value = pass;
    }

    document.getElementById('lookAdvertTextNumber').value = buttonNumber.toString();

    document.getElementById("lookAdvertForm").submit();
}