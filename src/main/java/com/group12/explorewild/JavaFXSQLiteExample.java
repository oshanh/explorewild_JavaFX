package com.group12.explorewild;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaFXSQLiteExample extends Application {
    //Class.forName("org.sqlite.JDBC");
    //private static final String DATABASE_URL = "jdbc:sqlite:explporewild.db";
    //conn=DriverManager.getConnection("jdbc:sqlite:"+sqLiteDB);
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello JavaFX!");

        try {
            // Connect to SQLite database
            Connection connection = DBconnection.getConnection();

            // Insert a date into the database
            insertDate(connection, "2024-01-12");

            // Retrieve the date from the database
            Date retrievedDate = retrieveDate(connection);
            label.setText("Retrieved Date: " + retrievedDate);

            connection.close();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            label.setText("Error: " + e.getMessage());
        }

        Scene scene = new Scene(label, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX SQLite Example");
        primaryStage.show();
    }

    private void insertDate(Connection connection, String dateString) throws SQLException, ParseException {
        String insertQuery = "INSERT INTO test (birthday) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateString);
            preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
            preparedStatement.executeUpdate();
        }
    }

    private Date retrieveDate(Connection connection) throws SQLException {
        String retrieveQuery = "SELECT birthday FROM test LIMIT 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(retrieveQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                java.sql.Date sqlDate = resultSet.getDate("birthday");
                return new Date(sqlDate.getTime());
            }
        }
        throw new SQLException("No date found in the database");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
