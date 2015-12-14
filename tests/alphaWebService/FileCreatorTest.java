package alphaWebService;

import junit.framework.TestCase;
import org.junit.*;
import java.io.*;

/**
 * Created by sschwert on 12/13/2015.
 */
public class FileCreatorTest extends TestCase {
    String cssparam = "Y"; //"Y" or "N" or ""
    String frameworkparam = "bootstrap"; //"bootstrap" or "foundation"
    String scriptparam = "jForm"; //"js" or "jQuery" or "jForm"
    File newlyCreatedZipFile;

    CreateFiles newCreateFile = new CreateFiles();
    FileCreator newFileCreated = new FileCreator();
    String productZippedFolder = newCreateFile.getProductZippedFolder();
    File productFileFolder = newCreateFile.getProductFileFolder();


    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    @Test
    public void testRun() throws Exception {

        newFileCreated.run(cssparam, frameworkparam, scriptparam);

        newlyCreatedZipFile = new File(productZippedFolder);

        assertNotNull(newlyCreatedZipFile);

        System.out.println(cssparam + " " + frameworkparam + " " + scriptparam);
        System.out.println("Zip file: " + newlyCreatedZipFile);

    }

    public void testStartZipping() throws Exception {
        newFileCreated.startZipping();

    }

    public void testZipFolder() throws Exception {

    }

    public void testZipFile() throws Exception {

    }

    public void testSendToConsumer() throws Exception {

    }
}