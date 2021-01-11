//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 07:59:21 AM CET 
//


package no.unit.alma.generated.user;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of the user's related resource sharing libraries.
 * 		On SIS synch this field will not be replaced if it was updated manually (or if empty in the incoming user record).
 * 		For external users in PUT action: this field will not be replaced if it was updated manually (or if empty in the incoming user record), unless 'override' parameter is sent with the field's name.
 * 		
 * 
 * <p>Java class for rs_libraries complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rs_libraries"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rs_library" type="{}rs_library" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rs_libraries", propOrder = {
    "rsLibrary"
})
public class RsLibraries {

    @XmlElement(name = "rs_library")
    protected List<RsLibrary> rsLibrary;

    /**
     * Gets the value of the rsLibrary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rsLibrary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRsLibrary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RsLibrary }
     * 
     * 
     */
    public List<RsLibrary> getRsLibrary() {
        if (rsLibrary == null) {
            rsLibrary = new ArrayList<RsLibrary>();
        }
        return this.rsLibrary;
    }

}
