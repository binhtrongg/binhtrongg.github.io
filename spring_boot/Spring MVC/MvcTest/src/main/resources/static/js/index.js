$(document).ready(function () {
    let chosenFile = null;

    $("#creatForm").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "name": {
                required: true,
                maxlength: 255
            },
            "price": {
                required: true,
                min: 0
            },
            "description": {
                required: true,
                maxlength: 255
            }
        },
        messages: {
            "name": {
                required: "Yêu cầu nhập tên sản phẩm",
                maxlength: "Hãy nhập tối đa 255 ký tự"
            },
            "price": {
                required: "Yêu cầu nhập giá",
                min: "Giá phải lớn hơn 0"
            },
            "description": {
                required: "Yêu cầu nhập mô tả",
                maxlength: "Không quá 255 kí tự"
            }
        },
    });

    $("#updateForm").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "name": {
                required: true,
                maxlength: 255
            },
            "price": {
                required: true,
                min: 0
            },
            "description": {
                required: true,
                maxlength: 255
            }
        },
        messages: {
            "name": {
                required: "Yêu cầu nhập tên sản phẩm",
                maxlength: "Hãy nhập tối đa 255 ký tự"
            },
            "price": {
                required: "Yêu cầu nhập giá",
                min: "Giá phải lớn hơn 0"
            },
            "description": {
                required: "Yêu cầu nhập mô tả",
                maxlength: "Không quá 255 kí tự"
            }
        },
    });

    function handleAvatarChange(event, key) {
        const tempFiles = event.target.files;
        if (!tempFiles || tempFiles.length === 0) {
            return;
        }
        chosenFile = tempFiles[0];
        console.log(chosenFile);

        const imageBlob = new Blob([chosenFile], { type: chosenFile.type });
        const imageUrl = URL.createObjectURL(imageBlob);
        $("#" + key).attr("src", imageUrl);
    }

    $("#avatar-input").change(event => {
        handleAvatarChange(event, "avatar-preview");
    });

    $("#avatar-input-update").change(event => {
        handleAvatarChange(event, "cur-avatar-preview");
    });

    $("#save-product-btn").click(function (event) {
        event.preventDefault();
        console.log(chosenFile);
        const isValidForm = $("#creatForm").valid();

        if (!chosenFile) {
            toastr.error("chưa chọn file")
            return;
        }
        if (!isValidForm) {
            return;
        }
        const formData = new FormData();
        formData.append('avatar', chosenFile);
        $.ajax({
            url: '/api/v1/products/avatar',
            data: formData,
            type: 'POST',
            contentType: false,
            processData: false,
            success: function (data) {
                $('#avatar').val(data);
                console.log("ok")
                toastr.success("thêm thành công")
                $("#creatForm").unbind("submit").submit();
            },
            error: function (errorData) {
            }
        });
    });
    $(".update-product").click(async function (event) {
        const productId = $(event.currentTarget).attr("product-id");
        let currentProduct = null;
        await $.ajax({
            url: '/api/v1/products/' + productId,
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                currentProduct = data;
                $('#cur-avatar-preview').attr("src", currentProduct.avatar);
            },
            error: function (data) {
                console.log(data);
                alert(data.responseJSON.message);
            }
        });
        if (!currentProduct) {
            return;
        }

        $('#updateForm #name').val(currentProduct.name);
        $('#updateForm #price').val(currentProduct.price);
        $('#updateForm #description').val(currentProduct.description);
        $('#updateProductModal #submit-update-product').attr("product-id", productId);
        $('#updateProductModal').modal('show');
    });


    $("#submit-update-product").click(function (event) {
        event.preventDefault();
        const isValidFormUpdate = $("#updateForm").valid();
        if (!isValidFormUpdate) {
            return;
        }
        if (!chosenFile) {
            toastr.error("chưa chọn file")
            return;
        }
        const formData = new FormData();
        formData.append('avatar', chosenFile);
        $.ajax({
            url: '/api/v1/products/avatar',
            data: formData,
            type: 'POST',
            contentType: false,
            processData: false,
            success: function (data) {
                console.log(data)
                updateProduct(data)
            },
            error: function (errorData) {
            }
        });
    });

    function updateProduct(avtUrl){
        const productId = $('#updateProductModal #submit-update-product').attr("product-id");
        const formData = $('#updateProductModal #updateForm').serializeArray();
        formData.push({ name: "avatar", value: avtUrl });
        console.log("formdata "+formData)
        console.log(formData);
        if (!formData || formData.length === 0) {
            return;
        }
        const requestData = {};
        for (let i = 0; i < formData.length; i++) {
            requestData[formData[i].name] = formData[i].value;
        }
        console.log(productId)
        console.log("requestdata "+requestData)
        $.ajax({
            url: '/api/v1/products/' + productId,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function(response) {
                toastr.success('Cập nhật sản phẩm thành công');
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
    }
});
