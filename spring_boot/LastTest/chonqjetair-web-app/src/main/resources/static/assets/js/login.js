$(document).ready(function () {
    const jwt = localStorage.getItem('jwt');
    if (jwt) {
        const loginBtn = document.getElementById('home-login-btn');
        let html = `<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="userDropdown" data-bs-toggle="dropdown"
    aria-expanded="false">
    User Name
  </button>
  <ul id="dropdownMenu" class="dropdown-menu" aria-labelledby="userDropdown">
    <li><a class="dropdown-item" id="profile-link" th:href="@{/my-profile}">Thông tin cá nhân</a></li>
    <li><a class="dropdown-item" href="#">Cài đặt</a></li>
    <li><hr class="dropdown-divider"></li>
    <li><a class="dropdown-item" href="#">Đăng xuất</a></li>
  </ul>
</div>`
        loginBtn.innerHTML = html
        const profileLink = document.getElementById('profile-link');
        profileLink.addEventListener('click', function (event) {
            event.preventDefault();
            window.location.href = '/my-profile';
        })
    }
})
$(".login-btn").click(function () {
    let isValidCreatForm=$("#login-form").valid()
    if (!isValidCreatForm){
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
        },
        error: function (xhr, status, error) {
            toastr.error('Thông Tin Tài Khoản Hoặc Mật Khẩu Không Chính Xác!');
            console.error(error);
        }
    })
})
$(".signup-btn").click(function () {
    let isValidCreatForm=$("#signup-form").valid()
    if (!isValidCreatForm){
        return
    }
    let email = $('#email-signup-data').val()
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
$('#logout-btn').click(function () {
    $.ajax({
        url: '/api/v1/authentication/logout',
        type: 'POST',
        contentType: 'application/json',
        success: function (response) {
            localStorage.clear();
            console.log('ok')
        },
        error: function (xhr, status, error) {
            toastr.error('Đăng Kí Thất Bại');
            console.error(error);
        }
    })
})