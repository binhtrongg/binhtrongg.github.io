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
$(document).ready(function () {
    $(".send-otp-btn").click(function (event) {
        event.preventDefault()
        let isValidCreatForm=$("#reset-password-form").valid()
        if (!isValidCreatForm){
            return
        }
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
                    sendingEmail(email)
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
$(".confirm-otp-btn").click(function (event) {
    event.preventDefault()
    let email = document.getElementById("email-reset-data").value;
    let first = document.getElementById("first").value;
    let second = document.getElementById("second").value;
    let third = document.getElementById("third").value;
    let fourth = document.getElementById("fourth").value;
    let fifth = document.getElementById("fifth").value;
    let sixth = document.getElementById("sixth").value;

    let otp = first + second + third + fourth + fifth + sixth;
    console.log(otp)
    console.log(email)
    let formData={
        otpCode:otp
    }
    $.ajax({
        url:"/api/v1/authentication/verify-otp",
        type:"POST",
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function (response) {
            console.log(response)
            if (!response||response.email!==email||response.otpCode!==otp){
                toastr.error("Mã Otp Không Chính Xác")
            }
            else if (convertTime(response.expiredTime) < new Date()){
                toastr.error("Otp Đã Hết Hạn")
            }
            else {
                $('#resetPasswordModal').modal('hide')
                $('#new-password-modal').modal('show');
            }
        },
        error: function (xhr, status, error) {
        }
    })
})
function convertTime(arr) {
    let year = arr[0];
    let month = arr[1] - 1;
    let day = arr[2];
    let hour = arr[3];
    let minute = arr[4];
    let second = arr[5];
    return  new Date(year, month, day, hour, minute, second);
}
$('.confirm-new-password-btn').click(function (event) {
    event.preventDefault()
    let email = document.getElementById("email-reset-data").value;
    let newPassword=$('#new-password-input').val()
    let isValidNewPasswordForm = $("#login-form").valid()
    if (!isValidNewPasswordForm) {
        return
    }

    let formData={
        email:email,
        newPassword:newPassword
    }
    console.log(formData)
    $.ajax({
        url:"/api/v1/users/reset-password",
        type:"PUT",
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function (response) {
            toastr.success("ok")
        },
        error: function (xhr, status, error) {
            toastr.error("not ok")
        }
    })
})