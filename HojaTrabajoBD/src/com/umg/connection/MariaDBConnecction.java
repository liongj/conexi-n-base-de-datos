 package com.umg.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MariaDBConnecction {

	 private static final String URL = "jdbc:mariadb://localhost:3306/productos?permitMysqlScheme";

	    private static final String USUARIO = "root";

	    private static final String CONTRASE�A = "47211815";

	    

	    public static Connection getConnection() {

	        Connection conn = null;

	        try {

	            Class.forName("org.mariadb.jdbc.Driver");

	            conn = DriverManager.getConnection(URL, USUARIO, CONTRASE�A);

	            return conn;

	        } catch (SQLException e) {

	            System.out.println("Error al conectar a la base de datos: " + e.getMessage());

	            return null;

	        } catch (ClassNotFoundException e) {

	            System.out.println("No se encontr� el controlador JDBC" + e.toString());

	            return null;

	        }

	    }
}

