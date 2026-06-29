/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.model;

/**
 *
 * @author admin
 */
public class Dokter {
    private int idDokter;
    private String nama;
    private String spesialis;
    private String noHp;
 
    public Dokter() {}
 
    public int getIdDokter() { return idDokter; }
    public void setIdDokter(int idDokter) { this.idDokter = idDokter; }
 
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
 
    public String getSpesialis() { return spesialis; }
    public void setSpesialis(String spesialis) { this.spesialis = spesialis; }
 
    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
}
