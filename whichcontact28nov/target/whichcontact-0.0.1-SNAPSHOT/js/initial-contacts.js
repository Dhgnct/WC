  $(document).ready(function() {

      var json = [{
          "First Name": "Deepak",
          "Last Name": "Vats",
          "Email Address": "deepakvts75@gmail.com",
          "Current Company": "Wilson Inc.",
          "Current Position": "",
          "Tags": "",
          "Photos": "images/faces/images1.jpg"
      }, {
          "First Name": "Akshit",
          "Last Name": "Huria",
          "Email Address": "AKSHIT.HURIA94@gmail.com",
          "Current Company": "Mobilyte",
          "Current Position": "SalesForce developer",
          "Tags": "",
          "Photos": "images/faces/images2.jpg"
      }, {
          "First Name": "Anuj",
          "Last Name": "Huria",
          "Email Address": "HURIA.99.ANUJ@gmail.com",
          "Current Company": "Beta Soft Systems",
          "Current Position": "Salesforce Developer",
          "Tags": "",
          "Photos": "images/faces/images3.jpg"
      }, {
          "First Name": "Nimesh",
          "Last Name": "Kumar",
          "Email Address": "nimesh.kumar031@gmail.com",
          "Current Company": "Fonantrix LLP",
          "Current Position": "",
          "Tags": "",
          "Photos": "images/faces/images4.jpg"
      }, ];



      var allConnections;
      var infoDivision;
      var firstName;
      var company;
      var photos;
      var image;


      allConnections = $("#ContainConnectionInformation");
      allConnections.addClass("container-fluid");
      allConnections.css({
          "padding": "20px",
          "background-color": "#e6e6e6"
      });
      infoDivision = $("<div>");
      infoDivision.addClass("row ");
      infoDivision.css({
          "padding-left": "235px",
          "height": "250px"
      });
      for (var i = 0; i < json.length; i++) {
          var imageHover = $("<div>");
          imageHover.addClass("hovereffect")

          innerDivision = $("<div>");
          innerDivision.addClass("col-sm-2 events hovereffect");
          innerDivision.css({
              "background-color": "white",
              "height": "200px",
              "width": "150px",
              "margin-left": "-5px"
          });

          var photos = json[i]["Photos"];

          image = $("<img>");
          image.addClass("img-responsive img-circle");
          image.css({
              "height": "100",
              "width": "119"
          });
          image.attr('src', photos);
          imageHover.append(image);

          innerDivision.append(imageHover);

          firstName = $("<p>");
          firstName.addClass("text-success");
          $(firstName).text(json[i]["First Name"] + " " + json[i]["Last Name"]);
          innerDivision.append(firstName);

          company = $("<span>");
          company.addClass("text-danger");
          $(company).text(json[i]["Current Company"]);
          innerDivision.append(company);
          infoDivision.append(innerDivision);
          allConnections.append(infoDivision);



      }
  });