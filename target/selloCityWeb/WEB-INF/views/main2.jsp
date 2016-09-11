<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%> --%>

<!doctype html>
<html ng-app="tar" id="ng-app">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Smart Start</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>   
<%--     <jsp:include page="includes/exploded/css-includes.jsp"></jsp:include> --%>
    <script src="resources/js/nothing.js"></script>
 
</head>
  
<body>
    <input type="hidden" id="baseUrl" value="${baseUrl}" />

        <div data-ui-view="uiview"></div>

       <jsp:include page="includes/exploded/js-includes.jsp"></jsp:include>
       <jsp:include page="includes/exploded/custom-js-includes.jsp"></jsp:include>

     	
</body>
    	<script type="text/javascript" src= "http://maps.googleapis.com/maps/api/js?key=&sensor=false&extension=.js"></script>
</html>
