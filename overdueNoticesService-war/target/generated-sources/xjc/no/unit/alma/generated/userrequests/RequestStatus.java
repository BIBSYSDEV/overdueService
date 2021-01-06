//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 10:21:05 AM CET 
//


package no.unit.alma.generated.userrequests;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for request_status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="request_status"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="In Process"/&gt;
 *     &lt;enumeration value="On Hold Shelf"/&gt;
 *     &lt;enumeration value="Not Started"/&gt;
 *     &lt;enumeration value="History"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "request_status")
@XmlEnum
public enum RequestStatus {

    @XmlEnumValue("In Process")
    IN_PROCESS("In Process"),
    @XmlEnumValue("On Hold Shelf")
    ON_HOLD_SHELF("On Hold Shelf"),
    @XmlEnumValue("Not Started")
    NOT_STARTED("Not Started"),
    @XmlEnumValue("History")
    HISTORY("History");
    private final String value;

    RequestStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RequestStatus fromValue(String v) {
        for (RequestStatus c: RequestStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
