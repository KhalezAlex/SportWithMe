let logCheck = 0;
let phoneCheck = 0;

function chooseLogin() {
    flushRegistrationInputs();
    $("#input_login").attr("placeholder", "login/phone");
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



function changeAbilitySubmitLoginButton() {
    if ($("#input_password").val() !== $("#input_password_repeat").val())
        $("#button_submit_form_login").attr("disabled", "disabled");
    else
    if (logCheck === 0 && phoneCheck === 0)
        $("#button_submit_form_login").removeAttr("disabled");
}

function getHash(string) {
    let input = "#input_" + string;
    let inputHash = "#input_" + string + "_pass_hash";
    if ($(input).val() !== "")
        $(inputHash).val(
            function(){
                return ($(input).val() + $("#input_password").val()).
                split("").reduce(function(a,b){a=((a<<5)-a)+b.charCodeAt(0);return a&a},0);
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

inputChangeFunctions();

$("#button_login").on("click", function () {
    $("#input_login_pass_hash").hide();
    $("#input_phone_pass_hash").hide();
    $("#div_modal_reg_log").show();
    chooseLogin();
})
$("#div_emblem").on("click", function() {
    flushRegistrationInputs();
    $("#div_modal_reg_log").hide();
})

function inputChangeFunctions() {
    onPasswordInput();
    onPasswordRepeatInput();
    onPhoneInput();
    onLoginInput();
}

function onPasswordInput() {
    $("#input_password").on("input", function() {
        getHash("login");
        getHash("phone");
        changeAbilitySubmitLoginButton();
    })
}

function onPasswordRepeatInput() {
    $("#input_password_repeat").on("input", function() {
        changeAbilitySubmitLoginButton();
    })
}

function onPhoneInput() {
    let phoneInput = $("#input_phone");

    phoneInput.on("input", function() {
        getHash("login");
        getHash("phone");
    })

    phoneInput.on("change", function () {
        console.log(phoneInput.val());
        $.ajax({
            url: "/checkPhoneForRegistration",
            type: "POST",
            dataType: "html",
            data: {
                phone: phoneInput.val()
            },
            success: function(data) {
                console.log(JSON.parse(data));
                if (JSON.parse(data)) {
                    phoneInput.css("border-color", "#DF5F5FFF");
                    phoneInput.css("border-width", "2px");
                    phoneCheck = 1;
                }
                else {
                    phoneInput.css("border-color", "#b2a0a0");
                    phoneInput.css("border-width", "1px");
                    phoneCheck = 0;
                }
            }
        })
    })
}

function onLoginInput() {
    let inputLogin = $("#input_login");
    inputLogin.on("input", function() {
        getHash("login");
        getHash("phone");
    })

    inputLogin.on("change", function () {
        $.ajax({
            url: "/checkLoginForRegistration",
            type: "POST",
            dataType: "html",
            data: {
                login: inputLogin.val()
            },
            success: function(data) {
                console.log(JSON.parse(data));
                if (JSON.parse(data)) {
                    inputLogin.css("border-color", "#DF5F5FFF");
                    inputLogin.css("border-width", "2px");
                    logCheck = 1;
                }

                else {
                    inputLogin.css("border-color", "#b2a0a0");
                    inputLogin.css("border-width", "1px");
                    logCheck = 0;
                }
            }
        })
    })
}