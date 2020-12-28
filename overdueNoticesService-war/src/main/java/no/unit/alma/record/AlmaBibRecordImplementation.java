package no.unit.alma.record;

import no.unit.alma.bibs.Bib;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

public class AlmaBibRecordImplementation extends AbstractAlmaRecord implements AlmaBibRecord {

    private Bib bib;

    public AlmaBibRecordImplementation(Bib bib) {
        setUpTransformerFactory();
        this.bib = bib;
        if (bib != null) {
            final List<Element> contentList = bib.getAnies();

            for (Object object : contentList) {
                if (object instanceof Node) {
                    Node node = (Node) object;
                    if (node.getLocalName().equals("record")) {
                        rootElement = (Element) node;
                        document = rootElement.getOwnerDocument();
                    }
                }
            }
            if (document == null) {
                throw new RuntimeException("Missing marc record");
            }
        }
    }


    @Override
    public Bib getBib() {
        return bib;
    }

    @Override
    public String toString() {
        return nodeToString(rootElement);
    }


}
