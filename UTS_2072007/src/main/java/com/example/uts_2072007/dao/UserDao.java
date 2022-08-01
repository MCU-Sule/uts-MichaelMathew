package com.example.uts_2072007.dao;

import com.example.uts_2072007.model.movie;
import com.example.uts_2072007.model.user;
import com.example.uts_2072007.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements daoInterface<user>{

    @Override
    public ObservableList<user> getData() {
        ObservableList<user> uList;
        uList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "SELECT * FROM User";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                int id = hasil.getInt("idUser");
                String name = hasil.getString("UserName");
                String password = hasil.getString("UserPassword");
                user u = new user(id, name, password);
                uList.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return uList;
    }

    @Override
    public void addData(user data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "INSERT INTO User(idUser,UserName, UserPassword) values(?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdUser());
            ps.setString(2, data.getUserName());
            ps.setString(3,data.getUserPassword());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Berhasil Add ygy");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteData(user data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "DELETE FROM User WHERE idUser = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdUser());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int updateData(user data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "UPDATE User set UserName = ?, UserPassword = ? WHERE idUser = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setString(1, data.getUserName());
            ps.setString(2, data.getUserPassword());
            ps.setInt(3, data.getIdUser());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }
}
