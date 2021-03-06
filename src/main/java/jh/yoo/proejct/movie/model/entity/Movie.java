package jh.yoo.proejct.movie.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Movie {
    @Id
    @Column
	private int id;
	
    @Column(length=4, nullable = false)
	private int releaseYear;

    @Column(length=256, nullable = false)
	private String title;
	
    @Column(length=16, nullable = false)
	private int duration;
	
	@Column(length=128, nullable = false)
	private String actor;
	
	@Column(length=128, nullable = false)
	private String director;
	
	@Column(length=64, nullable = true)
	private String genre;
	
	@Column(length=64, nullable = true)
	private String country;
	
	@Column(length=256, nullable = true)
	private String storyline;
	
	@Column(length=128, nullable = true)
	private String production;
}
