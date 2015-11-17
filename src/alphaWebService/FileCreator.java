package alphaWebService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Drakenstein on 11/16/2015.
 */
public class FileCreator {

    String line = "";
    Path inputFile = Paths.get("C:\\Users\\Drakenstein\\Documents\\GitHub\\myInputFile.txt");
    Path outputFile = Paths.get("C:\\Users\\Drakenstein\\Documents\\GitHub\\myOutputFile.txt");
    Charset charset = StandardCharsets.UTF_8;

    String cssparam;
    String frameworkparam;
    String scriptparam;

    String styleFile = "Style.css";
    String bootstrapFile = "Bootstrap.css";
    String foundationFile = "Foundation.css";
    String jsFile = "Site.js";
    String jQueryFile = "Jquery.js";
    String jQueryValidateFile = "Jquery.validate.js";


    public void interrogateParams()
    {

        if (!cssparam.isEmpty())
        {
            if (cssparam.equals("Y"))
            {
                readFile();
                //add site.css to style que
                //create blank style.css file
            }
        } //end cssparam

        if (!frameworkparam.isEmpty())
        {
                String key = frameworkparam; //"bootstrap" or "foundation"
                boolean boolBootstrap = false;
                boolean boolFoundation = false;

                switch (key) {
                    case "bootstrap":
                        boolBootstrap = true;
                        break;
                    case "foundation":
                        boolFoundation = true;
                        break;
                }

                if (boolBootstrap) {
//                add bootstrap.js to script que
//                add bootstrap.css to style que
//                add bootstrap directory to assets directory

                }
                else if (boolFoundation) {
//                add bootstrap.js to script que
//                add bootstrap.css to style que
//                add bootstrap directory to assets directory
                }

        } //end frameworkparam

        if (!scriptparam.isEmpty())
        {
            if (scriptparam.equals("Y"))
            {
                String key = scriptparam; //"js" or "jQuery" or "jForm"
                boolean boolJS = false;
                boolean boolJQuery = false;
                boolean boolJForm = false;

                switch (key) {
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

                if (boolJS) {

//                add blank site.js to js directory

                }
                else if (boolJQuery) {

//                add jQuery.js to assets directory
//                add site.js to js directory
//                write onReady open to site.js
//                write onReady close to site.js
                }
                else if (boolJForm) {
//                add jQuery.validate to assets directory
//                add jQuery.js to assets directory
//                add site.js to js directory
//                write onReady open to site.js
//                write jQuery.validate instantiation to site.js
//                write onReady close to site.js

                }
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


*/
    }

    public void readFile()
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











} //end


