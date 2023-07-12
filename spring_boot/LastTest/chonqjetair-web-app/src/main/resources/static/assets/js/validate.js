$(document).ready(function () {
    $.validator.addMethod("uppercase", function (value, element) {
        return /[A-Z]/.test(value);
    }, "Please enter at least one uppercase letter.");
    let form = $('#login-form');
    form.validate({
        rules: {
            password: {
                required: true,
                minlength: 8,
                uppercase: true
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            password: {
                required: 'Please enter password.',
                minlength: 'Name should be at least 8 characters long.',
            },
            email: {
                required: 'Please enter an email.',
                email: 'Please enter a valid email address.'
            }
        },
        errorPlacement: function (error, element) {
            let errorContainer = element.siblings('.error-container');
            errorContainer.find('.error-message').html(error);
            errorContainer.show();
        },
    });

    let inputs = form.find('input');
    inputs.on('input', function () {
        let input = $(this);
        form.validate().element(input);
    });

//    validate email reset form
});


$(document).ready(function () {
    let resetForm = $('#reset-password-form');
    resetForm.validate(
        {
            rules: {
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                email: {
                    required: 'Please enter an email.',
                    email: 'Please enter a valid email address.'
                }
            },
            errorPlacement: function (error, element) {
                let errorContainer = element.siblings('.error-container');
                errorContainer.find('.error-message').html(error);
                errorContainer.show();
            },
        })
    let inputs = resetForm.find('input');
    inputs.on('input', function () {
        let input = $(this);
        resetForm.validate().element(input);
    });
})