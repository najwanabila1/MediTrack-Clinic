/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import meditrack.model.Pasien;
import meditrack.util.DatabaseConnection;


/**
 *
 * @author admin
 */
public class PasienDAO {
    public boolean simpan(Pasien pasien) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "INSERT INTO pasien(nama_pasien, umur, jenis_kelamin, alamat, no_hp) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasien.getNama());
            ps.setInt(2, pasien.getUmur());
            ps.setString(3, pasien.getJenisKelamin());
            ps.setString(4, pasien.getAlamat());
            ps.setString(5, pasien.getNoHp());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
    e.printStackTrace();
    return false;
        }
    }
         public ArrayList<Pasien> getAll() {
        ArrayList<Pasien> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM pasien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasien p = new Pasien();

                p.setIdPasien(rs.getInt("id_pasien"));
                p.setNama(rs.getString("nama_pasien"));
                p.setUmur(rs.getInt("umur"));
                p.setJenisKelamin(rs.getString("jenis_kelamin"));
                p.setAlamat(rs.getString("alamat"));
                p.setNoHp(rs.getString("no_hp"));

                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
