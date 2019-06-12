package GUI;

import generated.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import logic.XMLOperations;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextField imie1 = new TextField();
    @FXML
    public TextField imie2 = new TextField();
    @FXML
    public TextField index1 = new TextField();
    @FXML
    public TextField index2 = new TextField();
    @FXML
    public TextField komentarz = new TextField();
    @FXML
    public DatePicker modyfikacja = new DatePicker();
    @FXML
    public TextField xmlName = new TextField();
    @FXML
    public TextField xsdName = new TextField();
    @FXML
    public TextField htmlPathToSave = new TextField();

    @FXML
    public ListView brandList = new ListView();
    @FXML
    public TextField brandId = new TextField();
    @FXML
    public TextField brandName = new TextField();
    @FXML
    public TextField brandCountry = new TextField();
    @FXML
    public ChoiceBox<ContinentEnum> brandContinent = new ChoiceBox<>();
    @FXML
    public TextField brandHeadquarter = new TextField();
    @FXML
    public TextField brandChairman = new TextField();

    @FXML
    public ListView carList = new ListView();
    @FXML
    public TextField carId = new TextField();
    @FXML
    public ChoiceBox<String> carBrandId = new ChoiceBox<>();
    @FXML
    public TextField carModel = new TextField();
    @FXML
    public TextField carModelVersion = new TextField();
    @FXML
    public TextField carType = new TextField();
    @FXML
    public TextField carTypeDoors = new TextField();
    @FXML
    public TextField carTypeSeats = new TextField();
    @FXML
    public TextField carProduction = new TextField();
    @FXML
    public TextField carProductionStart = new TextField();
    @FXML
    public TextField carProductionEnd = new TextField();
    @FXML
    public ChoiceBox<FuelEnum> carEngineFuel = new ChoiceBox<>();
    @FXML
    public TextField carEngineCylinders = new TextField();
    @FXML
    public TextField carEnginePower = new TextField();
    @FXML
    public TextField carEngineCapacity = new TextField();
    @FXML
    public TextField carWheeldrive = new TextField();
    @FXML
    public CheckBox carWheeldriveAutomatic = new CheckBox();
    @FXML
    public TextField carCondition = new TextField();
    @FXML
    public TextField carConditionMileage = new TextField();
    @FXML
    public CheckBox carConditionAccidentFree = new CheckBox();
    @FXML
    public TextField carLaquer = new TextField();
    @FXML
    public TextField carPrice = new TextField();


    private static CarShowroom showroom = XMLOperations.carShowroom;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            XMLOperations.readFromXML();
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        showroom = XMLOperations.carShowroom;
        mainTab();
    }

    private void mainTab() {
        xmlName.setText(XMLOperations.getXmlFilePath());
        xsdName.setText(XMLOperations.getXsdFilePath());
    }

    public void toHtml() {
        String path = htmlPathToSave.getText();
        transformToXHTML(path);
    }

    private void saveXMLFile() {
        try {
            XMLOperations.saveToXML("Auta2");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void transformToXHTML(String path) {
        XMLOperations.transformXML(path);
    }

    public void metadane() {
        imie1.setText(((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(1)).getValue());
        imie2.setText(((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(2)).getValue());
        index1.setText(((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(1)).getIndex().toString());
        index2.setText(((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(2)).getIndex().toString());
        komentarz.setText(((String) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(0)));
        modyfikacja.setValue(LocalDate.parse(String.valueOf(
                ((XMLGregorianCalendar) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(3)))));
    }

    public void saveMetainfo() {
        showroom.getMetadata().getCommentOrAuthorOrModificationDate().set(0, komentarz.getText());
        ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(1)).setValue(imie1.getText());
        ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(1)).setIndex(new BigInteger(index1.getText()));
        ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(2)).setValue(imie2.getText());
        ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(2)).setIndex(new BigInteger(index2.getText()));

        try {
            showroom.getMetadata().getCommentOrAuthorOrModificationDate().set(3, DatatypeFactory.newInstance().newXMLGregorianCalendar(modyfikacja.getValue().toString()));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        saveXMLFile();
    }

    public void brands() {
        brandList();
        brandContinent.setItems(FXCollections.observableArrayList(ContinentEnum.values()));
    }

    private void brandList() {
        ArrayList<String> brands = new ArrayList<>();
        for (Brand brand :
                showroom.getBrands().getBrand()) {
            brands.add(brand.getName());
        }
        brandList.setItems(FXCollections.observableArrayList(brands));
    }

    public void selectCar() {

    }

    public void updateCar() {

        saveXMLFile();
    }

    public void createCar() {

        saveXMLFile();
    }

    public void deleteCar() {

        saveXMLFile();
    }

    public void cars() {
        carList();
    }

    private void carList() {
        ArrayList<String> cars = new ArrayList<>();
        for (Car car :
                showroom.getCars().getCar()) {
            cars.add(car.getId()+":"+car.getModel().getValue());
        }
        carList.setItems(FXCollections.observableArrayList(cars));
    }

    public void selectBrand() {
        Brand brand = showroom.getBrands().getBrand()
                .stream()
                .filter(b -> b.getName().equals(brandList.getSelectionModel().getSelectedItem())).findFirst().get();

        brandId.setText(brand.getId());
        brandName.setText(brand.getName());
        brandCountry.setText(brand.getCountry().getValue());
        brandContinent.setValue(brand.getCountry().getContinent());
        brandChairman.setText(brand.getChairman());
        brandHeadquarter.setText(brand.getHeadquarters().get(0));
    }

    public void updateBrand() {
        showroom.getBrands().getBrand()
                .stream()
                .filter(b -> b.getName().equals(brandList.getSelectionModel().getSelectedItem()))
                .forEach(b -> {
                    b.setId(brandId.getText());
                    b.setName(brandName.getText());
                    b.getCountry().setValue(brandCountry.getText());
                    b.getCountry().setContinent(brandContinent.getValue());
                    b.setChairman(brandChairman.getText());
                    b.getHeadquarters().set(0, brandHeadquarter.getText());
                });
        saveXMLFile();
    }

    public void createBrand() {
        Brand newBrand = new Brand();
        newBrand.setId("setId");
        newBrand.setName("setName");
        newBrand.setChairman("setChairman");
        newBrand.setCountry(new BrandCountry());
        newBrand.getCountry().setValue("setCountry");
        newBrand.getCountry().setContinent(ContinentEnum.EUROPE);
        newBrand.getHeadquarters().add("setHeadquarter");

        showroom.getBrands().getBrand().add(newBrand);
        brandList();
        brandList.getSelectionModel().selectLast();
        selectBrand();
        saveXMLFile();
    }

    public void deleteBrand() {
        ArrayList<Brand> toRemove = new ArrayList<>();
        String name = brandList.getSelectionModel().getSelectedItem().toString();
        showroom.getBrands().getBrand()
                .stream()
                .filter(b -> b.getName().equals(brandList.getSelectionModel().getSelectedItem()))
                .forEach(b -> toRemove.add(b));
        showroom.getBrands().getBrand().removeAll(toRemove);
        brandList();
        brandList.getSelectionModel().selectFirst();
        selectBrand();
        saveXMLFile();
    }

}