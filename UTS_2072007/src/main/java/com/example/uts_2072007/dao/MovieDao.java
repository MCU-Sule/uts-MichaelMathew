package com.example.uts_2072007.dao;

import com.example.uts_2072007.model.movie;
import com.example.uts_2072007.model.user;
import com.example.uts_2072007.model.watchlist;
import com.example.uts_2072007.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDao implements daoInterface<movie> {
    @Override
    public ObservableList<movie> getData() {
        ObservableList<movie> mList;
        mList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "SELECT * FROM Movie";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                int id = hasil.getInt("idMovie");
                String judul = hasil.getString("Title");
                String genre = hasil.getString("Genre");
                int durasi = hasil.getInt("Durasi");
                movie m = new movie(id, judul, genre,durasi);
                mList.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mList;
    }

    public ObservableList<movie> FilterData(String data) {
        ObservableList<movie> mList;
        mList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "SELECT * FROM Movie WHERE Genre LIKE '%' ? '%'";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setString(1,data);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                int id = hasil.getInt("idMovie");
                String judul = hasil.getString("Title");
                String genre = hasil.getString("Genre");
                int durasi = hasil.getInt("Durasi");
                movie m = new movie(id, judul, genre,durasi);
                mList.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mList;
    }
    @Override
    public void addData(movie data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "INSERT INTO Movie(idMovie,Title,Genre,Durasi) values(?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdMovie());
            ps.setString(2, data.getTitle());
            ps.setString(3,data.getGenre());
            ps.setInt(4,data.getDurasi());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Berhasil Add ygy");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteData(movie data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "DELETE FROM Movie WHERE idMovie = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdMovie());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int updateData(movie data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "UPDATE Movie set Title = ?, Genre = ?,Durasi = ? WHERE idMovie = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setString(1, data.getTitle());
            ps.setString(2, data.getGenre());
            ps.setInt(3, data.getDurasi());
            ps.setInt(4, data.getIdMovie());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }
}
