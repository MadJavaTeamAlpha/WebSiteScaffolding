package alphaWebService;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class requests params from the URL query string and uses them to create a zipped directory folder for a
 * basic website based on the user's selections
 * It contains instance variables for each option available to the user
 * It instantiates a number of file objects that represent different pieces of each file
 *
 * Created by Drakenstein on 11/16/2015.
 * @author Debbie Hafenstein
 */
public class FileCreator {

    ProcessFiles newProcessFile = new ProcessFiles();
    CreateFiles newCreateFile = new CreateFiles();
    File newlyCreatedZipFile;

    // ---  CREATE PROCESSING QUEUES---//




    /**
     * The run method calls all of the action methods and is called by the main method
     */
    public File run(String css, String framework, String script) throws IOException {

        //request params coming in from the URL query string; set here for development
        String cssparam = ""; //"Y" or "N" or ""
        String frameworkparam = ""; //"bootstrap" or "foundation"
        String scriptparam = ""; //"js" or "jQuery" or "jForm"

        cssparam = css; //"Y" or "N" or ""
        frameworkparam = framework; //"bootstrap" or "foundation"
        scriptparam = script; //"js" or "jQuery" or "jForm"
        System.out.println(cssparam + " " + frameworkparam + " " + scriptparam);

        // FileCreator fileCreator = new FileCreator();
        InterrogateParams newInterrogation = new InterrogateParams();
        newInterrogation.interrogateParams(css, framework, script);
        newInterrogation.writeIndexHTML();

        startZipping();
        sendToConsumer();
        return newlyCreatedZipFile;

    }



    /*
     * This code was pulled from http://examples.javacodegeeks.com/core-java/util/zip/zipoutputstream/java-zip-file-example/
     *
     */
    public void startZipping() {
        File productFileFolder = newCreateFile.getProductFileFolder();
        String productZippedFolder = newCreateFile.getProductZippedFolder();

        try {
            FileOutputStream fileOutputStream = null;

            File inputFile = productFileFolder;
            fileOutputStream = new FileOutputStream(productZippedFolder);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

            if (inputFile.isFile())
                zipFile(inputFile,"",zipOutputStream);
            else if (inputFile.isDirectory())
                zipFolder(zipOutputStream,inputFile,"");

            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zipFolder(ZipOutputStream zipOutputStream,File inputFile, String parentName)  throws IOException {

        String myname = parentName + inputFile.getName()+"\\";

        ZipEntry folderZipEntry = new ZipEntry(myname);
        zipOutputStream.putNextEntry(folderZipEntry);

        File[] contents = inputFile.listFiles();

        for (File f : contents){
            if (f.isFile())
                zipFile(f,myname,zipOutputStream);
            else if(f.isDirectory())
                zipFolder(zipOutputStream,f, myname);
        }
        zipOutputStream.closeEntry();
    }

    public void zipFile(File inputFile,String parentName,ZipOutputStream zipOutputStream) throws IOException{

        // A ZipEntry represents a file entry in the zip archive
        // We name the ZipEntry after the original file's name
        ZipEntry zipEntry = new ZipEntry(parentName+inputFile.getName());
        zipOutputStream.putNextEntry(zipEntry);

        FileInputStream fileInputStream = new FileInputStream(inputFile);
        byte[] buf = new byte[1024];
        int bytesRead;

        // Read the input file by chucks of 1024 bytes
        // and write the read bytes to the zip stream
        while ((bytesRead = fileInputStream.read(buf)) > 0) {
            zipOutputStream.write(buf, 0, bytesRead);
        }

        // close ZipEntry to store the stream to the file
        zipOutputStream.closeEntry();


    }

    public void sendToConsumer() {
        String productZippedFolder = newCreateFile.getProductZippedFolder();
        //send response of zip file
        newlyCreatedZipFile = new File(productZippedFolder);


    }


} //end class


