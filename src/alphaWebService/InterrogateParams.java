package alphaWebService;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by sschwert on 12/12/2015.
 */
public class InterrogateParams {

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
        interrogateCSSParams(css);
        interrogateFrameworkParams(framework);
        interrogateScriptParams(script);
    } //end interrogateParams()

    /**
     *
     * @param css
     * @throws IOException
     */
    private void interrogateCSSParams(String css) throws IOException {
        File cssFileFolder = newCreateFiles.getCssFileFolder();
        File segmentCSSNavStyle = newCreateFiles.getSegmentCSSNavStyle();
        File productSiteCSSStyle = newCreateFiles.getProductSiteCSSStyle();
        File refStyleCSS = newCreateFiles.getRefStyleCSS();
        String productFolderString = newCreateFiles.getProductFolderString();

        File productFileFolder = new File(productFolderString);


        String cssparam = css;

        if (!cssparam.isEmpty() && cssparam.equals("Y"))
        {
            newProcessFile.copyDirToDir(cssFileFolder, productFileFolder);

            // add nav style to /css/style.css
            newProcessFile.printToFile(segmentCSSNavStyle, productSiteCSSStyle);

            // add nav style reference to style queue
            newProcessFile.addToQueue(refStyleCSS, styleQueue);

        } //end cssparam
    }


    /**
     * @param framework
     * @throws IOException
     */
    private void interrogateFrameworkParams(String framework) throws IOException {

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
     *
     * @param jForm
     * @throws IOException
     */
    private void interrogateScriptParams(String jForm) throws IOException {

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
     *
     * @throws IOException
     */
    private void writeHeadIndexHtml() throws IOException {
        File segmentOpenHead = newCreateFiles.getSegmentOpenHead();
        File segmentCloseHeadOpenBody = newCreateFiles.getSegmentCloseHeadOpenBody();

        /* Head */
        newProcessFile.printToFile(segmentOpenHead, productIndexHTMLFile);
        newProcessFile.printQueue(styleQueue, productIndexHTMLFile);
        newProcessFile.printToFile(segmentCloseHeadOpenBody, productIndexHTMLFile);
    }

    /**
     *
     * @throws IOException
     */
    private void writeNavIndexHtml() throws IOException {
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
     *
     * @throws IOException
     */
    private void writeJFormIndexHtml() throws IOException {
        File segmentJForm = newCreateFiles.getSegmentJForm();

        /* JForm */
        if (boolJForm) {
            newProcessFile.printToFile(segmentJForm, productIndexHTMLFile);
        }

        writeContentIndexHtmlClose();
    }


    /**
     *
     * @throws IOException
     */
    private void writeContentIndexHtmlOpen() throws IOException {
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
     *
     * @throws IOException
     */
    private void writeContentIndexHtmlClose() throws IOException {
        File segmentBootstrapClose = newCreateFiles.getSegmentBootstrapClose();
        File segmentFoundationClose = newCreateFiles.getSegmentFoundationClose();

        if (boolBootstrap) {
            newProcessFile.printToFile(segmentBootstrapClose, productIndexHTMLFile);
        }

        if (boolFoundation) {
            newProcessFile.printToFile(segmentFoundationClose, productIndexHTMLFile);
        }
    }

}
