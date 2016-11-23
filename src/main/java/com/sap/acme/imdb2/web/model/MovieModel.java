package com.sap.acme.imdb2.web.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


public class MovieModel implements Serializable{

	private static final long serialVersionUID = -7131776380618643064L;
	
	private Long id;

	@NotNull(message="The title field is mandatory.")
	@Size(min = 5, max = 30, message= "The tile must have at least 5 characters and less than 30.")
	private String title;

	@NotNull(message="The release date field is mandatory.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate releaseDate;
	
	@NotNull
	@Size(min = 10, max = 250, message= "The synopsis must have at least 10 characters and less then 250.")
	private String synopsis;
	
	@NotNull(message="The Length field is mandatory.")
	@Min(0)
	private double length;
	
	private MultipartFile thumbnail;
	
	private String thumbnailPath;
	
	@NotNull(message="The rating field is mandatory.")
	@Min(0)
	@Max(5)
	private double rating;
	
	@NotNull(message="The genres field is mandatory")
	private List<Long> genres;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public MultipartFile getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public  List<Long> getGenres() {
		return genres;
	}

	public void setGenres( List<Long> genres) {
		this.genres = genres;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
}
