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

public class WListDao implements daoInterface<watchlist>{
    public ObservableList<watchlist> SelectedList(user data) {
        ObservableList<watchlist> wList;
        wList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "SELECT w.idWatchList,w.LastWatch, w.Favorite,m.idMovie, m.Title AS Judul, m.Genre,m.Durasi, u.idUser, u.UserName,u.UserPassword FROM WatchList w JOIN Movie m ON w.Movie_idMovie = m.idMovie JOIN user u ON w.User_idUser = u.idUser WHERE w.User_idUser = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1,data.getIdUser());
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                int idWatchList = hasil.getInt("idWatchList");
                int LastWatch = hasil.getInt("LastWatch");
                int Favorite = hasil.getInt("Favorite");
                int idMovie = hasil.getInt("idMovie");
                String judul = hasil.getString("Judul");
                String genre = hasil.getString("Genre");
                int durasi = hasil.getInt("Durasi");
                movie m = new movie(idMovie,judul,genre,durasi);
                int idUser = hasil.getInt("idUser");
                String username = hasil.getString("UserName");
                String password = hasil.getString("UserPassword");
                user u = new user(idUser,username,password);
                watchlist w = new watchlist(idWatchList,LastWatch,Favorite,m,u);
                wList.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wList;
    }

    @Override
    public ObservableList<watchlist> getData() {
        ObservableList<watchlist> wList;
        wList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "SELECT w.idWatchList,w.LastWatch, w.Favorite,m.idMovie, m.Title AS Judul, m.Genre,m.Durasi, u.idUser, u.UserName,u.UserPassword FROM WatchList w JOIN Movie m ON w.Movie_idMovie = m.idMovie JOIN user u ON w.User_idUser = u.idUser";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                int idWatchList = hasil.getInt("idWatchList");
                int LastWatch = hasil.getInt("LastWatch");
                int Favorite = hasil.getInt("Favorite");
                int idMovie = hasil.getInt("idMovie");
                String judul = hasil.getString("Judul");
                String genre = hasil.getString("Genre");
                int durasi = hasil.getInt("Durasi");
                movie m = new movie(idMovie,judul,genre,durasi);
                int idUser = hasil.getInt("idUser");
                String username = hasil.getString("UserName");
                String password = hasil.getString("UserPassword");
                user u = new user(idUser,username,password);
                watchlist w = new watchlist(idWatchList,LastWatch,Favorite,m,u);
                wList.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wList;
    }

    @Override
    public void addData(watchlist data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "INSERT INTO WatchList(idWatchList,LastWatch,Favorite,Movie_idMovie,User_idUser) values(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdWatchList());
            ps.setInt(2, data.getLastWatch());
            ps.setInt(3,data.getFavorite());
            ps.setInt(4,data.getMovie_idMovie().getIdMovie());
            ps.setInt(5,data.getUser_idUser().getIdUser());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Berhasil Add ygy");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteData(watchlist data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "DELETE FROM WatchList WHERE idWatchList = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdWatchList());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int updateData(watchlist data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "UPDATE WatchList set LastWatch = ?, Favorite = ?, Movie_idMovie = ?, User_idUser = ? WHERE idWatchList = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getLastWatch());
            ps.setInt(2, data.getFavorite());
            ps.setInt(3, data.getMovie_idMovie().getIdMovie());
            ps.setInt(4, data.getUser_idUser().getIdUser());
            ps.setInt(5, data.getIdWatchList());

            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }
}
