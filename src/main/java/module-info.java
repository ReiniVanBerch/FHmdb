module at.ac.fhcampuswien.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.jfoenix;
    requires jdk.httpserver;
    requires okhttp3;
    requires junit;
    requires hamcrest.core;
    requires com.google.gson;
    requires ormlite.jdbc;
    requires java.sql;


    opens at.ac.fhcampuswien.fhmdb to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb;
}