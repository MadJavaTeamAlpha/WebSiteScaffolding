package alphaWebService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by TeamAlpha on 11/10/2015.
 */
public class ScaffoldingClient {

  private final static String URL = "http://localhost:9998/scaffolding";

  public static void main(String[] argv) throws IOException {

    String url = URL;
    String charset = "UTF-8";
    String param1 = "hello";

    String query = String.format("myParam=%s", URLEncoder.encode(param1, charset));
    java.net.URLConnection connection = new URL(url + "?" + query).openConnection();
    System.out.println(url + "?" + query);

    connection.setRequestProperty("Accept-Charset", charset);

    if (connection instanceof HttpURLConnection)
    {
      HttpURLConnection httpConnection = (HttpURLConnection) connection;
      System.out.println(httpConnection.getResponseCode());
      System.out.println(httpConnection.getResponseMessage());
      System.out.println(connection.getContent());
    }
    else
    {
      System.err.println ("error!");
    }
  }
}

