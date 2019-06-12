package generated;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for metadata complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="metadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="comment" type="{http://www.przyklad.pl/showroom}comment"/>
 *         &lt;element name="author" type="{http://www.przyklad.pl/showroom}student" maxOccurs="2" minOccurs="2"/>
 *         &lt;element name="modificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metadata", namespace = "http://www.przyklad.pl/showroom", propOrder = {
        "commentOrAuthorOrModificationDate"
})
public class Metadata {

    @XmlElements({
            @XmlElement(name = "comment", type = String.class),
            @XmlElement(name = "author", type = Student.class),
            @XmlElement(name = "modificationDate", type = XMLGregorianCalendar.class)
    })
    protected List<Object> commentOrAuthorOrModificationDate;

    /**
     * Gets the value of the commentOrAuthorOrModificationDate property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commentOrAuthorOrModificationDate property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommentOrAuthorOrModificationDate().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link Student }
     * {@link XMLGregorianCalendar }
     */
    public List<Object> getCommentOrAuthorOrModificationDate() {
        if (commentOrAuthorOrModificationDate == null) {
            commentOrAuthorOrModificationDate = new ArrayList<Object>();
        }
        return this.commentOrAuthorOrModificationDate;
    }

}
