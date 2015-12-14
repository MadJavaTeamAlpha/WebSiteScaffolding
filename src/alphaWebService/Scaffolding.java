package alphaWebService;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.File;
import java.io.IOException;

/**
 * The Scaffolding class
 * Created by Team Alpha on 11/10/2015.
 * @author Jonathan Dedering
 */
// The Java class will be hosted at the URI path "/scaffolding"
@Path("/")
public class Scaffolding extends HttpServlet {

    /**
     * The getMsg method creates an html file with the user's selections
     * @param style is the css option selected by the user
     * @param framework is the framework option selected by the user
     * @param script are the javascript/jquery options selected by the user
     * @return output a String that contains a short html message that states the options the user has selected
     */
    @GET
    @Path("/{style}/{framework}/{script}")
    @Produces("text/html")
    public File getMsg(@PathParam("style") String style,@PathParam("framework") String framework,@PathParam("script") String script) throws IOException {
        String output = "<html><body><p>Style: " + style + "</p> <p>Framework: " + framework + "</p> <p>Script: " + script + "</p></body></html>";
        FileCreator creator = new FileCreator();
        File outputFile = creator.run(style, framework, script);

        return outputFile;
    }


    /**
     * the method getClichedMessage returns a message if no parameters were passed in the url
     * @return a String message that no parameters were passed
     */
    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        String noParamsMessage = "No parameters were passed.";
        return noParamsMessage;
    }


    /**
     * This is the main method and is the entrance point for the program
     * @param args
     * @throws IOException
     */
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
