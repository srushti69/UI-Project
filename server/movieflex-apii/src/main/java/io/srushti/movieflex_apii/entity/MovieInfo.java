package io.srushti.movieflex_apii.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name="Movie.findALL",query="SELECT m FROM MovieInfo m ORDER BY m.movie_name ASC"),
		@NamedQuery	(name="Movie.findbyName",query="SELECT m FROM MovieInfo m WHERE m.movie_name=:mName")
})
public class MovieInfo {
	
	@Id
	private String imdbId;
	@Column(unique=true)
	private String movie_name;
	private String director;
	private String writer;
	private String imdbRate;
	private String release_year;
	private String release_date;
	//private Comment comment;
	
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getImdbRate() {
		return imdbRate;
	}
	public void setImdbRate(String imdbRate) {
		this.imdbRate = imdbRate;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public MovieInfo(){
		this.imdbId = UUID.randomUUID().toString();
	}

}
