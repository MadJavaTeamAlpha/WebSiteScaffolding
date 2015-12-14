package alphaWebService;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by sschwert on 12/12/2015.
 */
public class ProcessFiles {

    /**
     *
     * @param read
     * @param queue
     * @throws IOException
     */
    public void addToQueue(File read, ArrayList<String> queue) throws IOException {

        FileReader fr = new FileReader(read);
        BufferedReader br = new BufferedReader(fr);
        String out;
        while((out = br.readLine()) != null) {
            queue.add(out);
        }
        fr.close();

    }

    // Read file, print file

    /**
     *
     * @param queue
     * @param write
     * @throws IOException
     */
    public void printQueue(ArrayList<String> queue, File write) throws IOException {

        for (String out : queue) {

            PrintWriter fw;
            try {
                fw = new PrintWriter(new FileOutputStream(write, true));
                fw.write(String.format("%s", out));
                fw.write(System.lineSeparator()); //new line
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Read file, print file

    /**
     *
     * @param read
     * @param write
     * @throws IOException
     */
    public void printToFile(File read, File write) throws IOException {

        FileReader fr = new FileReader(read);
        BufferedReader br = new BufferedReader(fr);
        String out;
        while((out = br.readLine()) != null) {
            PrintWriter fw;
            try {
                fw = new PrintWriter(new FileOutputStream(write,true));
                fw.write(String.format("%s",out));
                fw.write(System.lineSeparator()); //new line
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        fr.close();


    }

    /**
     *
     * @param srcFile
     * @param destDir
     */
    public void copyFileToDir(File srcFile, File destDir)
    {
        try
        {
            FileUtils.copyFileToDirectory(srcFile, destDir);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param srcDir
     * @param destDir
     */
    public void copyDirToDir(File srcDir, File destDir)
    {
        try
        {
            FileUtils.copyDirectoryToDirectory(srcDir, destDir);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dir
     */
    public void makeDir(File dir)
    {
        try
        {
            FileUtils.forceMkdir(dir);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dir
     */
    public void deleteDir(File dir)
    {
        try
        {
            FileUtils.deleteDirectory(dir);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param file
     */
    public void deleteFile(File file)
    {
        try
        {
            FileUtils.forceDelete(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
