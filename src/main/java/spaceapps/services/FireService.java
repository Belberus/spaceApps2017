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

    public ArrayList<Cords> extractFull_Data() {
        String query = "SELECT latf,longf,dis,lata,longa,bri,dis_reserva FROM datos_finales";
        ArrayList<Cords> resultado = new ArrayList<Cords>();
        double latf,longf,dis,lata,longa,bri,dis_reserva;
        try {
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                latf = rs.getDouble("latf");
                longf = rs.getDouble("longf");
                dis = rs.getDouble("dis");
                lata = rs.getDouble("lata");
                longa = rs.getDouble("longa");
                bri = rs.getDouble("bri");
                dis_reserva = rs.getDouble("dis_reserva");
                double dis2 = ((dis-4214.82)/45867.9)*(10/3);
                double bri2 = ((bri-269.6)/38.6)*(10/3);
                double dis_reserva2 = (1-((dis_reserva-729.66)/43817.66))*(10/3);
                Cords cords = new Cords(latf,longf,dis2+bri2+dis_reserva2,lata,longa);
                resultado.add(cords);
            }
        } catch (SQLException e) {
        }
        return resultado;
    }
}
