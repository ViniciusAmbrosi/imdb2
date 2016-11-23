"use strict";

function UserRegisterValidation(options) {
    this.form = options.form;
}

UserRegisterValidation.prototype.validate = function () {
	
	$.validator.addMethod(
		    "passwordRequirements",
		    function(value, element) {
		        return value.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
		    },
		    "The password must contain at least on digit, one lower case, one upper case and at least 8 characters."
		);
	
	(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])$/)
    $(this.form).validate({
        rules: {
            name: {
                required: true
            },
            username: {
            	required: true
            },
            password: {
            	required: true,
            	passwordRequirements: true
            },
            passwordConfirmation: {
            	required: true,
            	equalTo: "#password",
            	passwordRequirements: true
            }
        },
        messages: {
        	name: {
            	required: 'The name field is mandatory.'
            },
            username: {
            	required: 'The username field is mandatory.'
            },
            password: {
            	required: 'The password field is mandatory.',
            },
            passwordConfirmation: {
            	extension: "The password confirmation field is mandatory.",
            	equalTo: "The password and password confirmation fields must match.",
            }
        },
        success: function (label) {
        	$(label).parent().parent().removeClass('has-error').removeClass('has-feedback');
        	$(label).parent().parent().addClass('has-success').addClass('has-feedback');
        	$(label).siblings('.feedback-icon').removeClass('glyphicon-remove').addClass('glyphicon-ok');
        },
        highlight: function (element, errorClass) {
            $(element).fadeOut(function () {
                $(element).fadeIn();
            });
        	$(element).parent().parent().removeClass('has-success').removeClass('has-feedback');
        	$(element).parent().parent().addClass('has-error').addClass('has-feedback');
        	$(element).siblings('.feedback-icon').removeClass('glyphicon-ok').addClass('glyphicon-remove');
        }
    });
};