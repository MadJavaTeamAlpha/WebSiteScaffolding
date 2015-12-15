package alphaWebService;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.File;

/**
 * Created by sschwert on 12/13/2015.
 */
public class InterrogateParamsTest extends TestCase {

    private CreateFiles newCreateFiles = new CreateFiles();

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    @Test
    public void testInterrogateParams() throws Exception {
        File productIndexHTMLFile = newCreateFiles.getProductIndexHTMLFile();

        System.out.println("there's something here: " + productIndexHTMLFile);
        assertNotNull(productIndexHTMLFile);
    }

    @Test
    public void testInstantiateCssFileFolder() throws Exception {
        File cssFileFolder = newCreateFiles.getCssFileFolder();
        assertNotNull(cssFileFolder);
    }

    @Test
    public void testInstantiateCSSNavStyle() throws Exception {
        File segmentCSSNavStyle = newCreateFiles.getSegmentCSSNavStyle();
        assertNotNull(segmentCSSNavStyle);
    }

    @Test
    public void testInstantiateSiteCSSStyle() throws Exception {
        File productSiteCSSStyle = newCreateFiles.getProductSiteCSSStyle();
        assertNotNull(productSiteCSSStyle);
    }

    @Test
    public void testInstantiateRefStyleCSS() throws Exception {
        File refStyleCSS = newCreateFiles.getRefStyleCSS();
        assertNotNull(refStyleCSS);
    }

    @Test
    public void testInstantiateProductFolderString() {
        String productFolderString = newCreateFiles.getProductFolderString();
        assertNotNull(productFolderString);
    }

    @Test
    public void testCreateProductFileFolder() {
        String productFolderString = newCreateFiles.getProductFolderString();
        File productFileFolder = new File(productFolderString);
        assertNotNull(productFileFolder);
    }


    @Test
    public void testWriteHeadIndexHTML() throws Exception {
        File segmentOpenHead = newCreateFiles.getSegmentOpenHead();
        assertNotNull(segmentOpenHead);

        File segmentCloseHeadOpenBody = newCreateFiles.getSegmentCloseHeadOpenBody();
        assertNotNull(segmentCloseHeadOpenBody);
    }

    @Test
    public void testInstantiateProductAssetFileFolder() {
        File productAssetFileFolder = newCreateFiles.getProductAssetFileFolder();
        assertNotNull(productAssetFileFolder);
        System.out.println(productAssetFileFolder);
    }

    @Test
    public void testInstantiateBootstrapFileFolder() {
        File bootstrapFileFolder = newCreateFiles.getBootstrapFileFolder();
        assertNotNull(bootstrapFileFolder);
        System.out.println(bootstrapFileFolder);
    }

    @Test
    public void testCreateRefBootstrapCss() {
        File refBootstrapCss = newCreateFiles.getRefBootstrapCss();
        assertNotNull(refBootstrapCss);
    }
    

}