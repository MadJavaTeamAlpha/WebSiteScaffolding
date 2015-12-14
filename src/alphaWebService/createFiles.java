package alphaWebService;

import java.io.File;

/**
 * Created by sschwert on 12/12/2015.
 */
public class CreateFiles {

        //------------INSTANCE VARIABLES---------//

        private File cssFileFolder;
        private File segmentCSSNavStyle;
        private File productSiteCSSStyle;
        private File refStyleCSS;

        private String templateWebSiteBoilerString = "./src/resources/templateWebSiteBoiler";
        private File indexHTMLFile;
        private File bootstrapFileFolder;
        private File foundationFileFolder;
        private File jsFileFolder;
        private File jQueryFile;
        private File jQueryValidationFileFolder;

        private String productFolderString = "./src/templateWebSiteProduct";
        private File productFileFolder;
        private File productAssetFileFolder;
        private String productZippedFolder = "./src/templateWebSiteProduct.zip";

        //---product index.html
        private File productIndexHTMLFile;

        //---product /js/site.js
        private File productSiteJSFile;

        //---code segments: jQuery
        private File segmentOnReadyOpen;
        private File segmentOnReadyClose;

        //---code segments: jQuery Validate
        private File segmentValidateJS;


        //--- code segment: Index.html
        private File segmentOpenHead;
        private File segmentNavOpen;
        private File segmentNavHtml;
        private File segmentNavClose;

        private File segmentCloseHeadOpenBody;

        private File segmentHelloWorld;

        private File segmentFoundationOpen;
        private File segmentFoundationClose;

        private File segmentJForm;

        private File segmentBootstrapOpen;
        private File segmentBootstrapClose;

        private File segmentCloseBody;

        // Site Script Reference
        private File refSiteJS;

        // jQuery Reference
        private File refJQueryJS;

        // Bootstrap References
        private File refBootstrapCss;
        private File refBootstrapJS;

        // Foundation References
        private File refFoundationCss;
        private File refFoundationJS;

        // jQuery Validate References
        private File refJQueryValidateJS;

        //--------GETTERS AND SETTERS--------//

        public File getCssFileFolder() {
            cssFileFolder = new File(templateWebSiteBoilerString + "/css");
            return cssFileFolder;
        }

        public void setCssFileFolder(File cssFileFolder) {
            this.cssFileFolder = cssFileFolder;
        }

        public File getSegmentCSSNavStyle() {
            segmentCSSNavStyle = new File(templateWebSiteBoilerString + "/segments/nav_style.txt");
            return segmentCSSNavStyle;
        }

        public void setSegmentCSSNavStyle(File segmentCSSNavStyle) {
            this.segmentCSSNavStyle = segmentCSSNavStyle;
        }

        public File getProductSiteCSSStyle() {
            productSiteCSSStyle = new File(productFolderString + "/css/style.css");
            return productSiteCSSStyle;
        }

        public void setProductSiteCSSStyle(File productSiteCSSStyle) {
            this.productSiteCSSStyle = productSiteCSSStyle;
        }

        public File getRefStyleCSS() {
            refStyleCSS = new File(templateWebSiteBoilerString + "/segments/style_queue_style_css.txt");
            return refStyleCSS;
        }

        public void setRefStyleCSS(File refStyleCSS) {
            this.refStyleCSS = refStyleCSS;
        }

        public String getTemplateWebSiteBoilerString() {
            templateWebSiteBoilerString = "./src/resources/templateWebSiteBoiler";
            return templateWebSiteBoilerString;
        }

        public void setTemplateWebSiteBoilerString(String templateWebSiteBoilerString) {
            this.templateWebSiteBoilerString = templateWebSiteBoilerString;
        }

        public File getIndexHTMLFile() {
            indexHTMLFile = new File(templateWebSiteBoilerString + "/index.html");
            return indexHTMLFile;
        }

        public void setIndexHTMLFile(File indexHTMLFile) {
            this.indexHTMLFile = indexHTMLFile;
        }

        public File getBootstrapFileFolder() {
            bootstrapFileFolder = new File(templateWebSiteBoilerString + "/assets/bootstrap");
            return bootstrapFileFolder;
        }

        public void setBootstrapFileFolder(File bootstrapFileFolder) {
            this.bootstrapFileFolder = bootstrapFileFolder;
        }

        public File getFoundationFileFolder() {
            foundationFileFolder = new File(templateWebSiteBoilerString + "/assets/foundation");
            return foundationFileFolder;
        }

        public void setFoundationFileFolder(File foundationFileFolder) {
            this.foundationFileFolder = foundationFileFolder;
        }

        public File getJsFileFolder() {
            jsFileFolder = new File(templateWebSiteBoilerString + "/js");
            return jsFileFolder;
        }

        public void setJsFileFolder(File jsFileFolder) {
            this.jsFileFolder = jsFileFolder;
        }

        public File getjQueryFile() {
            jQueryFile = new File(templateWebSiteBoilerString + "/assets/jquery.js");
            return jQueryFile;
        }

        public void setjQueryFile(File jQueryFile) {
            this.jQueryFile = jQueryFile;
        }

        public File getjQueryValidationFileFolder() {
            jQueryValidationFileFolder = new File(templateWebSiteBoilerString + "/assets/jquery-validation");
            return jQueryValidationFileFolder;
        }

        public void setjQueryValidationFileFolder(File jQueryValidationFileFolder) {
            this.jQueryValidationFileFolder = jQueryValidationFileFolder;
        }

        public String getProductFolderString() {
            productFolderString = "./src/templateWebSiteProduct";
            return productFolderString;
        }

        public void setProductFolderString(String productFolderString) {
            this.productFolderString = productFolderString;
        }

        public File getProductFileFolder() {
            productFolderString = "./src/templateWebSiteProduct";
            productFileFolder = new File(productFolderString);
            return productFileFolder;
        }

        public void setProductFileFolder(File productFileFolder) {
            this.productFileFolder = productFileFolder;
        }

        public File getProductAssetFileFolder() {
            productAssetFileFolder = new File(productFolderString + "/assets");
            return productAssetFileFolder;
        }

        public void setProductAssetFileFolder(File productAssetFileFolder) {
            this.productAssetFileFolder = productAssetFileFolder;
        }

        public String getProductZippedFolder() {
            productZippedFolder = "./src/templateWebSiteProduct.zip";
            return productZippedFolder;
        }

        public void setProductZippedFolder(String productZippedFolder) {
            this.productZippedFolder = productZippedFolder;
        }

        public File getProductIndexHTMLFile() {
            productIndexHTMLFile = new File(productFolderString + "/index.html");
            return productIndexHTMLFile;
        }

        public void setProductIndexHTMLFile(File productIndexHTMLFile) {
            this.productIndexHTMLFile = productIndexHTMLFile;
        }

        public File getProductSiteJSFile() {
            productSiteJSFile = new File(productFolderString + "/js/site.js");
            return productSiteJSFile;
        }

        public void setProductSiteJSFile(File productSiteJSFile) {
            this.productSiteJSFile = productSiteJSFile;
        }

        public File getSegmentOnReadyOpen() {
            segmentOnReadyOpen = new File(templateWebSiteBoilerString + "/segments/jquery_onready_open.txt");
            return segmentOnReadyOpen;
        }

        public void setSegmentOnReadyOpen(File segmentOnReadyOpen) {
            this.segmentOnReadyOpen = segmentOnReadyOpen;
        }

        public File getSegmentOnReadyClose() {
            segmentOnReadyClose = new File(templateWebSiteBoilerString + "/segments/jquery_onready_close.txt");
            return segmentOnReadyClose;
        }

        public void setSegmentOnReadyClose(File segmentOnReadyClose) {
            this.segmentOnReadyClose = segmentOnReadyClose;
        }

        public File getSegmentValidateJS() {
            segmentValidateJS = new File(templateWebSiteBoilerString + "/segments/jquery_validate.txt");
            return segmentValidateJS;
        }

        public void setSegmentValidateJS(File segmentValidateJS) {
            this.segmentValidateJS = segmentValidateJS;
        }

        public File getSegmentOpenHead() {
            segmentOpenHead = new File(templateWebSiteBoilerString + "/segments/open_head.txt");
            return segmentOpenHead;
        }

        public void setSegmentOpenHead(File segmentOpenHead) {
            this.segmentOpenHead = segmentOpenHead;
        }

        public File getSegmentNavOpen() {
            segmentNavOpen = new File(templateWebSiteBoilerString + "/segments/nav_open.txt");
            return segmentNavOpen;
        }

        public void setSegmentNavOpen(File segmentNavOpen) {
            this.segmentNavOpen = segmentNavOpen;
        }

        public File getSegmentNavHtml() {
            segmentNavHtml = new File(templateWebSiteBoilerString + "/segments/nav_html.txt");
            return segmentNavHtml;
        }

        public void setSegmentNavHtml(File segmentNavHtml) {
            this.segmentNavHtml = segmentNavHtml;
        }

        public File getSegmentNavClose() {
            segmentNavClose = new File(templateWebSiteBoilerString + "/segments/nav_close.txt");
            return segmentNavClose;
        }

        public void setSegmentNavClose(File segmentNavClose) {
            this.segmentNavClose = segmentNavClose;
        }

        public File getSegmentCloseHeadOpenBody() {
            segmentCloseHeadOpenBody = new File(templateWebSiteBoilerString + "/segments/close_head_open_body.txt");
            return segmentCloseHeadOpenBody;
        }

        public void setSegmentCloseHeadOpenBody(File segmentCloseHeadOpenBody) {
            this.segmentCloseHeadOpenBody = segmentCloseHeadOpenBody;
        }

        public File getSegmentHelloWorld() {
            segmentHelloWorld = new File(templateWebSiteBoilerString + "/segments/hello_world_html.txt");
            return segmentHelloWorld;
        }

        public void setSegmentHelloWorld(File segmentHelloWorld) {
            this.segmentHelloWorld = segmentHelloWorld;
        }

        public File getSegmentFoundationOpen() {
            segmentFoundationOpen = new File(templateWebSiteBoilerString + "/segments/foundation_open_html.txt");
            return segmentFoundationOpen;
        }

        public void setSegmentFoundationOpen(File segmentFoundationOpen) {
            this.segmentFoundationOpen = segmentFoundationOpen;
        }

        public File getSegmentFoundationClose() {
            segmentFoundationClose = new File(templateWebSiteBoilerString + "/segments/foundation_close_html.txt");
            return segmentFoundationClose;
        }

        public void setSegmentFoundationClose(File segmentFoundationClose) {
            this.segmentFoundationClose = segmentFoundationClose;
        }

        public File getSegmentJForm() {
            segmentJForm = new File(templateWebSiteBoilerString + "/segments/jform_html.txt");
            return segmentJForm;
        }

        public void setSegmentJForm(File segmentJForm) {
            this.segmentJForm = segmentJForm;
        }

        public File getSegmentBootstrapOpen() {
            segmentBootstrapOpen = new File(templateWebSiteBoilerString + "/segments/bootstrap_open_html.txt");
            return segmentBootstrapOpen;
        }

        public void setSegmentBootstrapOpen(File segmentBootstrapOpen) {
            this.segmentBootstrapOpen = segmentBootstrapOpen;
        }

        public File getSegmentBootstrapClose() {
            segmentBootstrapClose = new File(templateWebSiteBoilerString + "/segments/bootstrap_close_html.txt");
            return segmentBootstrapClose;
        }

        public void setSegmentBootstrapClose(File segmentBootstrapClose) {
            this.segmentBootstrapClose = segmentBootstrapClose;
        }

        public File getSegmentCloseBody() {
            segmentCloseBody = new File(templateWebSiteBoilerString + "/segments/close_body.txt");
            return segmentCloseBody;
        }

        public void setSegmentCloseBody(File segmentCloseBody) {
            this.segmentCloseBody = segmentCloseBody;
        }

        public File getRefSiteJS() {
            refSiteJS = new File(templateWebSiteBoilerString + "/segments/script_queue_site_js.txt");
            return refSiteJS;
        }

        public void setRefSiteJS(File refSiteJS) {
            this.refSiteJS = refSiteJS;
        }

        public File getRefJQueryJS() {
            refJQueryJS = new File(templateWebSiteBoilerString + "/segments/script_queue_jquery.txt");
            return refJQueryJS;
        }

        public void setRefJQueryJS(File refJQueryJS) {
            this.refJQueryJS = refJQueryJS;
        }

        public File getRefBootstrapCss() {
            refBootstrapCss = new File(templateWebSiteBoilerString + "/segments/style_queue_bootstrap.txt");
            return refBootstrapCss;
        }

        public void setRefBootstrapCss(File refBootstrapCss) {
            this.refBootstrapCss = refBootstrapCss;
        }

        public File getRefBootstrapJS() {
            refBootstrapJS = new File(templateWebSiteBoilerString + "/segments/script_queue_bootstrap.txt");
            return refBootstrapJS;
        }

        public void setRefBootstrapJS(File refBootstrapJS) {
            this.refBootstrapJS = refBootstrapJS;
        }

        public File getRefFoundationCss() {
            refFoundationCss = new File(templateWebSiteBoilerString + "/segments/style_queue_foundation.txt");
            return refFoundationCss;
        }

        public void setRefFoundationCss(File refFoundationCss) {
            this.refFoundationCss = refFoundationCss;
        }

        public File getRefFoundationJS() {
            refFoundationJS = new File(templateWebSiteBoilerString + "/segments/script_queue_foundation.txt");
            return refFoundationJS;
        }

        public void setRefFoundationJS(File refFoundationJS) {
            this.refFoundationJS = refFoundationJS;
        }

        public File getRefJQueryValidateJS() {
            refJQueryValidateJS = new File(templateWebSiteBoilerString + "/segments/script_queue_jquery_validate.txt");
            return refJQueryValidateJS;
        }

        public void setRefJQueryValidateJS(File refJQueryValidateJS) {
            this.refJQueryValidateJS = refJQueryValidateJS;
        }





    /*
    //---template boiler plate files
    private String templateWebSiteBoilerString = "./src/resources/templateWebSiteBoiler";
    private File indexHTMLFile = new File(templateWebSiteBoilerString + "/index.html");

    private File bootstrapFileFolder = new File(templateWebSiteBoilerString + "/assets/bootstrap");
    private File foundationFileFolder = new File(templateWebSiteBoilerString + "/assets/foundation");
    private File jsFileFolder = new File(templateWebSiteBoilerString + "/js");
    private File jQueryFile = new File(templateWebSiteBoilerString + "/assets/jquery.js");
    private File jQueryValidationFileFolder = new File(templateWebSiteBoilerString + "/assets/jquery-validation");

    //---INSTANTIATE AND CREATE PRODUCT FILES FOR CONSUMER---//
    private String productFolderString = "./src/templateWebSiteProduct";
    File productFileFolder = new File(productFolderString);
    private File productAssetFileFolder = new File(productFolderString + "/assets");
    private String productZippedFolder = "./src/templateWebSiteProduct.zip";

    //---product index.html
    private File productIndexHTMLFile = new File(productFolderString + "/index.html");

    //---product /js/site.js
    private File productSiteJSFile = new File(productFolderString + "/js/site.js");


    //---code segments: jQuery
    private File segmentOnReadyOpen = new File(templateWebSiteBoilerString + "/segments/jquery_onready_open.txt");
    private File segmentOnReadyClose = new File(templateWebSiteBoilerString + "/segments/jquery_onready_close.txt");

    //---code segments: jQuery Validate
    private File segmentValidateJS = new File(templateWebSiteBoilerString + "/segments/jquery_validate.txt");


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


    public void createCSSFiles() {

        cssFileFolder = new File(templateWebSiteBoilerString + "/css");

        //---code segments: CSS Nav Bar
        segmentCSSNavStyle = new File(templateWebSiteBoilerString + "/segments/nav_style.txt");

        //---product /css/style.css
        productSiteCSSStyle = new File(productFolderString + "/css/style.css");


        // Site Style Reference
        refStyleCSS = new File(templateWebSiteBoilerString + "/segments/style_queue_style_css.txt");

    }
*/
}



