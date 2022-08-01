package com.example.uts_2072007.model;

public class watchlist {
    private int idWatchList;
    private int LastWatch;
    private int Favorite;
    private movie Movie_idMovie;
    private user User_idUser;

    public String getDurationAndLastWatch(){
        return LastWatch + "/" + Movie_idMovie.getDurasi();
    }

    public String getTrueOrFalse() {
        if (Favorite == 1) {
            return "True";
        } else {
            return "False";
        }
    }

    public watchlist(int idWatchList, int lastWatch, int favorite, movie movie_idMovie, user user_idUser) {
        this.idWatchList = idWatchList;
        LastWatch = lastWatch;
        Favorite = favorite;
        Movie_idMovie = movie_idMovie;
        User_idUser = user_idUser;
    }

    public int getIdWatchList() {
        return idWatchList;
    }

    public void setIdWatchList(int idWatchList) {
        this.idWatchList = idWatchList;
    }

    public int getLastWatch() {
        return LastWatch;
    }

    public void setLastWatch(int lastWatch) {
        LastWatch = lastWatch;
    }

    public int getFavorite() {
        return Favorite;
    }

    public void setFavorite(int favorite) {
        Favorite = favorite;
    }

    public movie getMovie_idMovie() {
        return Movie_idMovie;
    }

    public void setMovie_idMovie(movie movie_idMovie) {
        Movie_idMovie = movie_idMovie;
    }

    public user getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(user user_idUser) {
        User_idUser = user_idUser;
    }
}
