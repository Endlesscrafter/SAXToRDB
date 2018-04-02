import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class SAXToRDB {

    public static void main(String[] args) {

        SAXParserFactory factory =  SAXParserFactory.newInstance();
        factory.setValidating(true);

        try {
            SAXParser saxParser = factory.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();

            ArtikelContentHandler artikelContentHandler = new ArtikelContentHandler();

            xmlReader.setContentHandler(artikelContentHandler);

            ArtikelErrorHandler artikelErrorHandler = new ArtikelErrorHandler();

            xmlReader.setErrorHandler(artikelErrorHandler);

            String url = new File("../ARTIKEL.XML").toURL().toString();

            xmlReader.parse(url);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
