//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 07:59:22 AM CET 
//


package no.unit.alma.generated.userrequests;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for request_types.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="request_types"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HOLD"/&gt;
 *     &lt;enumeration value="BOOKING"/&gt;
 *     &lt;enumeration value="DIGITIZATION"/&gt;
 *     &lt;enumeration value="MOVE"/&gt;
 *     &lt;enumeration value="WORK_ORDER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "request_types")
@XmlEnum
public enum RequestTypes {

    HOLD,
    BOOKING,
    DIGITIZATION,
    MOVE,
    WORK_ORDER;

    public String value() {
        return name();
    }

    public static RequestTypes fromValue(String v) {
        return valueOf(v);
    }

}
