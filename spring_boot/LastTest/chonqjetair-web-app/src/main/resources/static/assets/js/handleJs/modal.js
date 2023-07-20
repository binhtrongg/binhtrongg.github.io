function hidePassword(inputId, toggleBtnId) {
    let passwordInput = document.getElementById(inputId);
    let toggleBtn = document.getElementById(toggleBtnId);


        if (passwordInput.type === 'password') {
            passwordInput.type = 'text';
            toggleBtn.src = '/assets/img/icon/hide.png';
        } else {
            passwordInput.type = 'password';
            toggleBtn.src = '/assets/img/icon/see.png';
        }
}

function convertTime(arr) {
    let year = arr[0];
    let month = arr[1] - 1;
    let day = arr[2];
    let hour = arr[3];
    let minute = arr[4];
    let second = arr[5];
    return new Date(year, month, day, hour, minute, second);
}

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

function sendingEmail(email) {
    $.ajax({
        url:"/api/v1/users/"+email+"/otp-sending",
        type:"POST",
        contentType: 'application/json',
        success: function (response) {
            console.log("ok")
        },
        error: function (xhr, status, error) {
        }
    })
}
function showOtpForm(email) {
    document.getElementById("email-reset-data").readOnly = true;
    let message = `A code has been sent to <span class='red-email'>${email}</span>`;
    let messageElement = document.getElementById("otpSection").querySelector("p");
    messageElement.innerHTML = message;
    $("#otpSection").slideDown(500);
}
function conectOtp() {
    let first = document.getElementById("first").value;
    let second = document.getElementById("second").value;
    let third = document.getElementById("third").value;
    let fourth = document.getElementById("fourth").value;
    let fifth = document.getElementById("fifth").value;
    let sixth = document.getElementById("sixth").value;
    return first + second + third + fourth + fifth + sixth
}