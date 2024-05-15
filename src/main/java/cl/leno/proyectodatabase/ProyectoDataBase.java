/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.leno.proyectodatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class ProyectoDataBase {

    public static void main(String[] args) throws SQLException{
        System.out.println("Hello World!");
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadatabase", "leno", "123456a");   
            System.out.println("Conectado!!!");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido el siguiente error: " + e);
        }
        finally{
            if (connection != null) {
                connection.close();
            }
        }
    }
}
