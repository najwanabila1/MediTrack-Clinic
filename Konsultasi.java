/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.model;

/**
 *
 * @author admin
 */
public class Konsultasi {
    private int idKonsultasi;
    private int idPasien;
    private int idDokter;
    private String tanggalKonsultasi;
    private String keluhan;
 
    public Konsultasi() {}
 
    public Konsultasi(int idKonsultasi, int idPasien, int idDokter, String tanggalKonsultasi, String keluhan) {
        this.idKonsultasi = idKonsultasi;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.tanggalKonsultasi = tanggalKonsultasi;
        this.keluhan = keluhan;
    }
 
    public int getIdKonsultasi() { return idKonsultasi; }
    public void setIdKonsultasi(int idKonsultasi) { this.idKonsultasi = idKonsultasi; }
 
    public int getIdPasien() { return idPasien; }
    public void setIdPasien(int idPasien) { this.idPasien = idPasien; }
 
    public int getIdDokter() { return idDokter; }
    public void setIdDokter(int idDokter) { this.idDokter = idDokter; }
 
    public String getTanggalKonsultasi() { return tanggalKonsultasi; }
    public void setTanggalKonsultasi(String tanggalKonsultasi) { this.tanggalKonsultasi = tanggalKonsultasi; }
 
    public String getKeluhan() { return keluhan; }
    public void setKeluhan(String keluhan) { this.keluhan = keluhan; }
}
