$(document).ready(function() {
	$.validator.setDefaults({
	    submitHandler: function() {
	        alert("submitted!");
	    }
	});
      // Setup form validation on the #register-form element
      $("#userSignUpForm").validate({
      
          // Specify the validation rules
          rules: {
        	  'userDetails.firstname': "required",
        	  'userDetails.lastname': "required",
        	  'userDetails.email': {
                  required: true,
                  email: true
              },
              'userDetails.password': {
                  required: true,
                  minlength: 8,
                  maxlength:12
              },
              'userDetails.userid': {
                  required: true,
                  minlength: 6,
                  maxlength:6
              },
              confirmPass:{
            	    equalTo: '#reg_password'
            	      },
              agree: "required"
          },
          
          // Specify the validation error messages	
          messages: {
        	  'userDetails.firstname': "*** Please enter your first name",
        	  'userDetails.lastname': "*** Please enter your last name",
        	  'userDetails.password': {
                  required: "*** Please provide a password",
                  minlength: "*** Your password must in between 8-12 characters long"
              },
              confirmPass :" Enter Confirm Password Same as Password",
              'userDetails.email': "*** Please enter a valid email address",
              'userDetails.userid': "*** Please enter a userid length of 6",
              agree: "Please accept our policy"
          },
          
          submitHandler: function(form) {
        	  alert($("#userDetails.password"));
              form.submit();
          }
      });
    });