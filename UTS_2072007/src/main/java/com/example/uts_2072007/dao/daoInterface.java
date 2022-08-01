package com.example.uts_2072007.dao;

import javafx.collections.ObservableList;

public interface daoInterface<T> {
    ObservableList<T> getData();
    void addData(T data);
    int deleteData(T data);
    int updateData(T data);
}
