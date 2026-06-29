/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.dao;

import meditrack.model.Konsultasi;
import meditrack.util.DatabaseConnection;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAOKonsultasi {
    public boolean simpan(Konsultasi k) {
        String sql = "INSERT INTO konsultasi (id_pasien, id_dokter, tanggal_konsultasi, keluhan) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, k.getIdPasien());
            ps.setInt(2, k.getIdDokter());
            ps.setString(3, k.getTanggalKonsultasi());
            ps.setString(4, k.getKeluhan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 
    public boolean ubah(Konsultasi k) {
        String sql = "UPDATE konsultasi SET id_pasien=?, id_dokter=?, tanggal_konsultasi=?, keluhan=? WHERE id_konsultasi=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, k.getIdPasien());
            ps.setInt(2, k.getIdDokter());
            ps.setString(3, k.getTanggalKonsultasi());
            ps.setString(4, k.getKeluhan());
            ps.setInt(5, k.getIdKonsultasi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 
    public boolean hapus(int idKonsultasi) {
        String sql = "DELETE FROM konsultasi WHERE id_konsultasi=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idKonsultasi);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 
    public List<Konsultasi> getAll() {
        List<Konsultasi> list = new ArrayList<>();
        String sql = "SELECT * FROM konsultasi";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Konsultasi k = new Konsultasi(
                    rs.getInt("id_konsultasi"),
                    rs.getInt("id_pasien"),
                    rs.getInt("id_dokter"),
                    rs.getString("tanggal_konsultasi"),
                    rs.getString("keluhan")
                );
                list.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM konsultasi";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
