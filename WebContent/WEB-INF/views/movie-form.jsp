<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<t:genericpage>
	<jsp:attribute name="title">
        <c:choose>
		    <c:when test="${movie.id gt 0}"> 
	    		Edit ${movie.title}
		    </c:when>
		    <c:otherwise>
		    	Movie Registration
		    </c:otherwise>
		</c:choose>
	</jsp:attribute>
    <jsp:attribute name="header">
    	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    	<link rel="stylesheet" href="<c:url value="/resources/css/star-rating/star-rating.min.css"/>">
    	<link rel="stylesheet" href="<c:url value="/resources/css/star-rating/theme.min.css"/>">
    </jsp:attribute>
    <jsp:attribute name="footer">
    	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    	<script src=" http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
    	<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/movie-form-validation.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/star-rating/star-rating.min.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/star-rating/theme.min.js"/>"></script>
    	<script>
    	  $( function() {
		    $(".datepicker").datepicker({dateFormat: 'dd/mm/yy'});
		  } );
          new MovieRegisterValidation({
              form: $('#movie')
          }).validate();
    	</script>
    </jsp:attribute>
    <jsp:body>
        <c:choose>
		    <c:when test="${movie.id gt 0}"> 
	    		<h2>Edit ${movie.title}</h2>
		    </c:when>
		    <c:otherwise>
		    	<h2>Movie Registration</h2>
		    </c:otherwise>
		</c:choose>
		<form:form modelAttribute="movie" servletRelativeAction="/movie/register" method="POST" enctype="multipart/form-data">
		
			<form:input path="id" type="number" hidden="true"/>
			<form:input path="thumbnailPath" hidden="true"/>
		
			<div class="form-group">
				<form:label path="title" class="control-label">Title</form:label>
		        <div >
		        	<form:input class="form-control input-border" path="title" placeholder="Ex: Star Trek" autofocus="true"/>
		        	<form:errors class="has-error" path="title"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
	        
     		<div class="form-group">
				<form:label path="releaseDate" class="control-label">Release Date</form:label>
		        <div >
		        	<form:input class="datepicker form-control input-border" path="releaseDate" placeholder="DD/MM/YYYY" autofocus="true" />
		        	<form:errors class="has-error" path="releaseDate"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
			
    		<div class="form-group">
				<form:label path="length" class="control-label">Length</form:label>
		        <div >
		        	<form:input class="form-control input-border" path="length" placeholder="Minutes" autofocus="true"/>
		        	<form:errors class="has-error" path="length"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
	        
    		<div class="form-group">
				<form:label path="rating" class="control-label">Rating</form:label>
		        <div >
		        	<form:input class="rating rating-loading" path="rating" data-show-clear="false" data-max="5" data-step="0.1" data-size="xs"/>
		        	<form:errors class="has-error" path="rating"/>
					<form:errors class="has-error" path="rating"/>		        	
		        </div>
	        </div>
	        
    		<div class="form-group">
  		        <c:choose>
				    <c:when test="${not empty movie.thumbnailPath}"> 
			    		<form:label path="thumbnail" class="control-label">Thumbnail ( Current: ${movie.thumbnailPath} )</form:label>
				    </c:when>
				    <c:otherwise>
				    	<form:label path="thumbnail" class="control-label">Thumbnail</form:label>
				    </c:otherwise>
				</c:choose>
		        <div >
		        	<form:input path="thumbnail" value="${movie.thumbnail}" type="file" class="form-control input-border" placeholder="URL" autofocus="true"/>
  			        <form:errors class="has-error" path="thumbnail"/>	
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
	        
         	<div class="form-group">
				<form:label path="synopsis" class="control-label">Synopsis</form:label>
		        <div >
		        	<form:textarea class="form-control input-border" path="synopsis" 
		        		placeholder="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
		        	    autofocus="true" rows="5" cols="30"/>
		        	    <form:errors class="has-error" path="synopsis"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
			
    		<div class="form-group">
				<form:label path="genres" class="control-label">Genres</form:label>
		        <div>
        			<form:select class="form-control input-border" path="genres">
					    <form:options items="${genresList}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors class="has-error" path="genres"/>
		        </div>
	        </div>
			
		    <div class="form-group pull-right">
		        <div class="form-group">
	            	<form:button class="btn input-border form-button save">Save</form:button>
		        </div>
		    </div>
		</form:form>
		
		<c:if test="${movie.id gt 0}">
			<form:form modelAttribute="movie" servletRelativeAction="/movie/delete" method="POST">
				<form:hidden path="id"/>
			    <div class="form-group">
			        <div class="form-group">
		            	<form:button class="btn input-border form-button delete">Delete</form:button>
			        </div>
			    </div>
			</form:form>
		</c:if>
    </jsp:body>
</t:genericpage>