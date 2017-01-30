/* Function to convert CSV to JSON */
$(function() {
    $("#fileUpload").change(function() {

        //Regular Expression for allowing Excel files only.
        var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.txt)$/;
        /*The test() method tests for a match in a string.
          This method returns true if it finds a match, otherwise it returns false.
        */
        
        if (regex.test($("#fileUpload").val().toLowerCase())) {

            //use to know file type
            if (typeof(FileReader) != "undefined") {
                var reader = new FileReader();
                reader.onload = function(e) {
                    var rows = e.target.result.split("\r\n");

                    if (rows.length > 0) {
                        var firstRowCells = GetCSVCells(rows[0], ",");

                        var dataArray = new Array();
                        for (var row = 1; row < rows.length; row++) {
                            var cells = GetCSVCells(rows[row], ",");
                            var obj = {};
                            for (var cell = 0; cell < cells.length; cell++) {
                                obj[firstRowCells[cell]] = cells[cell];
                            }
                            //dataArray store all the value.
                            dataArray.push(obj);
                        }         

                        $(document).ready(function() {
							var jsonData = dataArray;
							var allConnections;
							var infoDivision;
							var firstName;
							var company;
							var photos;
							var image;
                            allConnections = $("#ContainConnectionInformation");
                            allConnections.addClass("container-fluid");
                            allConnections.css({
                                "padding": "20px"
                            });
                            infoDivision = $("<div>");
                            infoDivision.addClass("row ");
                            infoDivision.css({
                                "padding-left": "70px"
                            });
                            for (var contact = 0; contact < jsonData.length-1; contact++) {

                                //infoDivision = $("<div>");
                                //infoDivision.addClass("row ");
                                var imageHover = $("<div>");
                                imageHover.addClass("hovereffect");

                                innerDivision = $("<div>");
                                innerDivision.addClass("col-sm-2 events hovereffect");
                                innerDivision.css({
                                    "background-color": "white",
                                    "height": "200px",
                                    "width": "150px",
                                    "margin-left": "-5px"
                                });

                                var photos = jsonData[contact]["Photos"];
                                image = $("<img>");
                                image.addClass("img-responsive img-circle");
                                image.css({
                                    "height": "100",
                                    "width": "119"
                                });


                                image.attr('src', photos);
                                imageHover.append(image);

                                innerDivision.append(imageHover);

                                //innerDivision.append('<a href="#"><img id="theImg" src="client.jpg" height="90" width="119" align="left"/></a>');
                                firstName = $("<p>");
                                firstName.addClass("text-success");
                                $(firstName).text(jsonData[contact]["First Name"] + " " + jsonData[contact]["Last Name"]);
                                innerDivision.append(firstName);

                                company = $("<span>");
                                company.addClass("text-danger");
                                $(company).text(jsonData[contact]["Current Company"]);
                                innerDivision.append(company);
                                infoDivision.append(innerDivision);
                                allConnections.append(infoDivision);



                            }
                        });  
                    }
                    // use to split the information into row
                    function GetCSVCells(row, separator) {
                        return row.split(separator);
                    }
                }
                reader.readAsText($("#fileUpload")[0].files[0]);
            }
        }
    });
});