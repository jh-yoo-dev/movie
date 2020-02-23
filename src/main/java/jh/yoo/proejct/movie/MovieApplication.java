package jh.yoo.proejct.movie;

import org.jdbi.v3.core.Jdbi;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import jh.yoo.proejct.movie.config.MovieConfiguration;
import jh.yoo.project.movie.dao.MovieDao;
import jh.yoo.project.movie.resource.MovieResource;

/**
 * @author Josh
 * Getting started page in https://www.dropwizard.io/en/stable/getting-started.html
 */
public class MovieApplication extends Application<MovieConfiguration>
{
    public static void main(String[] args) throws Exception {
        new MovieApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MovieConfiguration> bootstrap) {
    }

	@Override
	public void run(MovieConfiguration configuration, Environment environment) throws Exception {
	    final JdbiFactory factory = new JdbiFactory();
	    final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
	    
	    final MovieDao movieDao = jdbi.onDemand(MovieDao.class);
	    movieDao.createTable();
	    MovieResource resource = new MovieResource(movieDao);
	    environment.jersey().register(resource);
	}
}
