$(document).ready(function () {
    $.each(allBooking, function(index, booking) {
        let status = booking.status;
        console.log(status);
        if (status !== 'PendingApproval') {
            $('[booking-id="' + booking.id + '"]').prop('disabled', true).removeClass('text-success text-danger');
        }
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
        console.log("ok")
        $("#sentMailModal").modal("show");
        console.log($("#buyProductBtn"))
    });
});
