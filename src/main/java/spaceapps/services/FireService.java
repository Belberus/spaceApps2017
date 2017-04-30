package spaceapps.services;

import spaceapps.domain.Cords;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class FireService {
    private Connection conn;

    public FireService() {
        connectDatabase();
    }

    private void connectDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://10.10.11.61:5432/spaceapps";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "root");
        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.err.println("Error iniciando conn.");
            e.printStackTrace();

        }
    }

    public ArrayList<Cords> extractFires() {
        String query = "SELECT bri, lat, lon, dis FROM final";
        ArrayList<Cords> resultado = new ArrayList<Cords>();
        double latitude, longitude,bri,dis;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                latitude = rs.getDouble("lat");
                longitude = rs.getDouble("lon");
                dis = rs.getDouble("dis");
                bri = rs.getDouble("bri");
                double dis2 = ((dis-729)/43819)*5;
                double bri2 = ((bri-269.6)/38.6)*5;
                Cords cords = new Cords(latitude,longitude,dis2+bri2);
                resultado.add(cords);
            }
        } catch (SQLException e) {
        }
        return resultado;
    }
}
