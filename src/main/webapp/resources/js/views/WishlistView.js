"use strict";

function WishlistView(options) {
    options = options || {};
    this.ratingStars = options.ratingStars;
};

WishlistView.prototype.register = function (){
	this.ratingStars.rating({displayOnly: true, step: 0.1});
}
