document.getElementById('togglePasswordBtn').addEventListener('click', function () {
    var passwordInput = document.getElementById('passwordInput');
    var toggleBtn = document.getElementById('togglePasswordBtn');

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        toggleBtn.src = '/assets/img/icon/hide.png';
    } else {
        passwordInput.type = 'password';
        toggleBtn.src = '/assets/img/icon/see.png';
    }
});
$(document).ready(function () {
    $(".send-otp-btn").click(function (event) {
        event.preventDefault()
        let emailExisted={}
        let email = document.getElementById("email-reset-data").value;
        let formdata = {
            email: email,
        }
        $.ajax({
            url:"/api/v1/users/email-check",
            type:"POST",
            contentType: 'application/json',
            data: JSON.stringify(formdata),
            success: function (response) {
                emailExisted=response
                if (emailExisted===true){
                    document.getElementById("email-reset-data").readOnly = true;
                    let message = `A code has been sent to <span class='red-email'>${email}</span>`;
                    let messageElement = document.getElementById("otpSection").querySelector("p");
                    messageElement.innerHTML = message;
                    $("#otpSection").slideDown(500);
                }
                else toastr.error("Email Không Tồn Tại Trong Hệ Thống")
            },
            error: function (xhr, status, error) {
            }
        })
    });
});
document.addEventListener("DOMContentLoaded", function (event) {

    function OTPInput() {
        const inputs = document.querySelectorAll('#otp > *[id]');
        for (let i = 0; i < inputs.length; i++) {
            inputs[i].addEventListener('keydown', function (event) {
                if (event.key === "Backspace") {
                    inputs[i].value = '';
                    if (i !== 0) inputs[i - 1].focus();
                } else {
                    if (i === inputs.length - 1 && inputs[i].value !== '') {
                        return true;
                    } else if (event.keyCode > 47 && event.keyCode < 58) {
                        inputs[i].value = event.key;
                        if (i !== inputs.length - 1) inputs[i + 1].focus();
                        event.preventDefault();
                    } else if (event.keyCode > 64 && event.keyCode < 91) {
                        inputs[i].value = String.fromCharCode(event.keyCode);
                        if (i !== inputs.length - 1) inputs[i + 1].focus();
                        event.preventDefault();
                    }
                }
            });
        }
    }

    OTPInput();
});