package generated;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for carCondition complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="carCondition">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *       &lt;attribute name="accidentfree" use="required" type="{http://www.przyklad.pl/showroom}boolean" />
 *       &lt;attribute name="mileage" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carCondition", namespace = "http://www.przyklad.pl/showroom", propOrder = {
        "value"
})
public class CarCondition {

    @XmlValue
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String value;
    @XmlAttribute(name = "accidentfree", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String accidentfree;
    @XmlAttribute(name = "mileage", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String mileage;

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
     * Gets the value of the accidentfree property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccidentfree() {
        return accidentfree;
    }

    /**
     * Sets the value of the accidentfree property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccidentfree(String value) {
        this.accidentfree = value;
    }

    /**
     * Gets the value of the mileage property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * Sets the value of the mileage property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMileage(String value) {
        this.mileage = value;
    }

}
