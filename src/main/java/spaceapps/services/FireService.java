package spaceapps.services;

import spaceapps.domain.Cords;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class FireService {
    private Connection conn;

    public void FireService() {
        connectDatabase();
    }

    private void connectDatabase() {
        String url = "jdbc:postgresql://localhost/test";
        Properties props = new Properties();
        props.setProperty("user", "fred");
        props.setProperty("password", "secret");
        props.setProperty("ssl", "true");
        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
        }
    }

    public ArrayList<Cords> extractFires() {
        String query = "SELECT latitude, longitude FROM fire";
        ArrayList<Cords> resultado = new ArrayList<Cords>();
        double latitude, longitude;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                latitude = rs.getDouble("latitude");
                longitude = rs.getDouble("longitude");
                Cords cords = new Cords(latitude,longitude);
                resultado.add(cords);
            }
        } catch (SQLException e) {
        }
        return resultado;
    }
}
