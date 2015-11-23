package alphaWebService;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;
/**
 * Created by Team Alpha on 11/10/2015.
 */
// The Java class will be hosted at the URI path "/scaffolding"
@Path("/")
public class Scaffolding {

    //with url param
    // The Java method will process HTTP GET requests
    @GET
    @Path("/{style}/{framework}/{script}")
    @Produces("text/html")
    public String getMsg(@PathParam("style") String style,@PathParam("framework") String framework,@PathParam("script") String script) {
        String output = "<html><body><p>Style: " + style + "</p> <p>Framework: " + framework + "</p> <p>Script: " + script + "</p></body></html>";



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
        System.out.println("Visit: http://localhost:9998/");
        System.out.println("Paths: /{style}/{framework}/{script}");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
