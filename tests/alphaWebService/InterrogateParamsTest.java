package alphaWebService;

import junit.framework.TestCase;
import java.io.File;

/**
 * Created by sschwert on 12/13/2015.
 */
public class InterrogateParamsTest extends TestCase {

    private CreateFiles newCreateFiles = new CreateFiles();

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testInterrogateParams() throws Exception {
        File productIndexHTMLFile = newCreateFiles.getProductIndexHTMLFile();
        InterrogateParams newInterrogation = new InterrogateParams();
        newInterrogation.interrogateParams("Y", "bootstrap", "jForm");
        newInterrogation.writeIndexHTML();
        System.out.println("there's something here: " + productIndexHTMLFile);
        assertNotNull(productIndexHTMLFile);
    }

    public void testInterrogateCSSParams() throws Exception {

    }

    public void testWriteIndexHTML() throws Exception {

    }
}