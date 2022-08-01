package com.example.uts_2072007.model;

public class user {
    private int idUser;
    private String UserName;
    private String UserPassword;

    public user(int idUser, String userName, String userPassword) {
        this.idUser = idUser;
        UserName = userName;
        UserPassword = userPassword;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    @Override
    public String toString() {
        return UserName;
    }
}
