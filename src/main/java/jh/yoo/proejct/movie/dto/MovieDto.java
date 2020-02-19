package jh.yoo.proejct.movie.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieDto {

	private long id;
	
	@NotBlank(message = "required field")
	private int releaseYear;

	@NotBlank(message = "required field")
	private String title;
	
	@NotBlank(message = "required field")
	private int duration;
	
	@NotBlank(message = "required field")
	private String actor;
	
	@NotBlank(message = "required field")
	private String director;

	@Basic(optional = true)	//optional field
	private String genre;
	
	@Basic(optional = true)	//optional field
	private String country;
	
	@Basic(optional = true)	//optional field
	private String storyline;
}
