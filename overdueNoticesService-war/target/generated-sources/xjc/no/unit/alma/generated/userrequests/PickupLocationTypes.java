//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.08 at 08:07:06 AM CET 
//


package no.unit.alma.generated.userrequests;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pickup_location_types.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="pickup_location_types"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="LIBRARY"/&gt;
 *     &lt;enumeration value="CIRCULATION_DESK"/&gt;
 *     &lt;enumeration value="USER_WORK_ADDRESS"/&gt;
 *     &lt;enumeration value="USER_HOME_ADDRESS"/&gt;
 *     &lt;enumeration value="INSTITUTION"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "pickup_location_types")
@XmlEnum
public enum PickupLocationTypes {

    LIBRARY,
    CIRCULATION_DESK,
    USER_WORK_ADDRESS,
    USER_HOME_ADDRESS,
    INSTITUTION;

    public String value() {
        return name();
    }

    public static PickupLocationTypes fromValue(String v) {
        return valueOf(v);
    }

}
