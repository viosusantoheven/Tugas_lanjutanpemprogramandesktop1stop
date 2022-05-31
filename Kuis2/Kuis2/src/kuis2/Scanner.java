/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis2;

/**
 *
 * @author Vio
 */
public class Scanner {
    private String scanner , harga , warna , tanggal ; 
    private int id ; 
    
    public Scanner(int id, String scanner, String harga, String warna, String tanggal){ 
        
        this.id = id; 
        this.scanner = scanner ; 
        this.tanggal = tanggal ; 
        this.warna = warna ; 
        this.harga = harga ; 
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}


