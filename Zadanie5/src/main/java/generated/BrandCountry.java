
package generated;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for brandCountry complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="brandCountry">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *       &lt;attribute name="continent" type="{http://www.przyklad.pl/showroom}continentEnum" default="Europe" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brandCountry", namespace = "http://www.przyklad.pl/showroom", propOrder = {
        "value"
})
public class BrandCountry {

    @XmlValue
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String value;
    @XmlAttribute(name = "continent")
    protected ContinentEnum continent;

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
     * Gets the value of the continent property.
     *
     * @return possible object is
     * {@link ContinentEnum }
     */
    public ContinentEnum getContinent() {
        if (continent == null) {
            return ContinentEnum.EUROPE;
        } else {
            return continent;
        }
    }

    /**
     * Sets the value of the continent property.
     *
     * @param value allowed object is
     *              {@link ContinentEnum }
     */
    public void setContinent(ContinentEnum value) {
        this.continent = value;
    }

}
