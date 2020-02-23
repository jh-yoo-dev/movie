package jh.yoo.project.movie.resource;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jh.yoo.proejct.movie.dto.MovieMapper;
import jh.yoo.proejct.movie.model.entity.Movie;
import jh.yoo.project.movie.dao.MovieDao;

/**
 * @author Josh
 */
@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
	public MovieDao movieDao;
    
	public MovieResource(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@GET
	public List<Movie> read() {
		return movieDao.list();
	}
	
	@GET
	@Path("/release/{releaseYear}")
	public List<Movie> readByReleaseYear(@PathParam("releaseYear")int releaseYear) {
		return movieDao.listByReleaseYear(releaseYear);
	}
	
	@GET
	@Path("/duration/{duration}")
	public List<Movie> readByDuration(@PathParam("duration")int duration) {
		return movieDao.listByDuration(duration);
	}
	
	@GET
	@Path("/actor/{actor}")
	public List<Movie> readByActor(@PathParam("actor")String actor) {
		return movieDao.listByActor(actor);
	}
	
	@POST
	public void create(MovieMapper movieDto) {
		movieDao.insert(movieDto.getId(), movieDto.getReleaseYear(), movieDto.getTitle(), movieDto.getDuration(), movieDto.getActor(), movieDto.getDirector());
	}
	
	@PUT
	public void update(MovieMapper movieDto) {
		movieDao.update(movieDto.getId(), movieDto.getReleaseYear(), movieDto.getTitle(), movieDto.getDuration(), movieDto.getActor(),movieDto.getDirector(), movieDto.getGenre(), movieDto.getCountry(), movieDto.getStoryline(), movieDto.getProduction());
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		movieDao.delete(id);
	}
	
	@GET
	@Path("/{id}")
	public Optional<Movie> search(@PathParam("id") int id){
		Optional<Movie> result = movieDao.findMovie(id);
		if(result.isPresent()) {
			return result; 
		}
		return null;
	}
}
