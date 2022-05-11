/**
 * Sample Skeleton for 'FXMLDocument.fxml' Controller Class
 */

package kuis1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tanggal"
    private DatePicker tanggal; // Value injected by FXMLLoader

    @FXML // fx:id="merek"
    private TextField merek; // Value injected by FXMLLoader

    @FXML // fx:id="harga"
    private TextField harga; // Value injected by FXMLLoader

    @FXML // fx:id="jenis"
    private ComboBox<String> jenis; // Value injected by FXMLLoader

    @FXML // fx:id="warna"
    private TextField warna; // Value injected by FXMLLoader

    @FXML // fx:id="simpan"
    private Button simpan; // Value injected by FXMLLoader

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tanggal != null : "fx:id=\"tanggal\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert merek != null : "fx:id=\"merek\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert harga != null : "fx:id=\"harga\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert jenis != null : "fx:id=\"jenis\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert warna != null : "fx:id=\"warna\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert simpan != null : "fx:id=\"simpan\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
       
        ScannerDataModel datamodel = new ScannerDataModel();
        
       Scanner scan = new Scanner();
       scan.setTanggal(tanggal.getValue().toString());
       scan.setMerek(merek.getText());
       scan.setHarga(Integer.parseInt(harga.getText()));
       scan.setJenis((String) jenis.getValue());
       scan.setWarna(warna.getText());
       
       datamodel.addScanner(scan);
        
    }
     
   @Override
    public void initialize(URL url, ResourceBundle rb) {
       ArrayList <String> list = new ArrayList<String>();
        list.add("Scanner Drum");
        list.add("Scanner Flatbed");
        list.add("Barcode scanner");
        list.add("Scanner X-Ray");
        ObservableList items = FXCollections.observableArrayList(list);
        jenis.setItems(items);
        
    }
}


        
        
