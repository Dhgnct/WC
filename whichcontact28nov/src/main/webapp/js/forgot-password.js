//validation on forgot password modal
$("#changePassword").click(function(event){
	 
	
	 
    var securityAnswer = $("#answer").val();
	var newPassword = $("#newPassword").val();
	localStorage.securityAnswerLocalStorage= "monika";
	if(securityAnswer === localStorage.securityAnswerLocalStorage ){
		localStorage.passwordLocalStorage = newPassword;
	}
	$("#answer").val("");
    $("#newPassword").val("");
});

