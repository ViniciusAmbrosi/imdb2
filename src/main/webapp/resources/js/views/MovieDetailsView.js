"use strict";

function MovieDetailsView(options) {
    options = options || {};
    this.movie = new Movie({
    	urlAddToWishlist: options.urlAddToWishlist,
    	urlRemoveFromWishlist: options.urlRemoveFromWishlist
    });
    this.ratingStars = options.ratingStars,
    this.addWishlistButton = options.addWishlistButton
};

MovieDetailsView.prototype.register = function (){
	this.ratingStars.rating({displayOnly: true, step: 0.1});
	
	var $icon = this.addWishlistButton.children();
	
	this.addWishlistButton.click(function(){
		var self = this;
		if(this.addWishlistButton.is('.wishlist-added')){
			this.movie.removeFromWishlist(this.addWishlistButton.attr('data-id'))
			.done(function(res){
				self.addWishlistButton.trigger('mouseleave');
				self.addWishlistButton.removeClass('wishlist-added');
				self.addWishlistButton.addClass('save');
				$icon.removeClass('fa-check');
				$icon.addClass('fa-plus');
			})
			.fail(function(res){
				alert('Internal error, maybe you already removed this movie from your wishlist? Try again.');
			});
		}
		else{
			this.movie.addToWishlist(this.addWishlistButton.attr('data-id'))
			.done(function(res){
				self.addWishlistButton.removeClass('save');
				self.addWishlistButton.addClass('wishlist-added');
				$icon.removeClass('fa-plus');
				$icon.addClass('fa-check');
			})
			.fail(function(res){
				alert('Internal error, maybe you already have this movie in your wishlist? Try again.');
			});
		}
	}.bind(this));
	
	this.addWishlistButton.mouseenter(function(){
		if(this.addWishlistButton.is('.wishlist-added')){
			this.addWishlistButton.addClass('remove-from-wishlist');
			$icon.removeClass('fa-check');
			$icon.addClass('fa-minus');
		};
	}.bind(this));
	
	this.addWishlistButton.mouseleave(function(){
		if(this.addWishlistButton.is('.remove-from-wishlist')){
			this.addWishlistButton.removeClass('remove-from-wishlist');
			$icon.removeClass('fa-minus');
			$icon.addClass('fa-check');
		};
	}.bind(this));
}
