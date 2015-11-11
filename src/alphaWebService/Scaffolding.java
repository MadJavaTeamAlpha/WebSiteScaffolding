package alphaWebService;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by Team Alpha on 11/10/2015.
 */
// The Java class will be hosted at the URI path "/scaffolding"
@Path("/scaffolding")
public class Scaffolding {

    //with url param
    // The Java method will process HTTP GET requests
    @GET
    @Path("/{webScaffoldingChoices}")
    @Produces("text/html")
    public String getMsg(@PathParam("webScaffoldingChoices") String msg) {
        String output = "<html><body><h1>Your File Here</h1></body></html> " + "You asked for: " + msg;
        return output;
    }


    //without url param
    // The Java method will process HTTP GET requests
    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "No parameters were passed.";
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/scaffolding");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
