$(".login-btn").click(function () {
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
            localStorage.setItem("jwr",response.jwt)
            localStorage.setItem("refreshToken",response.refreshToken)
            let userInfor={
                id:response.id,
                username:response.username,
                roles:response.roles
            }
            localStorage.setItem("userInfor",JSON.stringify(userInfor))
            $('#myModal').modal('hide');
        },
        error: function (xhr, status, error) {
            toastr.error('Thông Tin Tài Khoản Hoặc Mật Khẩu Không Chính Xác!');
            console.error(error);
        }
    })
})
$(".signup-btn").click(function () {
    let email = $('#name-signup-data').val()
    let password = $('#registerPasswordInput').val()
    let formdata = {
        email: email,
        password: password
    }
    $.ajax({
        url: '/api/v1/authentication/signup',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formdata),
        success: function (response) {
            console.log('ok')
            toastr.success('Đăng Kí Thành Công!');
            console.log(response)
        },
        error: function (xhr, status, error) {
            toastr.error('Đăng Kí Thất Bại');
            console.error(error);
        }
    })
})