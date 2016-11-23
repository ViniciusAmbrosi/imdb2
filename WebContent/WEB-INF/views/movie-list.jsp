<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="movie" items="${movies}">
	  <div onclick="window.location='/imdb2/movie/details/${movie.id}'" class="col-xm-12 col-sm-6 col-md-4">
	    <div class="movie-display thumbnail">
	      <img src="/imdb2/getImage/${movie.thumbnail}" alt=""/>
	      <div class="caption">
	        <h3>${movie.title}</h3>
	        <table>
			  <tr>
			    <td class="rating-label">
		        	<label class="control-label">Rating</label>
		        </td>
		        <td>
       				<input class="ratings rating-loading pull-right" value="${movie.rating}" data-size="xs"/>
       			</td>
      			  </tr>
      			</table>
	      </div>
	    </div>
	  </div>
</c:forEach>