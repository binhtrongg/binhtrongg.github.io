$(document).ready(function () {
    const jwt = localStorage.getItem('jwt');
    if (jwt) {
        const loginBtn = document.getElementById('home-login-btn');
        let html = `<a class="dropdown-item" id="profile-link" th:href="@{/my-profile}"> <img style="width: 40px;height: 40px" src="/assets/img/banner/defautAvatar.png"> </a>`
        loginBtn.innerHTML = html
        const profileLink = document.getElementById('profile-link');
        profileLink.addEventListener('click', function (event) {
            event.preventDefault();
            window.location.href = '/my-profile';
        })
    }
})
$(".login-btn").click(function () {
    let isValidCreatForm = $("#login-form").valid()
    if (!isValidCreatForm) {
        return
    }
    let email = $('#email-login-data').val()
    let password = $('#passwordInput').val()
    let formdata = {
        email: email,
        password: password
    }
    $.ajax({
        url: '/api/v1/authentication/login',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formdata),
        success: function (response) {
            toastr.success('Đăng Nhập Thành Công!');
            localStorage.setItem("jwt", response.jwt)
            localStorage.setItem("refreshToken", response.refreshToken)
            let userInfor = {
                id: response.id,
                username: response.username,
                roles: response.roles
            }
            localStorage.setItem("userInfor", JSON.stringify(userInfor))
            $('#myModal').modal('hide');
            setTimeout(function () {
                location.reload();
            }, 1000);

        },
        error: function (xhr, status, error) {
            console.log(xhr)
            console.log(xhr);
            if (xhr.status === 401) {
                toastr.error('Thông Tin Tài Khoản Hoặc Mật Khẩu Không Chính Xác');
            } else if (xhr.status === 403){
                $("#myModal").modal("hide")
                $("#activation-modal").modal("show")
            }
        }
    })
})
$(".signup-btn").click(function () {
    let isValidCreatForm = $("#signup-form").valid()
    if (!isValidCreatForm) {
        return
    }
    let email = $('#email-signup-data').val()
    let password = $('#registerPasswordInput').val()
    let creatAccountData = {
        email: email,
        password: password
    }
    $.ajax({
        url: '/api/v1/authentication/signup',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(creatAccountData),
        success: function (response) {
            toastr.success('Đăng Kí Thành Công!,Vui Lòng Kiểm Tra Email Để Nhận Hướng Dẫn Kích Hoạt Tài Khoản');
            $('#registerModal').modal("hide")
        },
        error: function (xhr, status, error) {
            toastr.error(xhr.responseText)
        }
    })
})
$('#logout-btn').click(function () {
    let jwt = localStorage.getItem("jwt")
    if (jwt) {
        $.ajax({
            url: '/api/v1/authentication/logout',
            type: 'POST',
            contentType: 'application/json',
            headers: {
                'Authorization': 'Bearer' + " " + jwt
            },
            success: function (response) {
                localStorage.clear();
            },
            error: function (xhr, status, error) {
                toastr.error('Đăng Xuất Thành Công');
                console.error(error);
                window.location.href = 'http://localhost:8080/';
            }
        })
    } else {
        window.location.href = 'http://localhost:8080/';
    }
})

$(".resend-activation-btn").click(function (event) {
    event.preventDefault()
    let email = $('#email-login-data').val()
    let formData={
        email:email
    }
    $.ajax({
        url: '/api/v1/users/resend-activation-email/',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function (response) {
            toastr.success('Đã Gửi Lại Email Kích Hoạt!');
            $("#activation-modal").modal("hide")
        },
        error: function (xhr, status, error) {
            toastr.error("Gửi Email Thất Bại")
        }
    });
});

function refreshToken() {
    let jwt = localStorage.getItem("jwt")
    let refreshToken = localStorage.getItem("refreshToken")
    let formData = {
        refreshToken: refreshToken
    }
    if (!jwt) {
        return
    }
    $.ajax({
        url: '/api/v1/authentication/refresh-token',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        headers: {
            'Authorization': 'Bearer' + " " + jwt
        },
        success: function (response) {
            localStorage.setItem("jwt", response.jwt)
        },
        error: function (xhr, status, error) {
            console.log(error)
        }
    });
}

setInterval(refreshToken, 29*60 * 1000);
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
            toastr.success("Cập Nhật Mật Khẩu Mới Thành Công")
        },
        error: function (xhr, status, error) {
            toastr.error("Cập Nhật THất Bại")
        }
    })
})


