package generated;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for carEngineCapacity complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="carEngineCapacity">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>short">
 *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}normalizedString" fixed="cm3" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carEngineCapacity", namespace = "http://www.przyklad.pl/showroom", propOrder = {
        "value"
})
public class CarEngineCapacity {

    @XmlValue
    protected short value;
    @XmlAttribute(name = "unit")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String unit;

    /**
     * Gets the value of the value property.
     */
    public short getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     */
    public void setValue(short value) {
        this.value = value;
    }

    /**
     * Gets the value of the unit property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUnit() {
        if (unit == null) {
            return "cm3";
        } else {
            return unit;
        }
    }

    /**
     * Sets the value of the unit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUnit(String value) {
        this.unit = value;
    }

}
