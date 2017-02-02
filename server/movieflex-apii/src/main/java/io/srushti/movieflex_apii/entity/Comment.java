package io.srushti.movieflex_apii.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Comment {
	
	@Id
	private String cmt_id;
	@ManyToOne
	private User user;
	@ManyToOne
	private MovieInfo movieInfo;
	private String cmts;
	public Comment(){
		this.cmt_id = UUID.randomUUID().toString();
	}
	public String getCmt_id() {
		return cmt_id;
	}
	public void setCmt_id(String cmt_id) {
		this.cmt_id = cmt_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MovieInfo getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}
	public String getCmts() {
		return cmts;
	}
	public void setCmts(String cmts) {
		this.cmts = cmts;
	}

}
