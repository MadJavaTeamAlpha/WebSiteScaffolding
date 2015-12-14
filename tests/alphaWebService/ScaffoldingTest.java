package alphaWebService;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import junit.framework.TestCase;
import org.junit.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.File;

/**
 * Created by sschwert on 12/13/2015.
 */
public class ScaffoldingTest extends TestCase  {


    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetMsg() throws Exception {

        Scaffolding newGetMsgTest = new Scaffolding();
        File newMsgFile = newGetMsgTest.getMsg("/{style}", "/{framework}", "{script}");
        assertNotNull(newMsgFile);
    }

    @Test
    public void testGetClichedMessage() throws Exception {
        Scaffolding newStringTest = new Scaffolding();
        String noParamsMessage = newStringTest.getClichedMessage();
        assertNotNull(noParamsMessage);
    }

    @Test
    public void testMain() throws Exception {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        assertNotNull(server);
    }

}