//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 08:56:47 PM CET 
//


package no.unit.alma.generated.user;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of user's blocks.
 * 				SIS: In case of new user, these segments will be marked as "external".
 * 				In case of synchronization, this list will replace the existing external blocks. Internal blocks will be kept.
 * 				POST action: The segments will be created as external or as internal according to the "segment_type" attribute.
 * 				PUT action: Incoming internal segments (based on the "segment_type" attribute) will replace the existing internal segments.
 * 				Incoming external segments (based on the "segment_type" attribute) will replace the existing external segments.
 * 				If the incoming list is empty, existing segments will be deleted.
 * 		
 * 
 * <p>Java class for user_blocks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user_blocks"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user_block" type="{}user_block" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user_blocks", propOrder = {
    "userBlock"
})
public class UserBlocks {

    @XmlElement(name = "user_block")
    protected List<UserBlock> userBlock;

    /**
     * Gets the value of the userBlock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userBlock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserBlock }
     * 
     * 
     */
    public List<UserBlock> getUserBlock() {
        if (userBlock == null) {
            userBlock = new ArrayList<UserBlock>();
        }
        return this.userBlock;
    }

}
