$(document).ready(function () {
    let form = $('#login-form');
    form.validate({
        rules: {
            password: {
                required: true,
                minlength: 7,
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            password: {
                required: 'Please enter password.',
                minlength: 'password should be at least 8 characters long.',
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


$(document).ready(function () {
    let signupForm = $('#signup-form');
    signupForm.validate(
        {
            rules: {
                email: {
                    required: true,
                    email: true
                },
                name:{
                    required:true,
                    minlength:10
                },
                password: {
                    required: true,
                    minlength: 8,
                },
                confirmPassword:{
                    required: true,
                    minlength: 8,
                    equalTo: '#registerPasswordInput'
                }
            },
            messages: {
                email: {
                    required: 'Please enter an email.',
                    email: 'Please enter a valid email address.'
                },
                name: {
                    required: 'Please enter your name.',
                    minlength: 'name should be at least 8 characters long.'
                },
                password: {
                    required: 'Please enter password.',
                    minlength: 'password should be at least 8 characters long.',
                },
                confirmPassword: {
                    required: 'Please enter confirm password.',
                    minlength: 'password should be at least 8 characters long.',
                    equalTo: 'Passwords do not match'
                },


            },
            errorPlacement: function (error, element) {
                let errorContainer = element.siblings('.error-container');
                errorContainer.find('.error-message').html(error);
                errorContainer.show();
            },
        })
    let inputs = signupForm.find('input');
    inputs.on('input', function () {
        let input = $(this);
        signupForm.validate().element(input);
    });
})


$(document).ready(function () {
    let newPasswordForm = $('#new-password-form');
    newPasswordForm.validate(
        {
            rules: {
                password: {
                    required: true,
                    minlength: 8,
                },
                newPassword:{
                    required: true,
                    minlength: 8,
                    equalTo: '#new-password-input'
                }
            },
            messages: {
                password: {
                    required: 'Please enter password.',
                    minlength: 'password should be at least 8 characters long.',
                },
                newPassword: {
                    required: 'Please enter confirm password.',
                    minlength: 'password should be at least 8 characters long.',
                    equalTo: 'Passwords do not match'
                },


            },
            errorPlacement: function (error, element) {
                let errorContainer = element.siblings('.error-container');
                errorContainer.find('.error-message').html(error);
                errorContainer.show();
            },
        })
    let inputs = newPasswordForm.find('input');
    inputs.on('input', function () {
        let input = $(this);
        newPasswordForm.validate().element(input);
    });
})
