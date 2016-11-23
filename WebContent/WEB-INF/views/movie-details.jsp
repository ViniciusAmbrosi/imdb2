<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
	<jsp:attribute name="title">
		${movie.title} - Details
	</jsp:attribute>
    <jsp:attribute name="header">
        <link rel="stylesheet" href="<c:url value="/resources/css/star-rating/star-rating.min.css"/>">
    	<link rel="stylesheet" href="<c:url value="/resources/css/star-rating/theme.min.css"/>">
    </jsp:attribute>
    <jsp:attribute name="footer">
     	<script type="text/javascript" src="<c:url value="/resources/js/star-rating/star-rating.min.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/star-rating/theme.min.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/models/Movie.js"/>"></script>
    	<script type="text/javascript" src="<c:url value="/resources/js/views/MovieDetailsView.js"/>"></script>
    	<script>
		   	 new MovieDetailsView({
				 ratingStars: $('.ratings'),
				 urlAddToWishlist: '/imdb2/wishlist/add',
				 urlRemoveFromWishlist: '/imdb2/wishlist/remove',
				 addWishlistButton: $('#add-wishlist-button'),
		     }).register();
    	</script>
    </jsp:attribute>
    <jsp:body>
   		<div class="sub-container">
			<img class="pull-right movie-details-thumb" src="/imdb2/getImage/${movie.thumbnail}" alt="movieImg"/>
			<h1>${movie.title} <small>Release: ${movie.releaseDate}</small></h1>
			<div class="movie-details">
		        <table class="rating-movie-details">
				  <tr>
				    <td class="rating-label">
			        	<label class="control-label">Rating</label>
			        </td>
			        <td>
	      				<input class="ratings rating-loading pull-right" value="${movie.rating}" data-size="xs"/>
	      			</td>
	   			  </tr>
	   			</table>
				<ul class="list-inline">
					<strong>Genres: </strong>
					<c:forEach var="genre" items="${movie.genres}">
						<li>${genre.name}</li>
					</c:forEach>
				</ul>
				<p><strong>Duration: </strong> ${movie.length} hours</p>

				<dl>
				  <dt>Synopsis:</dt>
				  <dd>${movie.synopsis}</dd>
				</dl>
			</div>
 		    <sec:authorize access="hasRole('ROLE_MOD')">
		         <a href="<c:url value="/movie/edit/${movie.id}"/>" class="btn input-border form-button save pull-left edit-button-movie-details">
		             Edit
		         </a>
	        </sec:authorize>
     		<sec:authorize access="hasRole('ROLE_USER')">
     			<c:choose>
				    <c:when test="${inWishlist}"> 
   				    	<a id="add-wishlist-button" class="btn input-border form-button wishlist-added pull-left edit-button-movie-details wishlist-button" data-id="${movie.id}">
		             		<i class="fa fa-check" aria-hidden="true"></i> Wishlist
		        		</a>
				    </c:when>
				    <c:otherwise>
				    	<a id="add-wishlist-button" class="btn input-border form-button save pull-left edit-button-movie-details wishlist-button" data-id="${movie.id}">
		             		<i class="fa fa-plus" aria-hidden="true"></i> Wishlist
		        		</a>
				    </c:otherwise>
				</c:choose>
	        </sec:authorize>
        </div>
    </jsp:body>
</t:genericpage>