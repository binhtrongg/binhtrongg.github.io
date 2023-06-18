$(document).ready(function () {
    $.each(allBooking, function(index, booking) {
        let status = booking.status;
        console.log(status);
        if (status !== 'PendingApproval') {
            $('[booking-id="' + booking.id + '"]').prop('disabled', true).removeClass('text-success text-danger');
        }
    });
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
        const isValid = $("#bookingForm").valid;
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
                toastr.error('Lỗi khi cập nhật sản phẩm');
                console.error(error);
            }
        });
    });
    $(".update-status-btn").on("click", function(event) {
        const bookingId = $(this).attr("booking-id");
        let status = $(this).hasClass('text-success') ? 'Approved' : 'Rejected';
        let currentTime = new Date().toISOString();
        console.log(bookingId);

        let requestData = {
            id: bookingId,
            status: status,
            updateTime: currentTime
        };
        console.log(requestData);

        let message = status === 'Approved' ? 'Phê duyệt yêu cầu thành công' : 'Từ chối yêu cầu thành công';

        if (confirm('Bạn có chắc chắn muốn thực hiện hành động này không?')) {
            $.ajax({
                url: '/api/v1/bookings/'+bookingId,
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(requestData),
                success: function(response) {
                    toastr.success(message);
                    console.log(response)
                    let isApproved = response.status !== 'Approved';
                    console.log(isApproved)
                    sendEmail(response,isApproved)
                    setTimeout(() => {
                        location.reload();
                    }, 1000);
                },
                error: function(xhr, status, error) {
                    toastr.error('Lỗi khi phê duyệt yêu cầu');
                }
            });
        }
    });
    function sendEmail(email,isApproved) {
        let requestData = {
            isApproved: isApproved.toString()
        };
        $.ajax({
            url: '/api/v1/users/' + email + '/otp-sending',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(requestData),
            success: function (data) {
                console.log(requestData)
            },
            error: function (errorData) {
            }
        });
    }

    $("#buyProductBtn").click(function() {
        $("#sentMailModal").modal("show");
    });
});
