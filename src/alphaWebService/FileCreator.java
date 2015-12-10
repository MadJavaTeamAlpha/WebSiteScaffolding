package alphaWebService;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Drakenstein on 11/16/2015.
 */
public class FileCreator {

    File newlyCreatedZipFile;

//    String line = "";
//    Charset charset = StandardCharsets.UTF_8;

    //request params coming in from the URL query string; set here for development
    private String cssparam = ""; //"Y" or "N" or ""
    private String frameworkparam = ""; //"bootstrap" or "foundation"
    private String scriptparam = ""; //"js" or "jQuery" or "jForm"

    private boolean boolBootstrap;
    private boolean boolFoundation;

    private boolean boolJS;
    private boolean boolJQuery;
    private boolean boolJForm;

    //make paths tbd
    //Path indexHTMLFilePath = Paths.get("./src/resources/index.html");
    //Path productFolderPath = Paths.get("./src/templateWebSiteProduct");
    // Path productIndexFilePath = Paths.get(productFolder + "/index.html");

    //make files
    //---template boiler plate files
    private String templateWebSiteBoilerString = "./src/resources/templateWebSiteBoiler";
    private File indexHTMLFile = new File(templateWebSiteBoilerString + "/index.html");
    private File cssFileFolder = new File(templateWebSiteBoilerString + "/css");
    private File bootstrapFileFolder = new File(templateWebSiteBoilerString + "/assets/bootstrap");
    private File foundationFileFolder = new File(templateWebSiteBoilerString + "/assets/foundation");
    private File jsFileFolder = new File(templateWebSiteBoilerString + "/js");
    private File jQueryFile = new File(templateWebSiteBoilerString + "/assets/jquery.js");
    private File jQueryValidationFileFolder = new File(templateWebSiteBoilerString + "/assets/jquery-validation");

    //---product files to send to consumer
    private String productFolderString = "./src/templateWebSiteProduct";
    private File productFileFolder = new File(productFolderString);
    private File productAssetFileFolder = new File(productFolderString + "/assets");
    private String productZippedFolder = "./src/templateWebSiteProduct.zip";

    //---product index.html
    private File productIndexHTMLFile = new File(productFolderString + "/index.html");

    //---product /js/site.js
    private File productSiteJSFile = new File(productFolderString + "/js/site.js");

    //---product /css/style.css
    private File productSiteCSSStyle = new File(productFolderString + "/css/style.css");

    //---code segments: jQuery
    private File segmentOnReadyOpen = new File(templateWebSiteBoilerString + "/segments/jquery_onready_open.txt");
    private File segmentOnReadyClose = new File(templateWebSiteBoilerString + "/segments/jquery_onready_close.txt");

    //---code segments: jQuery Validate
    private File segmentValidateJS = new File(templateWebSiteBoilerString + "/segments/jquery_validate.txt");

    //---code segments: CSS Nav Bar
    private File segmentCSSNavStyle = new File(templateWebSiteBoilerString + "/segments/nav_style.txt");

    //--- code segment: Index.html
    private File segmentOpenHead = new File(templateWebSiteBoilerString + "/segments/open_head.txt");
    private File segmentNavOpen = new File(templateWebSiteBoilerString + "/segments/nav_open.txt");
    private File segmentNavHtml = new File(templateWebSiteBoilerString + "/segments/nav_html.txt");
    private File segmentNavClose = new File(templateWebSiteBoilerString + "/segments/nav_close.txt");

    private File segmentCloseHeadOpenBody = new File(templateWebSiteBoilerString + "/segments/close_head_open_body.txt");

    private File segmentHelloWorld = new File(templateWebSiteBoilerString + "/segments/hello_world_html.txt");

    private File segmentFoundationOpen = new File(templateWebSiteBoilerString + "/segments/foundation_open_html.txt");
    private File segmentFoundationClose = new File(templateWebSiteBoilerString + "/segments/foundation_close_html.txt");

    private File segmentJForm = new File(templateWebSiteBoilerString + "/segments/jform_html.txt");

    private File segmentBootstrapOpen = new File(templateWebSiteBoilerString + "/segments/bootstrap_open_html.txt");
    private File segmentBootstrapClose = new File(templateWebSiteBoilerString + "/segments/bootstrap_close_html.txt");

    private File segmentCloseBody = new File(templateWebSiteBoilerString + "/segments/close_body.txt");



    // Queues

    //---style queue
    ArrayList<String> styleQueue = new ArrayList<>();

    //---script queue
    ArrayList<String> scriptQueue = new ArrayList<>();

    // Site Style Reference
    private File refStyleCss = new File(templateWebSiteBoilerString + "/segments/style_queue_style_css.txt");

    // Site Script Reference
    private File refSiteJS = new File(templateWebSiteBoilerString + "/segments/script_queue_site_js.txt");

    // jQuery Reference
    private File refJQueryJS = new File(templateWebSiteBoilerString + "/segments/script_queue_jquery.txt");

    // Bootstrap References
    private File refBootstrapCss = new File(templateWebSiteBoilerString + "/segments/style_queue_bootstrap.txt");
    private File refBootstrapJS = new File(templateWebSiteBoilerString + "/segments/script_queue_bootstrap.txt");

    // Foundation References
    private File refFoundationCss = new File(templateWebSiteBoilerString + "/segments/style_queue_foundation.txt");
    private File refFoundationJS = new File(templateWebSiteBoilerString + "/segments/script_queue_foundation.txt");

    // jQuery Validate References
    private File refJQueryValidateJS = new File(templateWebSiteBoilerString + "/segments/script_queue_jquery_validate.txt");

    public File run(String css, String framework, String jForm) throws IOException {

        cssparam = css; //"Y" or "N" or ""
        frameworkparam = framework; //"bootstrap" or "foundation"
        scriptparam = jForm; //"js" or "jQuery" or "jForm"
        System.out.println(cssparam + " " + frameworkparam + " " + scriptparam);

       // FileCreator fileCreator = new FileCreator();

        interrogateParams();
        writeIndexHTML();
        startZipping();
        sendToConsumer();
        return newlyCreatedZipFile;
       // Scaffolding download = new Scaffolding();
     //  download.fileDownload(newlyCreatedZipFile);

    }
/*
    public static void main(String[] args) throws IOException {

        FileCreator fileCreator = new FileCreator();
        fileCreator.interrogateParams();
        fileCreator.writeIndexHTML();
        fileCreator.startZipping();
        fileCreator.sendToConsumer();
    }
*/

    //write a root file for the web site files
    public void writeIndexHTML() throws IOException {

        makeDir(productFileFolder);

        copyFileToDir(indexHTMLFile, productFileFolder);

        /* Head */

        printToFile(segmentOpenHead, productIndexHTMLFile);


        printQueue(styleQueue, productIndexHTMLFile);


        printToFile(segmentCloseHeadOpenBody, productIndexHTMLFile);

        /* Nav */
        printToFile(segmentNavOpen, productIndexHTMLFile);

        if (boolBootstrap) {
            printToFile(segmentBootstrapOpen, productIndexHTMLFile);
        }

        if (boolFoundation) {
            printToFile(segmentFoundationOpen, productIndexHTMLFile);
        }

        printToFile(segmentNavHtml, productIndexHTMLFile);

        if (boolBootstrap) {
            printToFile(segmentBootstrapClose, productIndexHTMLFile);
        }

        if (boolFoundation) {
            printToFile(segmentFoundationClose, productIndexHTMLFile);
        }

        printToFile(segmentNavClose, productIndexHTMLFile);

        /* Content */
        if (boolBootstrap) {
            printToFile(segmentBootstrapOpen, productIndexHTMLFile);
        }

        if (boolFoundation) {
            printToFile(segmentFoundationOpen, productIndexHTMLFile);
        }

        /* Hello World */
        printToFile(segmentHelloWorld, productIndexHTMLFile);

        /* JForm */
        if (boolJForm) {
            printToFile(segmentJForm, productIndexHTMLFile);
        }

        if (boolBootstrap) {
            printToFile(segmentBootstrapClose, productIndexHTMLFile);
        }

        if (boolFoundation) {
            printToFile(segmentFoundationClose, productIndexHTMLFile);
        }

        printQueue(scriptQueue, productIndexHTMLFile);


        printToFile(segmentCloseBody, productIndexHTMLFile);


    }

    public void interrogateParams() throws IOException {
        if (!cssparam.isEmpty() && cssparam.equals("Y"))
        {
            copyDirToDir(cssFileFolder, productFileFolder);

            // add nav style to /css/style.css
            printToFile(segmentCSSNavStyle, productSiteCSSStyle);

            // add nav style reference to style queue
            addToQueue(refStyleCss, styleQueue);


        } //end cssparam


        if (!frameworkparam.isEmpty())
        {
            String key = frameworkparam; //"bootstrap" or "foundation"


            switch (key)
            {
                case "bootstrap":
                    boolBootstrap = true;
                    break;
                case "foundation":
                    boolFoundation = true;
                    break;
            }

            //make the assets directory
            makeDir(productAssetFileFolder);

            if (boolBootstrap)
            {
                //FYI in IntelliJ Project Window it might look like this: assets.bootstrap (= assets/bootstrap/)
                copyDirToDir(bootstrapFileFolder, productAssetFileFolder);

                // add bootstrap.css to style queue
                addToQueue(refBootstrapCss, styleQueue);

                // add bootstrap.js to script queue
                addToQueue(refBootstrapJS, scriptQueue);

            }
            else if (boolFoundation)
            {
                copyDirToDir(foundationFileFolder, productAssetFileFolder);

                // add foundation.css to style queue
                addToQueue(refFoundationCss, styleQueue);

                // add foundation.js to script queue
                addToQueue(refFoundationJS, scriptQueue);


            }

        } //end frameworkparam

        if (!scriptparam.isEmpty())
        {
            String key = scriptparam; //"js" or "jQuery" or "jForm"


            switch (key)
            {
                case "js":
                    boolJS = true;
                    break;
                case "jQuery":
                    boolJQuery = true;
                    break;
                case "jForm":
                    boolJForm = true;
                    break;
            }

            if (boolJS)
            {
                copyDirToDir(jsFileFolder,productFileFolder);

                // add site.js to script queue
                addToQueue(refSiteJS, scriptQueue);

            }
            else if (boolJQuery)
            {
                //add jQuery.js to assets directory
                copyFileToDir(jQueryFile, productAssetFileFolder);

                //add site.js to js directory
                copyDirToDir(jsFileFolder, productFileFolder);

                // write onReady open to site.js
                printToFile(segmentOnReadyOpen, productSiteJSFile);

                // write onReady close to site.js
                printToFile(segmentOnReadyClose, productSiteJSFile);

                // add jquery.js to script queue
                addToQueue(refJQueryJS, scriptQueue);

                // add site.js to script queue
                addToQueue(refSiteJS, scriptQueue);


            }
            else if (boolJForm)
            {
                //add jQuery.js to assets directory
                copyFileToDir(jQueryFile, productAssetFileFolder);

                //add site.js to js directory
                copyDirToDir(jsFileFolder, productFileFolder);

                //add jQuery.validate to assets directory
                copyDirToDir(jQueryValidationFileFolder, productAssetFileFolder);

                // write onReady open to site.js
                printToFile(segmentOnReadyOpen, productSiteJSFile);

                // write jQuery.validate instantiation to site.js
                printToFile(segmentValidateJS, productSiteJSFile);

                // write onReady close to site.js
                printToFile(segmentOnReadyClose, productSiteJSFile);

                // add jquery.js to script queue
                addToQueue(refJQueryJS, scriptQueue);

                // add jquery.validate.js to script queue
                addToQueue(refJQueryValidateJS, scriptQueue);

                // add site.js to script queue
                addToQueue(refSiteJS, scriptQueue);



            }
        } //end scriptparam



/*
    PAGE
write doctype
Write open head
write blank meta tags
write blank title
write style que
write close head
write open body
Write H1 Hello World
If (framework)
	write row/col open
If (jform)
	write form
If (framework)
	write row/col close
Print out script queue
write close body
Write close html





    public void readFileOrFolderAndWriteToTemplateFolder()
    {

        try (BufferedReader reader = Files.newBufferedReader(inputFile, charset))
        {
            while ((line = reader.readLine()) != null)  //each line
            {
                //String content = new String(Files.readAllBytes(inputFile), charset); //reading the entire file at once
                //content = content.replaceAll("verifyText", "verifyElementPresent");
                //Files.write(outputFile, content.getBytes(charset));

                Files.write(outputFile, line.getBytes(charset));
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Unable to find the file: fileName");
        }
        catch (IOException e)
        {
            System.err.println("Unable to read the file: fileName");
        }
    }
    */


    } //end interrogateParams()


    // Add to queue arraylists
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
//TODO
    //configure index.html



    /*
     * This code was pulled from http://examples.javacodegeeks.com/core-java/util/zip/zipoutputstream/java-zip-file-example/
     *
     */
    public void startZipping() {
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

        String myname = parentName +inputFile.getName()+"\\";

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

    public void sendToConsumer()
    {
        //send response of zip file
         newlyCreatedZipFile = new File(productZippedFolder);

//TODO
        //some code here ?


        //delete the files in project after sending the response
        //error on deleting site.js file??
//        deleteDir(productFileFolder);
//        deleteFile(newlyCreatedZipFile);

    }


} //end class


