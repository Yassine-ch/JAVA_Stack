package com.yassine.lookify.models;

import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="playlists")
public class Lookify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max=200 ,message = "Song name must be at least 5 characters")
	private String songName;
	
	@NotNull
	@Size(min=5, max=200, message ="Artist name must be at least 5 characters")
	private String artist;
	
	@NotNull
	@Min(value = 1,message ="Rating must be at least 1")
	@Max(value=10, message= "Rating must be smaller than 10")
	private Integer rating;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Lookify() {}
    public Lookify(String songName,String artist, Integer rating) {
    	this.songName = songName;
    	this.artist = artist;
    	this.rating = rating;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
    
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    

}
