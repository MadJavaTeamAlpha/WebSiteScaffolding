package alphaWebService;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by sschwert on 12/12/2015.
 */
public class InterrogateParams {
    private final Logger logger = Logger.getLogger(InterrogateParams.class);
    //---INSTANCE VARIABLES---//
    private final ProcessFiles newProcessFile = new ProcessFiles();
    private final CreateFiles newCreateFiles = new CreateFiles();

    private final File productIndexHTMLFile = newCreateFiles.getProductIndexHTMLFile();

    private boolean boolBootstrap;
    private boolean boolFoundation;

    private boolean boolJS;
    private boolean boolJQuery;
    private boolean boolJForm;

    //---style queue
    private final ArrayList<String> styleQueue = new ArrayList<>();

    //---script queue
    private final ArrayList<String> scriptQueue = new ArrayList<>();

    /**
     * The interrogateParams method calls the interrogation sub-methods which check to see if there are user requests
     * for each non-boilerplate option and adds the requested parameters/objects to
     * @throws IOException
     */
    public void interrogateParams(String css, String framework, String script) throws IOException {
        logger.debug("we're in the interrogateParams method");
        interrogateCSSParams(css);
        interrogateFrameworkParams(framework);
        interrogateScriptParams(script);
    } //end interrogateParams()

    /**
     * the interrogateCSSParams methods takes the css choice of the user and creates the appropriate files and copies
     * them to the directory
     * @param css represents whether the user wants css or not
     * @throws IOException
     */
    private void interrogateCSSParams(String css) throws IOException {
        logger.debug("we're in the interrogateCSSParams method");
        File cssFileFolder = newCreateFiles.getCssFileFolder();
        File segmentCSSNavStyle = newCreateFiles.getSegmentCSSNavStyle();
        File productSiteCSSStyle = newCreateFiles.getProductSiteCSSStyle();
        File refStyleCSS = newCreateFiles.getRefStyleCSS();
        String productFolderString = newCreateFiles.getProductFolderString();

        File productFileFolder = new File(productFolderString);


        String cssparam = css;

        if (!cssparam.isEmpty() && cssparam.equals("Y"))
        {
            logger.debug("we're checking to see if the cssParam is empty and whether they chose Y");
            newProcessFile.copyDirToDir(cssFileFolder, productFileFolder);

            // add nav style to /css/style.css
            newProcessFile.printToFile(segmentCSSNavStyle, productSiteCSSStyle);

            // add nav style reference to style queue
            newProcessFile.addToQueue(refStyleCSS, styleQueue);

        } //end cssparam
    }


    /**
     * the interrogateFrameworkParams take the user's framework choice and creates the appropriate files based on two
     * possible choices
     * @param framework represents the user's framework choice
     * @throws IOException
     */
    private void interrogateFrameworkParams(String framework) throws IOException {
        logger.debug("we're in the interrogateFrameworkParams method");
        File productAssetFileFolder = newCreateFiles.getProductAssetFileFolder();
        File bootstrapFileFolder = newCreateFiles.getBootstrapFileFolder();
        File refBootstrapCss = newCreateFiles.getRefBootstrapCss();
        File refBootstrapJS = newCreateFiles.getRefBootstrapJS();
        File foundationFileFolder = newCreateFiles.getFoundationFileFolder();
        File refFoundationCss = newCreateFiles.getRefFoundationCss();
        File refFoundationJS = newCreateFiles.getRefFoundationJS();

        String frameworkparam = framework;

        if (!frameworkparam.isEmpty())
        {
            String key = frameworkparam; //"bootstrap" or "foundation"
            logger.debug("we're checking to see if the framework param is empty");
            switch (key)
            {
                case "bootstrap":
                    logger.debug("we're checking to see if they chose bootstrap");
                    boolBootstrap = true;
                    break;
                case "foundation":
                    logger.debug("we're checking to see if they chose foundation");
                    boolFoundation = true;
                    break;
            }

            //make the assets directory
            newProcessFile.makeDir(productAssetFileFolder);

            if (boolBootstrap)
            {
                //FYI in IntelliJ Project Window it might look like this: assets.bootstrap (= assets/bootstrap/)
                newProcessFile.copyDirToDir(bootstrapFileFolder, productAssetFileFolder);

                // add bootstrap.css to style queue
                newProcessFile.addToQueue(refBootstrapCss, styleQueue);

                // add bootstrap.js to script queue
                newProcessFile.addToQueue(refBootstrapJS, scriptQueue);

            }
            else if (boolFoundation)
            {
                newProcessFile.copyDirToDir(foundationFileFolder, productAssetFileFolder);

                // add foundation.css to style queue
                newProcessFile.addToQueue(refFoundationCss, styleQueue);

                // add foundation.js to script queue
                newProcessFile.addToQueue(refFoundationJS, scriptQueue);

            }

        } //end frameworkparam
    }

    /**
     * the interrogateScriptParams method takes the users script method and creates the appropriate files based on three
     * possible choices
     * @param jForm is the user's choice of script additions
     * @throws IOException
     */
    private void interrogateScriptParams(String jForm) throws IOException {
        logger.debug("we're in the interrogateScriptParams method");
        File jsFileFolder = newCreateFiles.getJsFileFolder();
        File productFileFolder = newCreateFiles.getProductFileFolder();
        File refSiteJS = newCreateFiles.getRefSiteJS();
        File jQueryFile = newCreateFiles.getjQueryFile();
        File productAssetFileFolder = newCreateFiles.getProductAssetFileFolder();
        File segmentOnReadyOpen = newCreateFiles.getSegmentOnReadyOpen();
        File productSiteJSFile = newCreateFiles.getProductSiteJSFile();
        File segmentOnReadyClose = newCreateFiles.getSegmentOnReadyClose();
        File refJQueryJS = newCreateFiles.getRefJQueryJS();
        File jQueryValidationFileFolder = newCreateFiles.getjQueryValidationFileFolder();
        File segmentValidateJS = newCreateFiles.getSegmentValidateJS();
        File refJQueryValidateJS = newCreateFiles.getRefJQueryValidateJS();

        String scriptparam = jForm;

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
                newProcessFile.copyDirToDir(jsFileFolder, productFileFolder);

                // add site.js to script queue
                newProcessFile.addToQueue(refSiteJS, scriptQueue);

            }
            else if (boolJQuery)
            {
                //add jQuery.js to assets directory
                newProcessFile.copyFileToDir(jQueryFile, productAssetFileFolder);

                //add site.js to js directory
                newProcessFile.copyDirToDir(jsFileFolder, productFileFolder);

                // write onReady open to site.js
                newProcessFile.printToFile(segmentOnReadyOpen, productSiteJSFile);

                // write onReady close to site.js
                newProcessFile.printToFile(segmentOnReadyClose, productSiteJSFile);

                // add jquery.js to script queue
                newProcessFile.addToQueue(refJQueryJS, scriptQueue);

                // add site.js to script queue
                newProcessFile.addToQueue(refSiteJS, scriptQueue);

            }
            else if (boolJForm)
            {
                //add jQuery.js to assets directory
                newProcessFile.copyFileToDir(jQueryFile, productAssetFileFolder);

                //add site.js to js directory
                newProcessFile.copyDirToDir(jsFileFolder, productFileFolder);

                //add jQuery.validate to assets directory
                newProcessFile.copyDirToDir(jQueryValidationFileFolder, productAssetFileFolder);

                // write onReady open to site.js
                newProcessFile.printToFile(segmentOnReadyOpen, productSiteJSFile);

                // write jQuery.validate instantiation to site.js
                newProcessFile.printToFile(segmentValidateJS, productSiteJSFile);

                // write onReady close to site.js
                newProcessFile.printToFile(segmentOnReadyClose, productSiteJSFile);

                // add jquery.js to script queue
                newProcessFile.addToQueue(refJQueryJS, scriptQueue);

                // add jquery.validate.js to script queue
                newProcessFile.addToQueue(refJQueryValidateJS, scriptQueue);

                // add site.js to script queue
                newProcessFile.addToQueue(refSiteJS, scriptQueue);

            }
        } //end scriptparam
    }

    /**
     * The writeIndexHTML calls the appropriate methods and adds the appropriate objects as parameters
     * to write each section of the Index.html file
     * @throws IOException
     */
    //-------Can we refactor this method for easier testing?-----//
    // maybe pull out Head, Nav, Content, and JForm sections into own methods?
    //write a root file for the web site files
    public void writeIndexHTML() throws IOException {
        logger.debug("we're in the writeIndexHTML method");
        File productFileFolder = newCreateFiles.getProductFileFolder();
        File indexHTMLFile = newCreateFiles.getIndexHTMLFile();
        File segmentHelloWorld = newCreateFiles.getSegmentHelloWorld();
        File segmentCloseBody = newCreateFiles.getSegmentCloseBody();

        newProcessFile.makeDir(productFileFolder);
        newProcessFile.copyFileToDir(indexHTMLFile, productFileFolder);

        writeHeadIndexHtml();
        writeNavIndexHtml();

        /* Hello World */
        newProcessFile.printToFile(segmentHelloWorld, productIndexHTMLFile);


        writeJFormIndexHtml();

        newProcessFile.printQueue(scriptQueue, productIndexHTMLFile);
        newProcessFile.printToFile(segmentCloseBody, productIndexHTMLFile);

    }


    /**
     * writeHeadIndexHtml creates the opening head, and closing head open body, sections of the html
     * then calls methods that prints them to file, prints the styleQueue which goes in the html head
     * and prints the body of the html file
     * @throws IOException
     */
    private void writeHeadIndexHtml() throws IOException {
        logger.debug("we're in the writeHeadIndexHtml method");
        File segmentOpenHead = newCreateFiles.getSegmentOpenHead();
        File segmentCloseHeadOpenBody = newCreateFiles.getSegmentCloseHeadOpenBody();

        /* Head */
        newProcessFile.printToFile(segmentOpenHead, productIndexHTMLFile);
        newProcessFile.printQueue(styleQueue, productIndexHTMLFile);
        newProcessFile.printToFile(segmentCloseHeadOpenBody, productIndexHTMLFile);
    }

    /**
     * writeNavIndexHtml writes the sections of the html that create a nav bar
     * @throws IOException
     */
    private void writeNavIndexHtml() throws IOException {
        logger.debug("we're in the writeNavIndexHtml method");
        File segmentNavOpen = newCreateFiles.getSegmentNavOpen();
        File segmentNavHtml = newCreateFiles.getSegmentNavHtml();
        File segmentNavClose = newCreateFiles.getSegmentNavClose();

        /* Nav */
        newProcessFile.printToFile(segmentNavOpen, productIndexHTMLFile);

        writeContentIndexHtmlOpen();

        newProcessFile.printToFile(segmentNavHtml, productIndexHTMLFile);

        writeContentIndexHtmlClose();

        newProcessFile.printToFile(segmentNavClose, productIndexHTMLFile);
    }


    /**
     * the writeJFormIndexHtml creates a jquery validation ready form and writes it to the index.html file,
     * then closes the index.html file
     * @throws IOException
     */
    private void writeJFormIndexHtml() throws IOException {
        logger.debug("we're in the writeJFormIndexHtml method");
        File segmentJForm = newCreateFiles.getSegmentJForm();

        /* JForm */
        if (boolJForm) {
            logger.debug("if they chose jForm then we're printing the jForm segment");
            newProcessFile.printToFile(segmentJForm, productIndexHTMLFile);
        }

        writeContentIndexHtmlClose();
    }


    /**
     * writeContentIndexHtmlOpen opens and writes the framework sections of the index.html file based on the user's choice
     * @throws IOException
     */
    private void writeContentIndexHtmlOpen() throws IOException {
        logger.debug("we're in the writeContentIndexHtmlOpen method");
        File segmentBootstrapOpen = newCreateFiles.getSegmentBootstrapOpen();
        File segmentFoundationOpen = newCreateFiles.getSegmentFoundationOpen();

    /* Content */
        if (boolBootstrap) {
            newProcessFile.printToFile(segmentBootstrapOpen, productIndexHTMLFile);
        }

        if (boolFoundation) {
            newProcessFile.printToFile(segmentFoundationOpen, productIndexHTMLFile);
        }
    }

    /**
     * writeContentIndexHtmlClose method writes the framework linked sections of the index.html page that closes those
     * sections based on the user's choice
     * @throws IOException
     */
    private void writeContentIndexHtmlClose() throws IOException {
        logger.debug("we're in the writeContentIndexHtmlClose method");
        File segmentBootstrapClose = newCreateFiles.getSegmentBootstrapClose();
        File segmentFoundationClose = newCreateFiles.getSegmentFoundationClose();

        if (boolBootstrap) {
            logger.debug("if they chose bootstrap then we're printing the bootstrap close segment");
            newProcessFile.printToFile(segmentBootstrapClose, productIndexHTMLFile);
        }

        if (boolFoundation) {
            logger.debug("if they chose foundation then we're printing the foundation close segment");
            newProcessFile.printToFile(segmentFoundationClose, productIndexHTMLFile);
        }
    }

}
