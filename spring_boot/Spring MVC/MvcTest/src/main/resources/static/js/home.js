$(document).ready(function () {
    $("#bookingForm").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "username": {
                required: true,
                maxlength: 255
            },
            "email": {
                required: true,
                email: true
            },
            "phoneNumber": {
                required: true,
                digits: true,
                minlength: 10,
                maxlength: 10
            },
            "appointmentDetails": {
                required: true,
                maxlength: 255
            }
        },
        messages: {
            "username": {
                required: "Hãy Nhập Tên Của bạn",
                maxlength: "Hãy nhập tối đa 255 ký tự"
            },
            "email": {
                required: "Hãy Nhập Email Của Bạn",
                email: "Email không hợp lệ"
            },
            "phoneNumber": {
                required: "Hãy Nhập Số Điện Thoại Của Bạn",
                digits: "Số điện thoại chỉ chứa kí tự số",
                minlength: "Số điện thoại phải có ít nhất 10 kí tự",
                maxlength: "Số điện thoại chỉ có thể có tối đa 10 kí tự"
            },
            "appointmentDetails": {
                required: "Hãy Nhập Nội Dung Đặt Khám",
                maxlength: "Không quá 255 kí tự"
            }
        }
    });
    $("#saveBooking").click(function (event) {
        event.preventDefault()
        const isValid = $("#bookingForm").valid();
        console.log(isValid)
        if (!isValid) {
            return;
        }

        const formData = $('#bookingForm').serializeArray();
        if (!formData || formData.length === 0) {
            return;
        }
        const requestData = {};
        for (let i = 0; i < formData.length; i++) {
            requestData[formData[i].name] = formData[i].value;
        }
        $.ajax({
            url: '/api/v1/bookings/',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function(response) {
                toastr.success('gửi yêu cầu thành công,chúng tôi sẽ liên hệ với bạn sớm nhất');
                setTimeout(() => {
                    location.reload();
                }, 1000);
                // Cập nhật thông tin sản phẩm trên giao diện hoặc thực hiện các thao tác khác
            },
            error: function(xhr, status, error) {
                toastr.error('Lỗi khi gửi yêu cầu');
                console.error(error);
            }
        });
    });

    $(".buyProductBtnok").click(function() {
        $("#sentMailModal").modal("show");
    });
    $("#sentMailForm").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "name": {
                required: true,
                maxlength: 255
            },
            "email": {
                required: true,
                email: true
            },
            "phoneNumber": {
                required: true,
                digits: true,
                minlength: 10,
                maxlength: 10
            },
        },
        messages: {
            "name": {
                required: "Hãy Nhập Tên Của bạn",
                maxlength: "Hãy nhập tối đa 255 ký tự"
            },
            "email": {
                required: "Hãy Nhập Email Của Bạn",
                email: "Email không hợp lệ"
            },
            "phoneNumber": {
                required: "Hãy Nhập Số Điện Thoại Của Bạn",
                digits: "Số điện thoại chỉ chứa kí tự số",
                minlength: "Số điện thoại phải có ít nhất 10 kí tự",
                maxlength: "Số điện thoại chỉ có thể có tối đa 10 kí tự"
            },
        }
    });
    $("#submitBuyProduct").click(function (event) {
        event.preventDefault()
        const isValid = $("#sentMailForm").valid();
        if (!isValid) {
            return;
        }
        let email = $("#email").val();
        $("#sentMailModal").modal("hide");
        console.log(email)
        $.ajax({
            url: '/api/v1/users/'+email+'/sent-notification',
            type: 'POST',
            contentType: 'application/json',
            success: function(response) {
                toastr.success('gửi yêu cầu thành công,vui lòng kiểm tra email');
            },
            error: function(xhr, status, error) {
                toastr.error('Lỗi khi gửi yêu cầu');
                console.error(error);
            }
        });
    });
})