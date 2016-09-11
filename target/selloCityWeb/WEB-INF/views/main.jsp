<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>

<!doctype html>
<html ng-app="tar" id="ng-app">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Sello City</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>   
    <jsp:include page="includes/exploded/css-includes.jsp"></jsp:include>
    <script src="resources/js/nothing.js"></script>
    <style>
.test ul {
    list-style: none;
    padding: 0;
    margin: 0;
}
.test li {
    float: left;
    border: 1px solid #000;
    border-bottom-width: 0;
    margin: 3px 3px 0px 3px;
    padding: 5px 5px 0px 5px;
    background-color: #CCC;
    color: #696969;
}
.test #mainView {
    border: 1px solid black;
	clear: both;
	padding: 0 1em;
}
.test .active {
    background-color: #FFF;
    color: #000;
}
</style>
</head>
  
<body>
    <input type="hidden" id="baseUrl" value="${baseUrl}" />
       <div class="container" >
          <div class="header">
            <div class="info" >
                <ul >
                                                                          
                     <li>Logged in as: 
                         Admin
                     </li>
                       <li>Logged in as: 
                         Admin
                     </li> 
   				
                </ul>
                <ul>
                 <li>Sales Play: {{salesPlay}}
                     </li> 
                </ul>
            </div>
            <div class="banner" data-ng-controller="HomeController">   
              <div class="title"><h1  align="center"><a href="#" >Welcome To Sello City </a></h1></div>                        

                           
                    
                    <div class="clear"></div>
                </div>
              
            </div>
              
        </div>
         <p>you working on Sales Play</p>
        <div>
    
        </div>
        <div class="content" data-ng-controller="HomeController">
        		
                <div data-ui-view="uiview"></div>
        </div>
       <jsp:include page="includes/exploded/js-includes.jsp"></jsp:include>
       <jsp:include page="includes/exploded/custom-js-includes.jsp"></jsp:include>
      
</body>
    
</html>
