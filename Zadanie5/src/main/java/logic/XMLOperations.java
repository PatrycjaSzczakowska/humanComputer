package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import generated.CarShowroom;
import org.xml.sax.SAXException;

public class XMLOperations {

    private static JAXBContext jaxbContext;
    private static Unmarshaller unmarshaller;
    private static Marshaller marshaller;
    private static Schema schema;

    private static String xmlFilePath;
    private static String xmlToSaveFilePath;
    private static String xsdFilePath;
    private static String summaryFilePath;
    private static String htmlSchema;


    public static CarShowroom carShowroom;

    static {
        xmlFilePath = "Auta.xml";
        xmlToSaveFilePath = "Auta2.xml";
        xsdFilePath = "Showroom.xsd";
        summaryFilePath = "AutaPodsumowanie.xml";
        htmlSchema = "AutaToHtml.xsl";

        try {
            jaxbContext = JAXBContext.newInstance(CarShowroom.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema(new File(xsdFilePath));
            marshaller = jaxbContext.createMarshaller();
            marshaller.setSchema(schema);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, xsdFilePath);
            unmarshaller.setSchema(schema);
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void saveToXML() throws Exception {
        marshaller.marshal(carShowroom, new File(xmlToSaveFilePath));
    }

    public static void readFromXML() throws JAXBException, FileNotFoundException {
        carShowroom = (CarShowroom) unmarshaller.unmarshal(new FileInputStream(new File(xmlFilePath)));
    }

    public static void transformXML(String transformedName) throws Exception{
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File(htmlSchema));
            Transformer transformer = factory.newTransformer(xslt);

            Source text = new StreamSource(new File(summaryFilePath));
            transformer.transform(text, new StreamResult(new File(transformedName)));
    }

    public static String getXmlFilePath() {
        return xmlFilePath;
    }

    public static String getXsdFilePath() {
        return xsdFilePath;
    }

    public static void setXmlFilePath(String xmlFilePath) {
        XMLOperations.xmlFilePath = xmlFilePath;
    }

    public static String getXmlToSaveFilePath() {
        return xmlToSaveFilePath;
    }

    public static void setXmlToSaveFilePath(String xmlToSaveFilePath) {
        XMLOperations.xmlToSaveFilePath = xmlToSaveFilePath;
    }
}