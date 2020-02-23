package jh.yoo.project.movie.dao;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import jh.yoo.proejct.movie.dto.MovieMapper;
import jh.yoo.proejct.movie.model.entity.Movie;

public interface MovieDao {
	 @SqlUpdate("create table movie (id int primary key, releaseYear int," +
			 "title varchar(100), duration int, actor varchar(128), " +
			 "director varchar(128), genre varchar(64), country varchar(64)," +
			 "storyline varchar(256), production varchar(128))") 
	 void createTable();

	 @SqlUpdate("insert into movie (id, releaseYear, title, duration, actor, director) " +
	 "values (:id, :releaseYear, :title, :duration, :actor, :director)")
	 void insert(@Bind("id")int id, @Bind("releaseYear") int releaseYear, @Bind("title")String title, @Bind("duration")int duration, @Bind("actor")String actor, @Bind("director")String director);
			 
	 @SqlUpdate("update movie set (releaseYear, title, duration, actor,director,genre,country, storyline,production) " +
	 "= (:releaseYear, :title, :duration, :actor, :director, :genre, :country, :storyline, :production) where "
	 + "id = :id")
	 void update(@Bind("id")int id, @Bind("releaseYear") int releaseYear, @Bind("title")String title, @Bind("duration")int duration, @Bind("actor")String actor,
			 @Bind("director")String director, @Bind("genre")String genre, @Bind("country")String country, @Bind("storyline")String storyline, @Bind("production")String production);
			
	 
	 @SqlQuery("select * from movie where id = :id")
	 @RegisterRowMapper(MovieMapper.class)
	 Optional<Movie> findMovie(@Bind("id") int id);
	 
	 @SqlQuery("select * from movie")
	 @RegisterRowMapper(MovieMapper.class)
	 List<Movie> list();
	 
	 @SqlQuery("select * from movie where releaseYear = :releaseYear order by releaseYear desc")
	 @RegisterRowMapper(MovieMapper.class)
	 List<Movie> listByReleaseYear(@Bind("releaseYear")int releaseYear);
	 
	 @SqlQuery("select * from movie where duration = :duration order by duration desc")
	 @RegisterRowMapper(MovieMapper.class)
	 List<Movie> listByDuration(@Bind("duration")int duration);
	 
	 @SqlQuery("select * from movie where actor LIKE :actor order by actor desc")
	 @RegisterRowMapper(MovieMapper.class)
	 List<Movie> listByActor(@Bind("actor")String actor);
	 
	 @SqlUpdate("delete from movie where id = :id")
	 void delete(@Bind("id") int id);
}
