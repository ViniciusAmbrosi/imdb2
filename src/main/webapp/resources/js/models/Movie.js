'use strict';

function Movie(options) {
    options = options || {};
    this.urlGetByName = options.urlGetByName || '/imdb2/movie/filterByName',
    this.urlAddToWishlist = options.urlAddToWishlist || '/imdb2/wishlist/add',
    this.urlRemoveFromWishlist = options.urlRemoveFromWishlist || '/imdb2/wishlist/remove'
};

Movie.prototype.filterByName = function (filter) {
    return $.get({
        url: this.urlGetByName,
        data: { filter: filter }
    });
}; 

Movie.prototype.addToWishlist = function (movieId) {
    return $.post({
        url: this.urlAddToWishlist,
        data: { movieId: movieId }
    });
}; 

Movie.prototype.removeFromWishlist = function (movieId) {
    return $.post({
        url: this.urlRemoveFromWishlist,
        data: { movieId: movieId }
    });
}; 