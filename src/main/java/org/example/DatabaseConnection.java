package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

import static java.sql.DriverManager.getConnection;

public class DatabaseConnection {
    String url = "jdbc:postgresql://localhost:5432/nazwa_bazy";
    String username = "twój_login";
    String password = "twoje_hasło";
    Connection connection = null;

    public DatabaseConnection() {
        try {
            connection = getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace(); // Obsługa błędów
        }
    }

    public ResultSet sendQuery(String query) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);//nie wiem czy to ma sens czy nie lepiej to implementować w każdym dao osobno
            return preparedStatement.executeQuery();

          } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendUpdate(String query){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
