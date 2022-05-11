/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis1;

/**
 *
 * @author Vio
 */
public class Scanner {
   private String merek , tanggal ,warna , jenis ; 
   private int harga ; 
   
   public Scanner (int id, int harga, String merek, String tanggal, String warna, String jenis) { 
       
       this.harga = harga ; 
       this.jenis = jenis ; 
       this.merek = merek ; 
       this.tanggal = tanggal ; 
       this.warna = warna ; 
   }
   
   public Scanner (){ 
    
}

    public String getMerek() {
        return merek;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getWarna() {
        return warna;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
   
}
