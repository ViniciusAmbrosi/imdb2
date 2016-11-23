<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
	<jsp:attribute name="title">
		Login
	</jsp:attribute>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
    	<h2>Login</h2>
    	<hr/>
		<form name='f' action="login" method='POST'>
	   		<div class="form-group">
				<label for="username" class="control-label">Username</label>
		        <div >
		        	<input class="form-control input-border" name="username" placeholder="Username" autofocus="true" />
		        </div>
	        </div>
	     		<div class="form-group">
				<label for="password" class="control-label">Password</label>
		        <div >
		        	<input type="password" class="form-control input-border" name="password" placeholder="Password"/>
		        </div>
	        </div>
			    <div class="form-group pull-right">
		        <div class="form-group">
	            	<button class="btn input-border form-button save">Login</button>
		        </div>
		    </div>
		    
	        <div class="form-group">Don't have an account?</div>

		    <div class="form-group">
		        <a id="botao-cadastrar" href="<c:url value="/register"/>">Register</a>
		    </div>
		</form>
    </jsp:body>
</t:genericpage>