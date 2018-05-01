/*
 * Copyright (c) 2018 Dominik Jahn, Philipp Kalytta
 * All rights reserved. This program and the accompanying materials
 * are private property protected by law.
 * DO NOT DISTRIBUTE
 *            T E C H N I S C H E   H O C H S C H U L E   K O E L N
 */

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.ValidatorHandler;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class SAXToRDB {

    public static void main(String[] args) {

        SAXParserFactory factory =  SAXParserFactory.newInstance();
        factory.setValidating(true);

        try {


            /*AUFGABE 1*/ /*
            SAXParser saxParser = factory.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();

            ArtikelContentHandler artikelContentHandler = new ArtikelContentHandler();

            xmlReader.setContentHandler(artikelContentHandler);

            ArtikelErrorHandler artikelErrorHandler = new ArtikelErrorHandler();

            xmlReader.setErrorHandler(artikelErrorHandler);

            String url = new File("ARTIKEL.XML").toURL().toString();

            xmlReader.parse(url); */

            /*AUFGABE 2*/ /*
            KundeContentHandler kundeContentHandler = new KundeContentHandler();

            xmlReader.setContentHandler(kundeContentHandler);

            KundeErrorHandler kundeErrorHandler = new KundeErrorHandler();

            xmlReader.setErrorHandler(kundeErrorHandler);

            String url2 = new File("UKUNDE.XML").toURL().toString();

            xmlReader.parse(url2); */

            /*AUFGABE 4*/

            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new File("artikelliste.xsd"));
            ValidatorHandler validatorHandler = schema.newValidatorHandler();
            SAXParser saxParser = factory.newSAXParser();



            String schemaxsd = new File("artikelliste.xsd").toURL().toString();



            ArtikelContentHandler artikelContentHandler = new ArtikelContentHandler(validatorHandler.getTypeInfoProvider());
            validatorHandler.setContentHandler(artikelContentHandler);

            ArtikelErrorHandler artikelErrorHandler = new ArtikelErrorHandler();
            validatorHandler.setErrorHandler(artikelErrorHandler);
            //xmlReader.setContentHandler(artikelContentHandler);
            //xmlReader.setErrorHandler(artikelErrorHandler);

            //XMLReader xmlReader = saxParser.getXMLReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Features & Properties for parsing and validating XML files with XML Schema definition
            xmlReader.setFeature("http://xml.org/sax/features/validation", true);
            xmlReader.setFeature("http://apache.org/xml/features/validation/schema", true);
            xmlReader.setFeature("http://apache.org/xml/features/validation/schema-full-checking",true);
            xmlReader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", schemaxsd);

            xmlReader.setContentHandler(validatorHandler);

            String url3 = new File("ARTIKEL1.XML").toURL().toString();

            xmlReader.parse(url3);

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
