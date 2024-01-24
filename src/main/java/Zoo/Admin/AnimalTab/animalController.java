package Zoo.Admin.AnimalTab;

import com.group12.explorewild.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class animalController implements Initializable {



    String query=null;
    Connection conn=DBconnection.getConnection();

    ResultSet rs=null;
    PreparedStatement pst=null;



    @FXML
    private TableView<Animal> animalTable;

    @FXML
    private TableColumn<Animal, String> BirthdayCol;

    @FXML
    private TableColumn<Animal, String> NameCol;

    @FXML
    private TableColumn<Animal, String> familyCol;

    @FXML
    private TableColumn<Animal, Integer> idCol;

    @FXML
    private DatePicker animalDateBox;

    @FXML
    private TextField animalFamilyBox;

    @FXML
    private Label animalID;

    @FXML
    private Label animalIdBox;

    @FXML
    private TextField animalNameBox;

    @FXML
    private TextField animalSearchBox;

    @FXML
    private Button remove;

    @FXML
    private Button updateAnimalBtn;
    @FXML
    private Button addAnimal;


    SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
    Animal animal=null;

    ObservableList<Animal> AnimalList= FXCollections.observableArrayList();

    @FXML
    void removeAnimalOnAction(ActionEvent event) {
        deleteAnimal();
    }

    @FXML
    void updateAnimalOnAction(ActionEvent event) {
        updateAnimal();

    }
    @FXML
    void tableToBoxes(MouseEvent event) {
        animal=animalTable.getSelectionModel().getSelectedItem();

        animalIdBox.setText(String.valueOf(animal.getId()));
        animalNameBox.setText(animal.getName());
        LocalDate date=LocalDate.parse(animal.getDate());
        animalDateBox.setValue(date);

        animalFamilyBox.setText(animal.getFamily());

    }

    private void deleteAnimal(){
        animal=animalTable.getSelectionModel().getSelectedItem();


        int id=animal.getId();
        String sql="DELETE from animal WHERE id= ?";


        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,id);
            int r=pst.executeUpdate();
            System.out.println("=== "+r+" Rows deleted ===");

            refresh();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void updateAnimal(){




        String sql="UPDATE animal SET name=? , birthday=? , family =? WHERE id=? ";

        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,animalNameBox.getText());


            Date date = java.sql.Date.valueOf((animalDateBox.getValue()));
            String dD= dd.format(date);

            pst.setString(2,dD);
            pst.setString(3,animalFamilyBox.getText());

            pst.setString(4,animalIdBox.getText());

            pst.execute();
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    @FXML
    void refresh() {


        try {
            AnimalList.clear();
            query="SELECT * FROM animal";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            while(rs.next()){

                AnimalList.add(new Animal(rs.getInt("id"),rs.getString("name"),rs.getString("birthday"),rs.getString("family")));
                animalTable.setItems(AnimalList);




            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void searchAnimal(){
        String sb=animalSearchBox.getText();
        String sql = "Select *  from animal where id LIKE '%" + sb + "%' OR name LIKE '%" + sb + "%' OR  birthday like '%" + sb + "%' OR family like '%" + sb + "%' ";

        try {
            AnimalList.clear();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            while(rs.next()){
                AnimalList.add(new Animal(rs.getInt("id"),rs.getString("name"),rs.getString("birthday"),rs.getString("family")));
                animalTable.setItems(AnimalList);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    private void LoadData() {


        idCol.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<Animal,String>("name"));
        BirthdayCol.setCellValueFactory(new PropertyValueFactory<Animal,String>("date"));
        familyCol.setCellValueFactory(new PropertyValueFactory<Animal,String>("family"));
    }


    private void addAnimal(){
        animalNameBox.getText();



        String sql="INSERT INTO animal(name,birthday,family) VALUES(?,?,?)";

        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,animalNameBox.getText());


            Date date = java.sql.Date.valueOf((animalDateBox.getValue()));
            String dD= dd.format(date);

            pst.setString(2,dD);
            pst.setString(3,animalFamilyBox.getText());

            pst.execute();
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void addAnimalOnAction(ActionEvent event) {
        addAnimal();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadData();
        refresh();


        remove.setDisable(true);

        // Add a listener to enable/disable the delete button based on row selection
        animalTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                remove.setDisable(false);
            } else {
                remove.setDisable(true);
            }
        });
    }


}
