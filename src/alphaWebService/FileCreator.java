package alphaWebService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.*;

/**
 * Created by Drakenstein on 11/16/2015.
 */
public class FileCreator {

//    String line = "";
//    Charset charset = StandardCharsets.UTF_8;

    //request params coming in from the URL query string; set here for development
    String cssparam = "Y"; //"Y" or "N" or ""
    String frameworkparam = "foundation"; //"bootstrap" or "foundation"
    String scriptparam = "jForm"; //"js" or "jQuery" or "jForm"

    //make paths tbd
    //Path indexHTMLFilePath = Paths.get("./src/resources/index.html");
    //Path productFolderPath = Paths.get("./src/templateWebSiteProduct");
    // Path productIndexFilePath = Paths.get(productFolder + "/index.html");

    //make files
    //---template boiler plate files
    String templateWebSiteBoilerString = "./src/resources/templateWebSiteBoiler";
    File indexHTMLFile = new File(templateWebSiteBoilerString + "/index.html");
    File cssFileFolder = new File(templateWebSiteBoilerString + "/css");
    File bootstrapFileFolder = new File(templateWebSiteBoilerString + "/assets/bootstrap");
    File foundationFileFolder = new File(templateWebSiteBoilerString + "/assets/foundation");
    File jsFileFolder = new File(templateWebSiteBoilerString + "/js");
    File jQueryFile = new File(templateWebSiteBoilerString + "/assets/jquery.js");
    File jQueryValidationFileFolder = new File(templateWebSiteBoilerString + "/assets/jquery-validation");

    //---product files
    String productFolderString = "./src/templateWebSiteProduct";
    File productFileFolder = new File("./src/templateWebSiteProduct");
    File productAssetFileFolder = new File(productFolderString + "/assets");



    public static void main(String[] args)
    {
        FileCreator app = new FileCreator();
        app.writeIndexHTML();
        app.interrogateParams();
    }


    //write a root file for the web site files
    public void writeIndexHTML()
    {
        makeDir(productFileFolder);
        copyFileToDir(indexHTMLFile, productFileFolder);
    }

    public void interrogateParams()
    {
        if (!cssparam.isEmpty() && cssparam.equals("Y"))
        {
            copyDirToDir(cssFileFolder,productFileFolder);
//TODO
//          add to script queue
        } //end cssparam


        if (!frameworkparam.isEmpty())
        {
            String key = frameworkparam; //"bootstrap" or "foundation"
            boolean boolBootstrap = false;
            boolean boolFoundation = false;

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
                copyDirToDir(bootstrapFileFolder,productAssetFileFolder);
//TODO
//                add bootstrap.js to script queue
//                add bootstrap.css to style queue

            }
            else if (boolFoundation)
            {
                copyDirToDir(foundationFileFolder,productAssetFileFolder);
//TODO
//                add bootstrap.js to script queue
//                add bootstrap.css to style queue
            }

        } //end frameworkparam

        if (!scriptparam.isEmpty())
        {
            String key = scriptparam; //"js" or "jQuery" or "jForm"
            boolean boolJS = false;
            boolean boolJQuery = false;
            boolean boolJForm = false;

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

            }
            else if (boolJQuery)
            {
                //add jQuery.js to assets directory
                copyFileToDir(jQueryFile, productAssetFileFolder);

                //add site.js to js directory
                copyDirToDir(jsFileFolder,productFileFolder);
//TODO
//                write onReady open to site.js
//                write onReady close to site.js

            }
            else if (boolJForm)
            {
                //add jQuery.js to assets directory
                copyFileToDir(jQueryFile, productAssetFileFolder);

                //add site.js to js directory
                copyDirToDir(jsFileFolder,productFileFolder);

                //add jQuery.validate to assets directory
                copyDirToDir(jQueryValidationFileFolder,productAssetFileFolder);
//TODO
//                write onReady open to site.js
//                write jQuery.validate instantiation to site.js
//                write onReady close to site.js

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

//TODO
    //configure index.html
    //zip up folder
    //send response of zip file
    //delete the files in project after sending the response
 /*   try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    deleteDir(productFileFolder); */



} //end


