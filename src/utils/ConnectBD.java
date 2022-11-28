package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBD {
    private String mySQLDriver;
    private String api;
    private String  typeBD;
    private String nomServeur;
    private String port;
    private String nomBD;
    private String username;
    private String password;

    public ConnectBD() {
        this.mySQLDriver = "com.mysql.jdbc.Driver";
        this.api = "jdbc";
        this.typeBD = "mysql";
        this.nomServeur = "localhost";
        this.port = "3306";
        this.nomBD = "gestion_residences";
        this.username = "root";
        this.password = "";
    }

    public Connection connexionBD(){
        Connection conn = null;
        try {
            //étape 1: charger la classe de driver
            Class.forName(this.mySQLDriver);

            //étape 2: création de l'objet de connexion
            conn = DriverManager.getConnection(this.api+":"+this.typeBD+"://"+this.nomServeur+":"+this.port+"/"+this.nomBD, this.username, this.password);

            //étape 3: création de l'objet statement
            //Statement stmt = conn.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}
