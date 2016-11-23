<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
  <head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"/>
  	<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
  	<link href="<c:url value="/resources/css/base.css"/>" rel="stylesheet">
    <title id="title">
    	<jsp:invoke fragment="title"/>
  	</title>
  </head>
  <body>
    <div id="pageheader">
    	<jsp:invoke fragment="header"/>
  	</div>
	<nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid container-header">
            <a href="#" class="navbar-brand">IMDB2</a>
            <sec:authorize var="loggedIn" access="isAuthenticated()"/>
           	<c:choose>
			    <c:when test="${loggedIn}"> 
			        <a href="<c:url value="/logout"/>" class="login navbar-right">
						<sec:authentication property="principal.name"/>
						<i class="logout-icon fa fa-sign-out" aria-hidden="true"></i>
					</a>       
			    </c:when>
			    <c:otherwise>
			    	<a href="<c:url value="/login"/>" class="login navbar-right">Login</a>
			    </c:otherwise>
			</c:choose>
            <a href="<c:url value="/home"/>" class="navigation-links navbar-right">
                <span class="navigation-links-text">Home</span>
            </a>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
	            <a href="<c:url value="/movie/register"/>" class="navigation-links navbar-right">
	                <span class="navigation-links-text">New Movie</span>
	            </a>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
	            <a href="<c:url value="/wishlist"/>" class="navigation-links navbar-right">
	                <span class="navigation-links-text">Wishlist</span>
	            </a>
            </sec:authorize>
        </div>
    </nav>
    <div id="body">
      <div id="main-container" class="container">
      	<jsp:doBody/>
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="   crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <div id="pagefooter">
      <jsp:invoke fragment="footer"/>
    </div>
  </body>
</html>