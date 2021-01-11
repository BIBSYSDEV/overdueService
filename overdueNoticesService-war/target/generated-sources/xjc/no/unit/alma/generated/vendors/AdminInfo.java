//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 08:11:16 AM CET 
//


package no.unit.alma.generated.vendors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Administrative details about the interface.
 * 
 * <p>Java class for admin_info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="admin_info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="user_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="user_password_note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="online_admin_module" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="admin_uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="admin_uri_type" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="open_url_compliant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="linking_note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hardware_req_internal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hardware_req_public" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="software_req_internal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="software_req_public" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maintenance_win_value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="incident_log" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="admin_documentation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "admin_info", propOrder = {

})
public class AdminInfo {

    @XmlElement(name = "user_id")
    protected String userId;
    @XmlElement(name = "user_password")
    protected String userPassword;
    @XmlElement(name = "user_password_note")
    protected String userPasswordNote;
    @XmlElement(name = "online_admin_module")
    protected Boolean onlineAdminModule;
    @XmlElement(name = "admin_uri")
    protected String adminUri;
    @XmlElement(name = "admin_uri_type")
    protected AdminInfo.AdminUriType adminUriType;
    @XmlElement(name = "open_url_compliant")
    protected Boolean openUrlCompliant;
    @XmlElement(name = "linking_note")
    protected String linkingNote;
    @XmlElement(name = "hardware_req_internal")
    protected String hardwareReqInternal;
    @XmlElement(name = "hardware_req_public")
    protected String hardwareReqPublic;
    @XmlElement(name = "software_req_internal")
    protected String softwareReqInternal;
    @XmlElement(name = "software_req_public")
    protected String softwareReqPublic;
    @XmlElement(name = "maintenance_win_value")
    protected String maintenanceWinValue;
    @XmlElement(name = "incident_log")
    protected String incidentLog;
    @XmlElement(name = "admin_documentation")
    protected String adminDocumentation;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the value of the userPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * Gets the value of the userPasswordNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPasswordNote() {
        return userPasswordNote;
    }

    /**
     * Sets the value of the userPasswordNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPasswordNote(String value) {
        this.userPasswordNote = value;
    }

    /**
     * Gets the value of the onlineAdminModule property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnlineAdminModule() {
        return onlineAdminModule;
    }

    /**
     * Sets the value of the onlineAdminModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnlineAdminModule(Boolean value) {
        this.onlineAdminModule = value;
    }

    /**
     * Gets the value of the adminUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminUri() {
        return adminUri;
    }

    /**
     * Sets the value of the adminUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminUri(String value) {
        this.adminUri = value;
    }

    /**
     * Gets the value of the adminUriType property.
     * 
     * @return
     *     possible object is
     *     {@link AdminInfo.AdminUriType }
     *     
     */
    public AdminInfo.AdminUriType getAdminUriType() {
        return adminUriType;
    }

    /**
     * Sets the value of the adminUriType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminInfo.AdminUriType }
     *     
     */
    public void setAdminUriType(AdminInfo.AdminUriType value) {
        this.adminUriType = value;
    }

    /**
     * Gets the value of the openUrlCompliant property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOpenUrlCompliant() {
        return openUrlCompliant;
    }

    /**
     * Sets the value of the openUrlCompliant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOpenUrlCompliant(Boolean value) {
        this.openUrlCompliant = value;
    }

    /**
     * Gets the value of the linkingNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkingNote() {
        return linkingNote;
    }

    /**
     * Sets the value of the linkingNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkingNote(String value) {
        this.linkingNote = value;
    }

    /**
     * Gets the value of the hardwareReqInternal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardwareReqInternal() {
        return hardwareReqInternal;
    }

    /**
     * Sets the value of the hardwareReqInternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardwareReqInternal(String value) {
        this.hardwareReqInternal = value;
    }

    /**
     * Gets the value of the hardwareReqPublic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardwareReqPublic() {
        return hardwareReqPublic;
    }

    /**
     * Sets the value of the hardwareReqPublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardwareReqPublic(String value) {
        this.hardwareReqPublic = value;
    }

    /**
     * Gets the value of the softwareReqInternal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwareReqInternal() {
        return softwareReqInternal;
    }

    /**
     * Sets the value of the softwareReqInternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwareReqInternal(String value) {
        this.softwareReqInternal = value;
    }

    /**
     * Gets the value of the softwareReqPublic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwareReqPublic() {
        return softwareReqPublic;
    }

    /**
     * Sets the value of the softwareReqPublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwareReqPublic(String value) {
        this.softwareReqPublic = value;
    }

    /**
     * Gets the value of the maintenanceWinValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaintenanceWinValue() {
        return maintenanceWinValue;
    }

    /**
     * Sets the value of the maintenanceWinValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaintenanceWinValue(String value) {
        this.maintenanceWinValue = value;
    }

    /**
     * Gets the value of the incidentLog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncidentLog() {
        return incidentLog;
    }

    /**
     * Sets the value of the incidentLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncidentLog(String value) {
        this.incidentLog = value;
    }

    /**
     * Gets the value of the adminDocumentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminDocumentation() {
        return adminDocumentation;
    }

    /**
     * Sets the value of the adminDocumentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminDocumentation(String value) {
        this.adminDocumentation = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class AdminUriType {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "desc")
        protected String desc;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the desc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesc() {
            return desc;
        }

        /**
         * Sets the value of the desc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesc(String value) {
            this.desc = value;
        }

    }

}
