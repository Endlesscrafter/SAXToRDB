import org.xml.sax.ContentHandler;

import javax.xml.validation.TypeInfoProvider;
import java.sql.Connection;
import java.sql.SQLException;

public class LagerContentHandler implements ContentHandler {

    private TypeInfoProvider typeInfoProvider;
    String spaltenid;
    String spaltseq, wertseq;
    private boolean lagerPosMerker = false;
    DatabaseManager databaseManager = new DatabaseManager();

    public LagerContentHandler(TypeInfoProvider typeInfoProvider){
        this.typeInfoProvider = typeInfoProvider;
    }

    @Override
    public void setDocumentLocator(org.xml.sax.Locator locator) {

    }

    @Override
    public void startDocument() throws org.xml.sax.SAXException {

    }

    @Override
    public void endDocument() throws org.xml.sax.SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws org.xml.sax.SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws org.xml.sax.SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts) throws org.xml.sax.SAXException {
        if(qName.equals("LAGERAT")){

            spaltenid = null;
            spaltseq="(";
            wertseq="(";

        }
        if(qName.equals("lagernummer")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();
            spaltseq += qName;

        }
        if(qName.equals("lagerort")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();
            spaltseq += "," + qName;

        }
        if(qName.equals("lagerpostleitzahl")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();
            spaltseq += "," + qName;

        }
        if(qName.equals("ARTIKELLISTE")) {

            spaltseq += "," + qName;
            wertseq += "ARTIKELLISTE(";
            lagerPosMerker = true;
        }
        if(qName.equals("LAGERPOSITION")) {

            if(!lagerPosMerker)
                wertseq += "), LAGERPOSITION(";
            else {
                wertseq += "LAGERPOSITION(";
                lagerPosMerker = false;
            }

        }
        if(qName.equals("menge")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();


        }
        if(qName.equals("artikelnummer")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();


        }
        if(qName.equals("artikelbezeichnung")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();


        }
        if(qName.equals("mengeneinheit")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();


        }
        if(qName.equals("preis")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();


        }
        if(qName.equals("steuersatz")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();


        }
        if(qName.equals("einlieferungsdatum")) {

            spaltenid = typeInfoProvider.getElementTypeInfo().getTypeName();


        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        if(qName.equals("LAGERAT")){

            spaltseq+=")";
            wertseq+=")))";


            String insert = "INSERT INTO LAGERAT " +spaltseq+ " VALUES " + wertseq;

            System.out.println(insert);

            try {
                Connection connection = databaseManager.connect();

                databaseManager.insertArtikel(connection, insert);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        switch (spaltenid){

            case "string":
                wertseq += "\'"+ new String(ch, start, length) + "\'" + ",";
                break;
            case "restrictedDecimal":
                wertseq +=  new String(ch, start, length) + ",";
                break;
            case "integer":
                wertseq +=  new String(ch, start, length) + ",";
                break;
            case "date":
                wertseq += "TO_DATE("+ "\'"+ new String(ch, start, length) + "\'" + ",\'YYYY-MM-DD\')";
                break;


            default: System.out.println("Fehler: Es wurden PCDATA-Characater Daten an einer Stelle gelesen, an denen sie nicht auftreten dürfen"); break;
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws org.xml.sax.SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws org.xml.sax.SAXException {

    }

    @Override
    public void skippedEntity(String name) throws org.xml.sax.SAXException {

    }
}
