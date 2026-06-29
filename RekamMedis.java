/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.model;

/**
 *
 * @author admin
 */
public class RekamMedis {
     private int idRekam;
    private int idKonsultasi;
    private String diagnosa;
    private String tindakan;
    private String obat;
 
    public RekamMedis() {}
 
    public RekamMedis(int idRekam, int idKonsultasi, String diagnosa, String tindakan, String obat) {
        this.idRekam = idRekam;
        this.idKonsultasi = idKonsultasi;
        this.diagnosa = diagnosa;
        this.tindakan = tindakan;
        this.obat = obat;
    }
 
    public int getIdRekam() { return idRekam; }
    public void setIdRekam(int idRekam) { this.idRekam = idRekam; }
 
    public int getIdKonsultasi() { return idKonsultasi; }
    public void setIdKonsultasi(int idKonsultasi) { this.idKonsultasi = idKonsultasi; }
 
    public String getDiagnosa() { return diagnosa; }
    public void setDiagnosa(String diagnosa) { this.diagnosa = diagnosa; }
 
    public String getTindakan() { return tindakan; }
    public void setTindakan(String tindakan) { this.tindakan = tindakan; }
 
    public String getObat() { return obat; }
    public void setObat(String obat) { this.obat = obat; }
}
