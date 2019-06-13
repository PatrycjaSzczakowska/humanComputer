package GUI;

import generated.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import logic.XMLOperations;

import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextField xmlName = new TextField();
    @FXML
    public TextField xsdName = new TextField();
    @FXML
    public TextField xmlToSaveName = new TextField();
    @FXML
    public TextField htmlPathToSave = new TextField();


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
            openWrongValueWindow(e.getMessage());
        }
        showroom = XMLOperations.carShowroom;
        mainTab();
    }

    public void changeXml() {
        XMLOperations.setXmlFilePath(xmlName.getText());
        try {
            XMLOperations.readFromXML();
        } catch (JAXBException | FileNotFoundException e) {
            openWrongValueWindow(e.getMessage());
        }
        showroom = XMLOperations.carShowroom;
    }

    public void changeXmlToSave() {
        XMLOperations.setXmlToSaveFilePath(xmlToSaveName.getText());
    }

    private void mainTab() {
        xmlName.setText(XMLOperations.getXmlFilePath());
        xsdName.setText(XMLOperations.getXsdFilePath());
        xmlToSaveName.setText(XMLOperations.getXmlToSaveFilePath());
    }

    public void toHtml() {
        String path = htmlPathToSave.getText();
        transformToXHTML(path);
    }

    private boolean saveXMLFile() {
        try {
            XMLOperations.saveToXML();
        } catch (Exception e) {
            File filePath = new File(xmlToSaveName.getText());
            filePath.delete();
            openErrorWindow(((MarshalException) e).getLinkedException().getLocalizedMessage());
            return false;
        }
        return true;
    }

    private void openErrorWindow(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Error during saving xml");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void openWrongValueWindow(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Wrong value");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void transformToXHTML(String path)
    {
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
        try {
            showroom.getMetadata().getCommentOrAuthorOrModificationDate().set(0, komentarz.getText());
            ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(1)).setValue(imie1.getText());
            ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(1)).setIndex(new BigInteger(index1.getText()));
            ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(2)).setValue(imie2.getText());
            ((Student) showroom.getMetadata().getCommentOrAuthorOrModificationDate().get(2)).setIndex(new BigInteger(index2.getText()));
            showroom.getMetadata().getCommentOrAuthorOrModificationDate().set(3, DatatypeFactory.newInstance().newXMLGregorianCalendar(modyfikacja.getValue().toString()));
            saveXMLFile();
        } catch (DatatypeConfigurationException e) {
            openWrongValueWindow("Wrong value for one of the values. XML will NOT be saved.");
        }
    }

    public void brands() {
        brandList();
        brandContinent.setItems(FXCollections.observableArrayList(ContinentEnum.values()));
    }

    private void brandList() {
        brandList.getItems().clear();
        ArrayList<String> brands = new ArrayList<>();
        for (Brand brand :
                showroom.getBrands().getBrand()) {
            brands.add(brand.getName());
        }
        brandList.getItems().addAll(brands);
    }

    public void selectBrand() {
        Brand brand = showroom.getBrands().getBrand()
                .stream()
                .filter(b -> b.getName().equals(brandList.getSelectionModel().getSelectedItem()))
                .findFirst()
                .get();

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
        showroom.getBrands().getBrand()
                .stream()
                .filter(b -> b.getName().equals(brandList.getSelectionModel().getSelectedItem()))
                .forEach(b -> toRemove.add(b));
        showroom.getBrands().getBrand().removeAll(toRemove);
        if (saveXMLFile()) {
            clearBrand();
            brandList();
            brandList.getSelectionModel().selectFirst();
        } else {
            showroom.getBrands().getBrand().addAll(toRemove);
        }
    }

    private void clearBrand() {
        brandId.clear();
        brandName.clear();
        brandCountry.clear();
        brandContinent.setValue(ContinentEnum.EUROPE);
        brandChairman.clear();
        brandHeadquarter.clear();
    }

    public void selectCar() {
        Car car = showroom.getCars().getCar()
                .stream()
                .filter(b -> b.getId().equals(carList.getSelectionModel().getSelectedItem()))
                .findFirst()
                .get();

        carId.setText(car.getId());
        carBrandId.setValue(car.getBrandId());
        carModel.setText(car.getModel().getValue());
        carModelVersion.setText(car.getModel().getVersion());
        carType.setText(car.getType().getValue());
        carTypeDoors.setText(car.getType().getDoors().toString());
        carTypeSeats.setText(car.getType().getSeats().toString());
        carProduction.setText(String.valueOf(car.getProduction().get(0).getValue()));
        carProductionStart.setText(String.valueOf(car.getProduction().get(0).getStart()));
        carProductionEnd.setText(String.valueOf(car.getProduction().get(0).getEnd() == null ? "" : car.getProduction().get(0).getEnd()));
        carEngineFuel.setValue(car.getEngine().getFuel() == null ? FuelEnum.PETROL : car.getEngine().getFuel());
        carEngineCylinders.setText(String.valueOf(car.getEngine().getCylindersNumber()));
        carEnginePower.setText(String.valueOf(car.getEngine().getPower().getValue()));
        carEngineCapacity.setText(String.valueOf(car.getEngine().getCapacity().getValue()));
        carWheeldrive.setText(car.getWheeldrive().getValue());
        carWheeldriveAutomatic.setSelected(car.getWheeldrive().getAutomatic().trim().toUpperCase().equals("Y"));
        carCondition.setText(car.getCondition().getValue());
        carConditionMileage.setText(car.getCondition().getMileage());
        carConditionAccidentFree.setSelected(car.getCondition().getAccidentfree().trim().toUpperCase().equals("Y"));
        carLaquer.setText(car.getLacquer());
        carPrice.setText(String.valueOf(car.getPrice().getValue()));
    }

    public void updateCar() {
        try {
            showroom.getCars().getCar()
                    .stream()
                    .filter(c -> c.getId().equals(carList.getSelectionModel().getSelectedItem()))
                    .forEach(c -> {
                        c.setId(carId.getText());
                        c.setBrandId(carBrandId.getValue());
                        c.getModel().setValue(carModel.getText());
                        c.getModel().setVersion(carModelVersion.getText());
                        c.getType().setValue(carType.getText());
                        c.getType().setDoors(new BigInteger(carTypeDoors.getText()));
                        c.getType().setSeats(new BigInteger(carTypeSeats.getText()));
                        c.getProduction().get(0).setValue(Short.valueOf(carProduction.getText()));
                        if (!carProductionEnd.getText().isEmpty()) {
                            c.getProduction().get(0).setEnd(Short.valueOf(carProductionEnd.getText()));
                        }
                        c.getProduction().get(0).setStart(Short.valueOf(carProductionStart.getText()));
                        c.getEngine().setFuel(carEngineFuel.getValue());
                        c.getEngine().getCapacity().setValue(Short.valueOf(carEngineCapacity.getText()));
                        c.getEngine().getPower().setValue(Short.valueOf(carEnginePower.getText()));
                        c.getEngine().setCylindersNumber(Byte.valueOf(carEngineCylinders.getText()));
                        c.getWheeldrive().setValue(carWheeldrive.getText());
                        c.getWheeldrive().setAutomatic(carWheeldriveAutomatic.isSelected() ? "y" : "n");
                        c.getCondition().setValue(carCondition.getText());
                        c.getCondition().setMileage(carConditionMileage.getText());
                        c.getCondition().setAccidentfree(carConditionAccidentFree.isSelected() ? "y" : "n");
                        c.setLacquer(carLaquer.getText());
                        c.getPrice().setValue(Integer.valueOf(carPrice.getText()));
                    });
            saveXMLFile();
        } catch (Exception e) {
            openWrongValueWindow("Wrong value for one of values. XML will NOT be saved.");
        }
    }

    public void createCar() {
        Car newCar = new Car();
        newCar.setId("c" + (carList.getItems().size() + 1));
        newCar.setBrandId(carBrandId.getItems().get(0));
        newCar.setModel(new CarModel());
        newCar.getModel().setValue("setModel");
        newCar.getModel().setVersion("setVersion");
        newCar.setType(new CarType());
        newCar.getType().setValue("setType");
        newCar.getType().setDoors(BigInteger.valueOf(5));
        newCar.getType().setSeats(BigInteger.valueOf(5));
        newCar.getProduction().add(new CarProduction());
        newCar.getProduction().get(0).setValue(Short.valueOf("2019"));
        newCar.getProduction().get(0).setStart(Short.valueOf("2019"));
        newCar.setEngine(new CarEngine());
        newCar.getEngine().setFuel(carEngineFuel.getValue());
        newCar.getEngine().setCapacity(new CarEngineCapacity());
        newCar.getEngine().getCapacity().setValue(Short.valueOf("100"));
        newCar.getEngine().setPower(new CarEnginePower());
        newCar.getEngine().getPower().setValue(Short.valueOf("10"));
        newCar.getEngine().setCylindersNumber(Byte.valueOf("10"));
        newCar.setWheeldrive(new CarWheeldrive());
        newCar.getWheeldrive().setValue("setCarWheeldrive");
        newCar.getWheeldrive().setAutomatic("n");
        newCar.setCondition(new CarCondition());
        newCar.getCondition().setValue("setCondition");
        newCar.getCondition().setMileage("cerConditionMileage");
        newCar.getCondition().setAccidentfree("y");
        newCar.setLacquer("setCarLacquer");
        newCar.setPrice(new CarPrice());
        newCar.getPrice().setValue(Integer.valueOf("1000"));
        newCar.getPrice().setCurrency("$");

        showroom.getCars().getCar().add(newCar);
        carList();
        carList.getSelectionModel().selectLast();
        selectCar();
        saveXMLFile();
    }

    public void deleteCar() {
        ArrayList<Car> toRemove = new ArrayList<>();
        showroom.getCars().getCar()
                .stream()
                .filter(c -> c.getId().equals(carList.getSelectionModel().getSelectedItem()))
                .forEach(c -> toRemove.add(c));
        showroom.getCars().getCar().removeAll(toRemove);
        if (saveXMLFile()) {
            clearCar();
            carList();
            carList.getSelectionModel().selectFirst();
        }
    }

    private void clearCar() {
        carId.clear();
        carModel.clear();
        carModelVersion.clear();
        carType.clear();
        carTypeDoors.clear();
        carTypeSeats.clear();
        carProduction.clear();
        carProductionStart.clear();
        carProductionEnd.clear();
        carEngineCylinders.clear();
        carEnginePower.clear();
        carEngineCapacity.clear();
        carWheeldrive.clear();
        carWheeldriveAutomatic.setSelected(false);
        carCondition.clear();
        carConditionMileage.clear();
        carConditionAccidentFree.setSelected(false);
        carLaquer.clear();
        carPrice.clear();
    }

    public void cars() {
        carList();
        brandIds();
        carEngineFuel.setItems(FXCollections.observableArrayList(FuelEnum.values()));
    }

    private void carList() {
        ArrayList<String> cars = new ArrayList<>();
        for (Car car :
                showroom.getCars().getCar()) {
            cars.add(car.getId());
        }
        carList.setItems(FXCollections.observableArrayList(cars));
    }

    private void brandIds() {
        carBrandId.getItems().clear();
        for (Brand brand :
                showroom.getBrands().getBrand()) {
            carBrandId.getItems().add(brand.getId());
        }
    }

}