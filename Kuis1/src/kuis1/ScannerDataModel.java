/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import kuis1.db.DBHelper;

/**
 *
 * @author Vio
 */
public class ScannerDataModel {
    
    private final Connection conn ;

    public ScannerDataModel() throws SQLException{ 
        
        this.conn =DBHelper.getConnection();
    }
    
    public void addScanner(Scanner scan ){ 
        String insertscanner = "INSERT INTO `scanner`(`tanggal`, `merek`, `harga`, `jenis`, `warna`) "
                + "VALUES ('"
                +scan.getTanggal()+"','"
                +scan.getMerek()+"','"
                +scan.getHarga()+"','"
                +scan.getJenis()+"','"
                +scan.getWarna()+"')";
        
    
    
    try { 
     PreparedStatement scanner = (PreparedStatement) conn.prepareStatement(insertscanner); 
     
     scanner.execute();
    }
    catch(Exception e){
        System.out.println("eror "+e);
    }
}
}

