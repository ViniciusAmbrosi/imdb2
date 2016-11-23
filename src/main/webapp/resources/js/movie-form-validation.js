"use strict";

function MovieRegisterValidation(options) {
    this.form = options.form;
}

MovieRegisterValidation.prototype.validate = function () {
	
	$.validator.addMethod(
	    "dateFormat",
	    function(value, element) {
	        return value.match(/^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/);
	    },
	    "Please enter a date in the format dd/mm/yyyy."
	);
	
    $(this.form).validate({
        rules: {
            title: {
                required: true
            },
            releaseDate: {
            	required: true,
            	dateFormat: true
            },
            length: {
            	required: true,
            	min: 0
            },
            thumbnail: {
            	extension: 'BMP|GIF|JPG|PNG'
            },
            synopsis:{
            	required: true
            },
            genres:{
            	required: true
            }
        },
        messages: {
            title: {
            	required: 'The title field is mandatory.'
            },
            releaseDate: {
            	required: 'The release date field is mandatory',
            	date: 'The date format must be dd/mm/yyyy'
            },
            length: {
            	required: 'The length field is mandatory',
            	min: 'The length field must be greater than 0'
            },
            thumbnail: {
            	extension: "File uploaded is not an image or isn't supported format."
            },
            synopsis:{
            	required: 'The synopsis field is mandatory'
            },
            genres:{
            	required: 'The genres field is mandatory'
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