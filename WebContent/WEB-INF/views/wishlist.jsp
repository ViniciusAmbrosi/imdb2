<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:genericpage>
	<jsp:attribute name="title">
		Wishlist
	</jsp:attribute>
    <jsp:attribute name="header">
       	<link rel="stylesheet" href="<c:url value="/resources/css/star-rating/star-rating.min.css"/>">
    	<link rel="stylesheet" href="<c:url value="/resources/css/star-rating/theme.min.css"/>">
    </jsp:attribute>
    <jsp:attribute name="footer">
  	    <script type="text/javascript" src="<c:url value="/resources/js/star-rating/star-rating.min.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/star-rating/theme.min.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/views/WishlistView.js"/>"></script>
    	<script>
    		new WishlistView({
    			 ratingStars: $('.ratings')
    		}).register();
    	</script>
    </jsp:attribute>
    <jsp:body>
        <h2 class="text-center" >Wishlist</h2>
        <hr/>
        <div class="movies-display">
			<jsp:include page="movie-list.jsp"/>
		</div>
    </jsp:body>
</t:genericpage>            
