/*
 * Copyright (c) 2018 Dominik Jahn, Philipp Kalytta
 * All rights reserved. This program and the accompanying materials
 * are private property protected by law.
 * DO NOT DISTRIBUTE
 *            T E C H N I S C H E   H O C H S C H U L E   K O E L N
 */

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


            /*AUFGABE 1*/
            SAXParser saxParser = factory.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();

            ArtikelContentHandler artikelContentHandler = new ArtikelContentHandler();

            xmlReader.setContentHandler(artikelContentHandler);

            ArtikelErrorHandler artikelErrorHandler = new ArtikelErrorHandler();

            xmlReader.setErrorHandler(artikelErrorHandler);

            String url = new File("ARTIKEL.XML").toURL().toString();

            xmlReader.parse(url);

            /*AUFGABE 2*/
            KundeContentHandler kundeContentHandler = new KundeContentHandler();

            xmlReader.setContentHandler(kundeContentHandler);

            KundeErrorHandler kundeErrorHandler = new KundeErrorHandler();

            xmlReader.setErrorHandler(kundeErrorHandler);

            String url2 = new File("UKUNDE.XML").toURL().toString();

            xmlReader.parse(url2);


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
