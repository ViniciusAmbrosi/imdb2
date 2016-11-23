<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<t:genericpage>
	<jsp:attribute name="title">
		Register
	</jsp:attribute>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    	<script src=" http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/user-form-validation.js"/>"></script>
     	<script>
           new UserRegisterValidation({
               form: $('#user')
           }).validate();
     	</script>
    </jsp:attribute>
    <jsp:body>
    	<h2>User Registration</h2>
		<form:form modelAttribute="user" servletRelativeAction="/register" method="POST">
		
			<form:input path="id" type="number" hidden="true"/>
		
			<div class="form-group">
				<form:label path="name" class="control-label">Name</form:label>
		        <div >
		        	<form:input class="form-control input-border" path="name" placeholder="Complete name" autofocus="true"/>
		        	<form:errors class="has-error" path="name"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
	        
     		<div class="form-group">
				<form:label path="username" class="control-label">Username</form:label>
		        <div >
		        	<form:input class="form-control input-border" path="username" placeholder="Name used to login" autofocus="true" />
		        	<form:errors class="has-error" path="username"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
			
    		<div class="form-group">
				<form:label path="password" class="control-label">Password</form:label>
		        <div >
		        	<form:input type="password" class="form-control input-border" path="password" placeholder="Password" autofocus="true"/>
		        	<form:errors class="has-error" path="password"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
	        
    		<div class="form-group">
				<form:label path="passwordConfirmation" class="control-label">Password Confirmation</form:label>
		        <div >
		        	<form:input type="password" class="form-control input-border" path="passwordConfirmation" placeholder="Confirm your password" autofocus="true"/>
		        	<form:errors class="has-error" path="passwordConfirmation"/>
		            <span class="feedback-icon glyphicon form-control-feedback" aria-hidden="true"></span>
		        </div>
	        </div>
			
		    <div class="form-group pull-right">
		        <div class="form-group">
	            	<form:button class="btn input-border form-button save">Save</form:button>
		        </div>
		    </div>
		</form:form>
    </jsp:body>
</t:genericpage>