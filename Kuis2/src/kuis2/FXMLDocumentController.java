/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Vio
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label tanggal;
    @FXML
    private DatePicker tanngal;
    @FXML
    private TextField id;
    @FXML
    private Label harga;
    @FXML
    private TextField scanner;
    @FXML
    private ComboBox<?> warna;
    @FXML
    private Button btnsimpan;
    @FXML
    private TableView<Scanner> tabelview;
    @FXML
    private TableColumn<Scanner, Integer> no;
    @FXML
    private TableColumn<Scanner, String> scannerview;
    @FXML
    private TableColumn<Scanner, String> tanggalview;
    @FXML
    private TableColumn<Scanner, String> warnaview;
    @FXML
    private TableColumn<Scanner, String> hargaview;
    @FXML
    private Button btnedit;
    @FXML
    private Button btnhapus;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       if(event.getSource() == btnsimpan){
            insertRecord();
        }else if (event.getSource() == btnedit){
            updateRecord();
        }else if(event.getSource() == btnhapus){
            deleteButton();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showScanner();
        ArrayList <String> list = new ArrayList<String>();
        list.add("Merah");
        list.add("Biru");
        list.add("Hitam");
        list.add("Pink");
        ObservableList items = FXCollections.observableArrayList(list);
        warna.setItems(items);
    }    
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dekstop", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<Scanner> getScannerList(){
        ObservableList<Scanner> scannerList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM kuis";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Scanner scanner;
            while(rs.next()){
                scanner = new Scanner(rs.getInt("id"), rs.getString("scanner"), rs.getString("harga"), rs.getString("warna"),rs.getString("tanggal"));
                scannerList.add(scanner);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return scannerList;
    }

    private void insertRecord() {
        String query = "INSERT INTO kuis VALUES (" + id.getText() + ",'" + scanner.getText() + "','" + tanggal.getText() + "',"
                + warna.getValue().toString() + "," + harga.getText() + ")";
        executeQuery(query);
        showScanner();
    }

    private void updateRecord() {
        String query = "UPDATE kuis SET scanner  = '" + scanner.getText() + "', warna = '" + warna.getValue().toString() + "', tanggal = " +
                tanggal.getText() + ", harga = " + harga.getText() + " WHERE id = " + id.getText() + "";
        executeQuery(query);
        showScanner();
    }

    private void deleteButton() {
       String query = "DELETE FROM kuis WHERE id =" + id.getText() + "";
        executeQuery(query);
        showScanner();
    }

    private void showScanner() {
        ObservableList<Scanner> list = getScannerList();
        
        no.setCellValueFactory(new PropertyValueFactory<Scanner, Integer>("id"));
        scannerview.setCellValueFactory(new PropertyValueFactory<Scanner, String>("scanner"));
        tanggalview.setCellValueFactory(new PropertyValueFactory<Scanner, String>("tanggal"));
        warnaview.setCellValueFactory(new PropertyValueFactory<Scanner, String>("warna"));
        hargaview.setCellValueFactory(new PropertyValueFactory<Scanner, String>("harga"));
        
        tabelview.setItems(list);
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
