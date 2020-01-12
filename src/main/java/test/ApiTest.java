package test;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rikesh.puri.fibonacci.Factory;
import rikesh.puri.fibonacci.Service;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

public class ApiTest extends JerseyTest {
	
	public static final URI BASE_URI = UriBuilder.fromUri("http://localhost").port(8080).build();
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {

        ResourceConfig rc = new ResourceConfig(Service.class);
        server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);

        server.start();
        Client c = ClientBuilder.newClient();
        target = ClientBuilder.newClient().target("http://localhost:8080/fibonacci").path("/");
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(ApiTest.class);
    }

    @Test
    public void nextTest() {
        String response = target("/next").request().get(String.class);
        Assert.assertTrue("Next fibonacci number is 1".equals(response));
    }

    @Test
    public void currentTest() {
        String response = target("/current").request().get(String.class);
        Assert.assertTrue("Current fibonacci number is 1".equals(response));
    }
    
    @Test
    public void previousTest() {
        String response = target("/previous").request().get(String.class);
        Assert.assertTrue("Previous fibonacci number is 0".equals(response));
    }
    
    @Test
    public void fiboTest() {
    	Assert.assertTrue(Factory.getFib(10) == 55);
    }
}
