package version;

import java.io.InputStream;
import javax.management.modelmbean.XMLParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lmessing
 */
public class Version
{

  private static Version VERSION_HOLDER = null;
  private String VERSION = "";

  private Version()
  {
    VERSION = parseVersion(getClass().getResourceAsStream("/version/version.xml"));
  }

  public static Version getInstance()
  {
    if(VERSION_HOLDER == null)
    {
      VERSION_HOLDER = new Version();
    }

    return VERSION_HOLDER;
  }

  public static String getVERSION()
  {
    return Version.getInstance().VERSION;
  }

  private static String parseVersion(InputStream inputStream)
  {
    String ver;

    try
    {

      if(inputStream == null)
      {
        System.out.println("INPUT STREAM == NULL !");
        throw new IllegalArgumentException();
      }

      // setup parser
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      dBuilder.setErrorHandler(new DefaultHandler()); // turn off logging
      Document doc = dBuilder.parse(inputStream);
      doc.getDocumentElement().normalize();
      Element element = doc.getDocumentElement();

      // get values
      if(element.getAttribute("name").contains("version"))
      {
        ver = element.getAttribute("value");
      }
      else
      {
        throw new XMLParseException("missing version name");
      }

    }
    catch (Exception e)
    {
      ver = "0.0.0";
      return ver;
    }

    return ver;
  }

}
