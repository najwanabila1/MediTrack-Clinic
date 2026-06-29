/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import meditrack.model.Pasien;
import meditrack.util.DatabaseConnection;
/**
 *
 * @author admin
 */
public class DAOPasien {
   Connection conn = DatabaseConnection.getConnection();

    public boolean simpan(Pasien pasien) {

        try {

            String sql = "INSERT INTO pasien(nama_pasien,umur,jenis_kelamin,alamat,no_hp) VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasien.getNama());
            ps.setInt(2, pasien.getUmur());
            ps.setString(3, pasien.getJenisKelamin());
            ps.setString(4, pasien.getAlamat());
            ps.setString(5, pasien.getNoHp());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean ubah(Pasien pasien) {

        try {

            String sql = "UPDATE pasien SET nama_pasien=?, umur=?, jenis_kelamin=?, alamat=?, no_hp=? WHERE id_pasien=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasien.getNama());
            ps.setInt(2, pasien.getUmur());
            ps.setString(3, pasien.getJenisKelamin());
            ps.setString(4, pasien.getAlamat());
            ps.setString(5, pasien.getNoHp());
            ps.setInt(6, pasien.getIdPasien());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean hapus(int id) {

        try {

            String sql = "DELETE FROM pasien WHERE id_pasien=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public ArrayList<Pasien> getAll() {

        ArrayList<Pasien> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM pasien";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Pasien pasien = new Pasien();

                pasien.setIdPasien(rs.getInt("id_pasien"));
                pasien.setNama(rs.getString("nama_pasien"));
                pasien.setUmur(rs.getInt("umur"));
                pasien.setJenisKelamin(rs.getString("jenis_kelamin"));
                pasien.setAlamat(rs.getString("alamat"));
                pasien.setNoHp(rs.getString("no_hp"));

                list.add(pasien);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
     public int getCount() {

        int jumlah = 0;

        try {

            String sql = "SELECT COUNT(*) FROM pasien";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                jumlah = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return jumlah;
    }
}
