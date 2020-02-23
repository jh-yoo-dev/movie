package jh.yoo.proejct.movie.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Basic;
import javax.validation.constraints.NotBlank;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import jh.yoo.proejct.movie.model.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieMapper implements RowMapper<Movie>{

	private int id;
	
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
	
	@Basic(optional = true) //optional field
	private String production;

	@Override
	public Movie map(ResultSet rs, StatementContext ctx) throws SQLException {
		Movie movie = new Movie();
		movie.setId(rs.getInt("id"));
		movie.setActor(rs.getString("actor"));
		movie.setCountry(rs.getString("country"));
		movie.setDirector(rs.getString("director"));
		movie.setDuration(rs.getInt("duration"));
		movie.setGenre(rs.getString("genre"));
		movie.setProduction(rs.getString("production"));
		movie.setReleaseYear(rs.getInt("releaseYear"));
		movie.setStoryline(rs.getString("storyline"));
		movie.setTitle(rs.getString("title"));
		
		return movie;
	}
}
