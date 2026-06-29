/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meditrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import meditrack.model.Dokter;
import meditrack.util.DatabaseConnection;

/**
 *
 * @author admin
 */
public class DAODokter {
    Connection conn = DatabaseConnection.getConnection();

    // Simpan Data
    public boolean simpan(Dokter dokter) {

        try {

            String sql = "INSERT INTO dokter(nama_dokter, spesialis, no_hp) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dokter.getNama());
            ps.setString(2, dokter.getSpesialis());
            ps.setString(3, dokter.getNoHp());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Ubah Data
    public boolean ubah(Dokter dokter) {

        try {

            String sql = "UPDATE dokter SET nama_dokter=?, spesialis=?, no_hp=? WHERE id_dokter=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dokter.getNama());
            ps.setString(2, dokter.getSpesialis());
            ps.setString(3, dokter.getNoHp());
            ps.setInt(4, dokter.getIdDokter());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Hapus Data
    public boolean hapus(int id) {

        try {

            String sql = "DELETE FROM dokter WHERE id_dokter=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Ambil Semua Data
    public ArrayList<Dokter> getAll() {

        ArrayList<Dokter> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM dokter";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Dokter dokter = new Dokter();

                dokter.setIdDokter(rs.getInt("id_dokter"));
                dokter.setNama(rs.getString("nama_dokter"));
                dokter.setSpesialis(rs.getString("spesialis"));
                dokter.setNoHp(rs.getString("no_hp"));

                list.add(dokter);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // Hitung Jumlah Data Dokter
    public int getCount() {

        int jumlah = 0;

        try {

            String sql = "SELECT COUNT(*) FROM dokter";

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