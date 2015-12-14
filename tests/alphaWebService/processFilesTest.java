package alphaWebService;

import junit.framework.TestCase;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sschwert on 12/13/2015.
 */
public class ProcessFilesTest extends TestCase {

    ArrayList<String> queue = new ArrayList<>();
    CreateFiles newCreateFile = new CreateFiles();
    ProcessFiles newProcessFiles = new ProcessFiles();


    @Before
    public void setup() throws IOException {

    }

    @Test
    public void testAddToQueue() throws IOException {
        File jquery = newCreateFile.getjQueryFile();
        File css = newCreateFile.getRefStyleCSS();
        newProcessFiles.addToQueue(jquery, queue);
        newProcessFiles.addToQueue(css, queue);
        String newTestMessage = "There's something to in the queue: size = " + queue.size();
        assertNotNull(jquery);
        assertTrue(queue.size() > 0);
        System.out.println(newTestMessage);
    }

    public void testPrintQueue() throws Exception {

    }

    public void testPrintToFile() throws Exception {

    }

    public void testCopyFileToDir() throws Exception {

    }

    public void testCopyDirToDir() throws Exception {

    }

    public void testMakeDir() throws Exception {

    }

}