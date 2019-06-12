package generated;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for carWheeldrive complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="carWheeldrive">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *       &lt;attribute name="automatic" use="required" type="{http://www.przyklad.pl/showroom}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carWheeldrive", namespace = "http://www.przyklad.pl/showroom", propOrder = {
        "value"
})
public class CarWheeldrive {

    @XmlValue
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String value;
    @XmlAttribute(name = "automatic", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String automatic;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the automatic property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAutomatic() {
        return automatic;
    }

    /**
     * Sets the value of the automatic property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAutomatic(String value) {
        this.automatic = value;
    }

}
