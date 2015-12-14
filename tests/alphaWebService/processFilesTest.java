package alphaWebService;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sschwert on 12/13/2015.
 */
public class processFilesTest extends TestCase {

    @Test
    public void testAddToQueue(File read, ArrayList<String> queue) throws IOException {
        FileReader fr = new FileReader(read);
        BufferedReader br = new BufferedReader(fr);
        String out;
        while((out = br.readLine()) != null) {
            queue.add(out);
        }
        fr.close();
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

    public void testDeleteDir() throws Exception {

    }

    public void testDeleteFile() throws Exception {

    }
}