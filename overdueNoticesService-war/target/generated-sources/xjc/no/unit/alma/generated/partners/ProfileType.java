//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 08:55:41 PM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for profile_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="profile_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ART_EMAIL"/&gt;
 *     &lt;enumeration value="NCIP"/&gt;
 *     &lt;enumeration value="ISO"/&gt;
 *     &lt;enumeration value="ISO_18626"/&gt;
 *     &lt;enumeration value="EMAIL"/&gt;
 *     &lt;enumeration value="NCIP_P2P"/&gt;
 *     &lt;enumeration value="SLNP"/&gt;
 *     &lt;enumeration value="EXTERNAL_SYSTEM"/&gt;
 *     &lt;enumeration value="BLDSS"/&gt;
 *     &lt;enumeration value="FULFILLMENT_NETWORK"/&gt;
 *     &lt;enumeration value="RAPID"/&gt;
 *     &lt;enumeration value="INNREACH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "profile_type")
@XmlEnum
public enum ProfileType {


    /**
     * Communication between Alma and the British Library resource sharing system.
     * 
     */
    ART_EMAIL,

    /**
     * Communication between Alma and resource sharing systems, such as OCLC Navigator, OCLC iLLiad, and Relais D2D, via NCIP 2.0 messages.
     * 
     */
    NCIP,

    /**
     * Communication between Alma and another resource sharing (Alma or non-Alma) system.
     * 
     */
    ISO,

    /**
     * Communication between Alma and another resource sharing (Alma or non-Alma) system according to ISO 18626.
     * 
     */
    ISO_18626,

    /**
     * The sending of borrowing requests by the Alma borrowing partner via email.
     * 
     */
    EMAIL,

    /**
     * NCIP-P2P protcol
     * 
     */
    NCIP_P2P,

    /**
     * SLNP paretner type
     * 
     */
    SLNP,

    /**
     * External System paretner type
     * 
     */
    EXTERNAL_SYSTEM,

    /**
     * British Library Document Supply Service
     * 
     */
    BLDSS,

    /**
     * Fulfillment Network partner type
     * 
     */
    FULFILLMENT_NETWORK,

    /**
     * RapidILL Protocol
     * 
     */
    RAPID,

    /**
     * INN-Reach API Protocol
     * 
     */
    INNREACH;

    public String value() {
        return name();
    }

    public static ProfileType fromValue(String v) {
        return valueOf(v);
    }

}
