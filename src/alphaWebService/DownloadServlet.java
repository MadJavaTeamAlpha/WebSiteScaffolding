package alphaWebService;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Private on 12/7/15.
 */


public class DownloadServlet extends HttpServlet
{
    private File file;
    public DownloadServlet(File download)
    {
        file = download;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // fetch parameters from HTTP request



        // prepare writing the result to the client as a "downloadable" file

        response.setContentType("text/zip");
        response.setHeader("Content-disposition", "attachment; filename=\"" + file + "\"");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "-1");
        String output = FileUtils.readFileToString(file);
        // actually send result bytes
        response.getOutputStream().write(output.getBytes());
    }
}
