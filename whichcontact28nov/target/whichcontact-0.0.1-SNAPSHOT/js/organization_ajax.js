// script to display the json response into datatables on GUI
$(document).ready(function() {
	var user = $(this).attr('id');
	if (user != '') {
		$.ajax({
			type : "GET",
			url : "OrganizationServlet",
			dataType : 'json',
			success : function(json) {
				$('#jsontable').DataTable({
					data : json,
					columns : [ {
						"data" : "name",
						"defaultContent" : "-",
					}, {

						"data" : "domain",
						"defaultContent" : "-",
					}, {

						"data" : "homepage_url",
						"defaultContent" : "-",
						"render" : function(data, type, full, meta) {
							return '<a href="' + data + '" target=_blank>' + data + '</a>';
						}
					}, {

						"data" : "country_code",
						"defaultContent" : "-",
					}, ]
				});
			}
		});
	}
});
