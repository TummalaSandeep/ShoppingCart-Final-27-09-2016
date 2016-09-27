  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
  <title>ShoppingCart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 60 %;
      margin: auto;
  }
  </style>
</head>
<body> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
<div style="padding:16px;color:#fff;background-color:#122b3e">
ShoppingCart
</div>
     <span class="glyphicon search glyphicon"></span> 
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="hi">Home</a></li>
         <li><a href="reg">Register</a></li>
       <li><a href="contact">Contact us</a></li>

        <li><a href="ManageProduct">Product</a></li>
      <li><a href="login">Login</a></li>
       <li><span class="glyphicon search glyphicon"></span></li>
     </ul> 
  </div>
</nav>
 
<div class="container">
  
    <div class="center-block">  
    
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    
   <!-- Wrapper for slides -->
    
    
    <div class="carousel-inner" role="listbox">
     <div class="item">
         <img src="<c:url value="resources/images/sandy1.jpg"/>" alt="Chania" width="600" height="500"/>
      </div>
      
       <div class="item">
         <img src="<c:url value="resources/images/sandy2.jpg"/>" alt="Chania" width="600" height="500"/>
      </div>
       <div class="item">
         <img src="<c:url value="resources/images/sandy3.jpg"/>" alt="Chania" width="600" height="500"/>
      </div>
      <div class="item active">
         <img src="<c:url value="resources/images/sandy4.jpg"/>" alt="Chania" width="600" height="500"/>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/sandy5.jpg"/>" alt="Chania" width="600" height="500"/>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/sandy6.jpg"/>" alt="Chania" width="600" height="500"> 
      </div>
       <div class="item">
        <img src="<c:url value="/resources/images/sandy7.jpg"/>" alt="Chania" width="600" height="500"> 
      </div>
        <div class="item">
        <img src="<c:url value="/resources/images/sandy8.jpg"/>" alt="Chania" width="600" height="500"> 
      </div>
        <div class="item">
        <img src="<c:url value="/resources/images/sandy9.jpg"/>" alt="Chania" width="600" height="500"> 
      </div>
      
      
          <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div></div></div>
 <br/>

<div class="container">
            
  <div class="row">
    <div class="col-sm-4">
      <a href="enter">
          
         <img src="<c:url value="/resources/images/sandy9.jpg"/>" alt="Pulpit Rock" style="width:300px;height:150px"/n>
             </div>
    <div class="col-sm-4">
           
         <img src="<c:url value="/resources/images/sandy8.jpg"/>" alt="Moustiers Sainte Marie" style="width:300px;height:150px"/>
         
    </div>
    <div class="col-sm-4">
      <a href="enter pro?data=table">
           <img src="<c:url value="/resources/images/sandy6.jpg"/>" alt="Cinque Terre" style="width:300px;height:150px"/>
      </a>
    </div>
  </div>
</div>
</body>
</html>