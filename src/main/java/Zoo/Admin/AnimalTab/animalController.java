package Zoo.Admin.AnimalTab;

import com.group12.explorewild.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class animalController implements Initializable {


    @FXML
    private TableColumn<Animal, String> editCol;
    String query=null;
    Connection conn = DBconnection.getConnection() ;
    //conn=DBconnection.getConnection();
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
    void refresh() {


        try {
            AnimalList.clear();
            query="SELECT * FROM animal";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            while(rs.next()){

                AnimalList.add(new Animal(rs.getInt("id"),rs.getString("name"),rs.getString("family"),rs.getDate("birthday")));
                animalTable.setItems(AnimalList);




            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadData();
        refresh();
    }



     Animal animal=null;

     ObservableList<Animal> AnimalList= FXCollections.observableArrayList();

    private void LoadData() {
        conn=DBconnection.getConnection();

        idCol.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<Animal,String>("name"));
        BirthdayCol.setCellValueFactory(new PropertyValueFactory<Animal,String>("date"));
        familyCol.setCellValueFactory(new PropertyValueFactory<Animal,String>("family"));
    }


}
