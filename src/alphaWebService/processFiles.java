package alphaWebService;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by sschwert on 12/12/2015.
 */
public class ProcessFiles {

    /**
     * The ProcessFiles class houses the methods that will process the files, add them to a queue and print them
     * It does not create any of the files.  These methods are all called by the InterrogateParams method after it has
     * detemined which files should be processed based on the user input
     * @param read is a file to be read
     * @param queue is an arraylist of strings representing the content of many files
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
     * this method reads a queue and then writes a file from strings in the queue
     * @param queue is an arraylist of strings representing the content of many files
     * @param write is a file ready to be written to the new directory structure
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
     * this method reads an existing file and then prints a new file
     * @param read is the file in
     * @param write is the file out
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
     * this file copies and existing file to a new directory
     * @param srcFile this takes the written file, copies it, and puts it in the created directory
     * @param destDir this is the directory that is created that accepts the file
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
     * this method copies an existing directory to a new directory
     * @param srcDir this is the original directory that will be copied
     * @param destDir this is the destination directory that the srcDir is copied to
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
     * this method makes a new directory
     * @param dir is a file that represents the directory to be made
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
     * this method can delete a directory if we need it to, but is not currently used
     * @param dir is the directory to be deleted
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
     * this method can delete a file if we need it to, but is not currently used
     * @param file is the file to be deleted
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
