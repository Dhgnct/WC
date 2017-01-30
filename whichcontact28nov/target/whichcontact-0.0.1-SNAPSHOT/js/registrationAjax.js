function userRegistraionValidation() {
	var Amail = $("#Adminmail").val();
	var APwd = $("#AdminPwd").val();
	var useremail = $("#mail").val();
	var userpassword = $("#Pwd").val();
	var username = $("#name").val();
	$.ajax({
		type : "Post",
		url : "UserRegistration",
		data : {
			Amail : Amail,
			APwd : APwd,
			useremail : useremail,
			userpassword : userpassword,
			username : username
		},
		dataType : "text",
		success : function(status) {
			if (status === "validcredentials") {

				$(location).attr("href", "index.html");

			} else {
				alert("invalid credentials");
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
