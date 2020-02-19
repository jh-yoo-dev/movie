package jh.yoo.proejct.movie;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import jh.yoo.proejct.movie.config.MovieConfiguration;
import jh.yoo.project.movie.resource.MovieResource;

/**
 * @author Josh
 * Getting started page in https://www.dropwizard.io/en/stable/getting-started.html
 */
public class MovieApplication extends Application<MovieConfiguration>
{
    public static void main( String[] args ) throws Exception
    {
//    	System.out.println( "Hello World!" );
    	new MovieApplication().run(args);
        
    }

	@Override
	public void run(MovieConfiguration configuration, Environment environment) throws Exception {
		MovieResource movieResource = new MovieResource();
		environment.jersey().register(movieResource);
	}
	
	@Override
	public void initialize(Bootstrap<MovieConfiguration> bootStrap) {
		super.initialize(bootStrap);
	}
}
