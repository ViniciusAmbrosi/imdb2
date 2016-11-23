"use strict";

function HomeView(options) {
    options = options || {};
    this.movie = new Movie({
    	urlGetByName: options.urlGetByName
    });
    this.filterInput = options.filterInput,
    this.ratingStars = options.ratingStars,
    this.movieDisplay = options.movieDisplay;
};

HomeView.prototype.register = function (){
	this.ratingStars.rating({displayOnly: true, step: 0.1});
	
	this.filterInput.keyup(function() {
		var self = this;
	    delay(function(){
	    	self.movie.filterByName(self.filterInput.val()).done(function (res) {
	    		self.movieDisplay.empty();
	    		self.movieDisplay.append(res);
	    	});;
		}, 1500 );
	}.bind(this));
}

var delay = (function(){
  var timer = 0;
  return function(callback, ms){
    clearTimeout(timer);
    timer = setTimeout(callback, ms);
  };
})();