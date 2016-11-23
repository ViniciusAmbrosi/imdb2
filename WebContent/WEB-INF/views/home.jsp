<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:genericpage>
	<jsp:attribute name="title">
		Home
	</jsp:attribute>
    <jsp:attribute name="header">
       	<link rel="stylesheet" href="<c:url value="/resources/css/star-rating/star-rating.min.css"/>">
    	<link rel="stylesheet" href="<c:url value="/resources/css/star-rating/theme.min.css"/>">
    </jsp:attribute>
    <jsp:attribute name="footer">
  	    <script type="text/javascript" src="<c:url value="/resources/js/star-rating/star-rating.min.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/star-rating/theme.min.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/models/Movie.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/views/HomeView.js"/>"></script>
    	<script>
	    	 new HomeView({
	    		 ratingStars: $('.ratings'),
	    		 urlGetByName: '/imdb2/movie/filterByName',
	    		 filterInput: $('#filter'),
	    		 movieDisplay: $('.movies-display')
	         }).register();
    	</script>
    </jsp:attribute>
    <jsp:body>
        <h2 class="text-center" >Movies</h2>
        <hr/>
    	<div class="form-group">
	        <div>
	        	<input id="filter" name="filter" class="form-control input-border" placeholder="Filter"/>
	        </div>
        </div>
        <div class="movies-display">
			<jsp:include page="movie-list.jsp"/>
		</div>
    </jsp:body>
</t:genericpage>            
