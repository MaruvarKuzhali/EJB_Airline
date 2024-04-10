<%-- 
    Document   : success
    Created on : 3 Apr, 2021, 9:21:22 AM
    Author     : m.vishnu.priya
--%>

<html>
    <head>
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: "Lato", sans-serif}
.mySlides {display: none}
</style>
<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
</style>
        
    </head>
    <body>
        

<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <!--<a href="available.html" class="w3-bar-item w3-button w3-padding-large">CHECK AVAILABILITY</a>
    <a href="book.html" class="w3-bar-item w3-button w3-padding-large w3-hide-small">RESERVATION FORM</a>
    <a href="cancel.html" class="w3-bar-item w3-button w3-padding-large w3-hide-small">TICKET CANCELLATION</a> -->
    <a href="deleteint.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">DELETE MY ACCOUNT</a>
    <a href="profile.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">VIEW PROFILE</a>
    <a href="TicketServlet" class="w3-bar-item w3-button w3-padding-large w3-hide-small">MY TICKET DETAILS</a>
    <a href="logout.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
    <a href="https://www.google.com/" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a>
  </div>
</div>



<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="${pageContext.request.contextPath}/img/b1.jpg" style="width:100%">
  <div class="text"><h3>Los Angeles</h3>
      <p><b>We are awarded the best airline management System in 2020</b></p>  </div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="${pageContext.request.contextPath}/img/b2.jpg" style="width:100%">
  <div class="text"><h3>Technology</h3>
      <p><b>Best Equipped Airplanes with most advanced technologies.</b></p> </div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="${pageContext.request.contextPath}/img/b3.png" style="width:100%">
  <div class="text"><h3>Passengers</h3>
      <p><b>Thank you, Passengers - If it were n't for you.</b></p>  </div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>


<!-- The Tour Section -->
  <div class="w3-black" id="tour">
    <div class="w3-container w3-content w3-padding-64" style="max-width:800px">
      <h2 class="w3-wide w3-center">Welcome <%=session.getAttribute("userid")%></h2>
      <p class="w3-opacity w3-center"><i>Remember to book your tickets!</i></p><br>

      <ul class="w3-ul w3-border w3-white w3-text-grey">
        <li class="w3-padding">Ticket Reservation<span class="w3-badge w3-right w3-margin-right">1</span></li>
        <li class="w3-padding">Ticket Cancellation <span class="w3-badge w3-right w3-margin-right">2</span></li>
        <li class="w3-padding">Flight Details <span class="w3-badge w3-right w3-margin-right">3</span></li>
      </ul>

      <div class="w3-row-padding w3-padding-32" style="margin:0 -16px">
        <div class="w3-third w3-margin-bottom">
          <img src="${pageContext.request.contextPath}/img/b5.png" alt="New York" style="width:100%" class="w3-hover-opacity">
          <div class="w3-container w3-white">
            <p><b>Ticket Reservation</b></p>
            <p class="w3-opacity">Reserve your Tickets here</p>
            <p>Fill the reservation form to book your tickets.Enjoy your journey with us.</p>
            <button class="w3-button w3-black w3-margin-bottom"><a href="book.html">Buy Tickets</a></button>
          </div>
        </div>
        <div class="w3-third w3-margin-bottom">
          <img src="${pageContext.request.contextPath}/img/b6.jpg" alt="Paris" style="width:100%" class="w3-hover-opacity">
          <div class="w3-container w3-white">
            <p><b>Ticket Cancellation</b></p>
            <p class="w3-opacity">Cancel your tickets here</p>
            <p>Fill the Cancellation form to cancel your tickets. Ticket Amount will be refunded.</p>
            <button class="w3-button w3-black w3-margin-bottom" ><a href="cancel.html">Cancel Tickets</a></button>
          </div>
        </div>
        <div class="w3-third w3-margin-bottom">
          <img src="${pageContext.request.contextPath}/img/b7.png" alt="San Francisco" style="width:100%" class="w3-hover-opacity">
          <div class="w3-container w3-white">
            <p><b>Ticket Availability</b></p>
            <p class="w3-opacity">Check flight details here</p>
            <p>Enter destination and source to check all available flight details.</p>
            <button class="w3-button w3-black w3-margin-bottom" ><a href="available.html">Check Availability</a></button>
          </div>
        </div>
      </div>
    </div>
  </div>





<a href='logout.jsp'>Log out</a><br/><br/>
<a href='available.html'>Check Availability</a><br/><br/>
<a href='book.html'>Reservation Form</a><br/><br/>
<a href='cancel.html'>Ticket Cancellation</a><br/><br/>
<a href='deleteint.jsp'>Delete My Account</a><br/><br/>


<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>




<%
    }
%>




    </body>
</html>