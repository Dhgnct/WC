
function adminLoginValidate() {
	var email = $("#email").val();
	var password = $("#password").val();
	$.ajax({
		type : "Post",
		url : "LoginServlet",
		data : {
			email : email,
			password : password
		},
		dataType : "text",
		success : function(status) {
			if (status === "validcredentials") {

				$(location).attr("href", "about.html");

			} else if (($("#email").val() === '') && ($("#password").val() === '')) {
				
				$("#emailError").css("color", "red");
				$("#emailError").css("fontWeight", "bold");
				$("#emailError").html("Please enter a valid email");
				$("#passwordError").css("color", "red");
				$("#passwordError").css("fontWeight", "bold");
				$("#passwordError").html("Please enter a valid password");
				
			} else if (($("#password").val() === '')) {
				
				$("#passwordError").css("color", "red");
				$("#passwordError").css("fontWeight", "bold");
				$("#passwordError").html("Please enter a valid password ");

			} else if (($("#email").val() === '')) {
				$("#emailError").css("color", "red");
				$("#emailError").css("fontWeight", "bold");
				$("#emailError").html("Please enter a valid email ");
			} else {
				$("#passwordError").css("color", "red");
				$("#passwordError").css("fontWeight", "bold");
				$("#passwordError").html("please enter a valid email and password");
			}

			$("#email").focus(function() {
				$("#passwordError").html('');
				$("#emailError").html('');
			});
			$("#password").focus(function() {
				$("#passwordError").html('');
				$("#emailError").html('');
			});
		},
		error : function(err) {
			alert('Error while fetchig.');
		}
	});

}
