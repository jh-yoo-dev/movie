package jh.yoo.proejct.movie;

import org.jdbi.v3.core.Jdbi;
import org.junit.Before;

import io.dropwizard.jdbi3.JdbiFactory;
import jh.yoo.project.movie.dao.MovieDao;
import jh.yoo.project.movie.resource.MovieResource;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Josh
 * Unit test for simple App.
 */
public class ApplicationTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ApplicationTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ApplicationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
