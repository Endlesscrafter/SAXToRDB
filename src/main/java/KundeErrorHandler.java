import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class KundeErrorHandler implements ErrorHandler {
    /**
     * Receive notification of a warning.
     *
     * <p>SAX parsers will use this method to report conditions that
     * are not errors or fatal errors as defined by the XML
     * recommendation.  The default behaviour is to take no
     * action.</p>
     *
     * <p>The SAX parser must continue to provide normal parsing events
     * after invoking this method: it should still be possible for the
     * application to process the document through to the end.</p>
     *
     * <p>Filters may use this method to report other, non-XML warnings
     * as well.</p>
     *
     * @param exception The warning information encapsulated in a
     *                  SAX parse exception.
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see SAXParseException
     */
    @Override
    public void warning(SAXParseException exception) throws SAXException {

    }

    /**
     * Receive notification of a recoverable error.
     *
     * <p>This corresponds to the definition of "error" in section 1.2
     * of the W3C XML 1.0 Recommendation.  For example, a validating
     * parser would use this callback to report the violation of a
     * validity constraint.  The default behaviour is to take no
     * action.</p>
     *
     * <p>The SAX parser must continue to provide normal parsing
     * events after invoking this method: it should still be possible
     * for the application to process the document through to the end.
     * If the application cannot do so, then the parser should report
     * a fatal error even if the XML recommendation does not require
     * it to do so.</p>
     *
     * <p>Filters may use this method to report other, non-XML errors
     * as well.</p>
     *
     * @param exception The error information encapsulated in a
     *                  SAX parse exception.
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see SAXParseException
     */
    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    /**
     * Receive notification of a non-recoverable error.
     *
     * <p><strong>There is an apparent contradiction between the
     * documentation for this method and the documentation for {@link
     * ContentHandler#endDocument}.  Until this ambiguity
     * is resolved in a future major release, clients should make no
     * assumptions about whether endDocument() will or will not be
     * invoked when the parser has reported a fatalError() or thrown
     * an exception.</strong></p>
     *
     * <p>This corresponds to the definition of "fatal error" in
     * section 1.2 of the W3C XML 1.0 Recommendation.  For example, a
     * parser would use this callback to report the violation of a
     * well-formedness constraint.</p>
     *
     * <p>The application must assume that the document is unusable
     * after the parser has invoked this method, and should continue
     * (if at all) only for the sake of collecting additional error
     * messages: in fact, SAX parsers are free to stop reporting any
     * other events once this method has been invoked.</p>
     *
     * @param exception The error information encapsulated in a
     *                  SAX parse exception.
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see SAXParseException
     */
    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
}
