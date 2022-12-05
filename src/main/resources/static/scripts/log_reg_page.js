let logCheck = 0;

chooseLogin();
hideHashes();

function chooseLogin() {
    let inputLogin = $("#input_login");
    $("#input_password").off("input");
    inputLogin.off("change");
    flushRegistrationInputs();
    inputLogin.attr("placeholder", "login/phone");
    $("#par_Register").css("font-weight", "normal");
    $("#par_Login").css("font-weight", "bold");
    $("#input_password_repeat").hide();
    $("#input_phone").hide();
    $("#form_login").attr("action", "/login");
    let submit = $("#button_submit_form_login");
    submit.val("sign in");
    submit.removeAttr("disabled");

}

function chooseRegister() {
    inputChangeFunctions();
    flushRegistrationInputs();
    $("#input_login").attr("placeholder", "login");
    $("#par_Register").css("font-weight", "bold");
    $("#par_Login").css("font-weight", "normal");
    $("#input_password_repeat").show();
    $("#input_phone").show();
    $("#form_login").attr("action", "/register");
    let submit = $("#button_submit_form_login");
    submit.val("register");
    submit.attr('disabled', "disabled");
}

function hideHashes() {
    $("#input_login_pass_hash").hide();
    $("#input_phone_pass_hash").hide();
}

function changeAbilitySubmitLoginButton() {
    let inputPassword = $("#input_password");
    if (inputPassword.val() !== $("#input_password_repeat").val() || logCheck === 1 ||
        inputPassword.val() === "")
        $("#button_submit_form_login").attr("disabled", "disabled");
    else
        $("#button_submit_form_login").removeAttr("disabled");
}

function getHash(string) {
    let input = "#input_" + string;
    let inputHash = "#input_" + string + "_pass_hash";
    if ($(input).val() !== "")
        $(inputHash).val(
            function () {
                return ($(input).val() + $("#input_password").val()).split("").reduce(function (a, b) {
                    a = ((a << 5) - a) + b.charCodeAt(0);
                    return a & a
                }, 0);
            });
}

function flushRegistrationInputs() {
    $("#input_login").val("");
    $("#input_phone").val("");
    $("#input_password").val("");
    $("#input_password_repeat").val("");
    $("#input_login_pass_hash").val("");
    $("#input_phone_pass_hash").val("");
}

function inputChangeFunctions() {
    onPasswordInput();
    onPasswordRepeatInput();
    onLoginInput();
}

function onPasswordInput() {
    $("#input_password").on("input", function () {
        getHash("login");
        getHash("phone");
        changeAbilitySubmitLoginButton();
    })
}

function onPasswordRepeatInput() {
    $("#input_password_repeat").on("input", function () {
        changeAbilitySubmitLoginButton();
    })
}


function onLoginInput() {
    let inputLogin = $("#input_login");

    inputLogin.on("change", function () {
        $.ajax({
            url: "/checkLoginForRegistration",
            type: "POST",
            dataType: "html",
            data: {
                login: inputLogin.val()
            },
            success: function (data) {
                console.log(JSON.parse(data));
                if (JSON.parse(data)) {
                    inputLogin.css("border-color", "#DF5F5FFF");
                    inputLogin.css("border-width", "2px");
                    logCheck = 1;
                    changeAbilitySubmitLoginButton();
                } else {
                    inputLogin.css("border-color", "#b2a0a0");
                    inputLogin.css("border-width", "1px");
                    logCheck = 0;
                    changeAbilitySubmitLoginButton();
                }
            }
        })
    })
}