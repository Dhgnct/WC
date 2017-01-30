$(document).ready(function (){
       
       /**
       * Calls the logout servlet for admin
       */
       function logout(){
              $.ajax({
                     type : "Post",
                     url : "LogoutSessionInvalidate",
                     dataType : "text",
                     success : function(data) {
                     },
                     error: function(jqXHR, exception) {
                      if(jqXHR.status)
                            console.log(jqXHR.status);
                      else
                            console.log(jqXHR.exception);
                  }
              });
       }
       
       //Assign event handler to logout link
       $('#logout').click(logout);
});
