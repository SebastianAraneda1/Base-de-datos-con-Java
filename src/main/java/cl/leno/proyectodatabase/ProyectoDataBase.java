/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.leno.proyectodatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sebas
 */
public class ProyectoDataBase {

    public static void main(String[] args) throws SQLException{
        System.out.println("Hello World!");
        Connection connection = null;
        //El statement es esencial para ejecutar las consultas a la base de datos
        Statement statement = null;
        //El resultset son los resultados de la consulta a una base de datos, es un paquete donde se meten datos
        ResultSet resultSet = null;
        
        try {
            
            //connection = DriverManager.getConnection(DBUtils.MYSQL_DB, DBUtils.MYSQL_USER, DBUtils.MYSQL_PASS);
            
            connection = DBUtils.getConnection(DBType.MYSQLDB);
            
            //*****OBTENER*****
            //Solo recibes la consulta con INSENSITIVE pero no las actualizaciones o lo que pase despues
            //El READ_ONLY solo es de lectura, solo ver, no habran cambios.
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT * FROM usuarios");
            
            //*****INSERTAR*****
            //Los cuatro signos de interrogación son las columnas
            /*String sql = "INSERT INTO usuarios VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "1005");
            preparedStatement.setString(2, "Max");
            preparedStatement.setString(3, "Salchica");
            preparedStatement.setString(4, "Frances");
            
            int result = preparedStatement.executeUpdate();
            
            if (result == 1) {
                System.out.println("Insertado");
            }else{
                System.out.println("No se ha podido insertar");
            }*/ //El usuario ya esta insertado
            
            //*****ACTUALIZAR*****
            //Los signos de interrogación significa que se espera a recibir una variable
            /*String sql = "UPDATE usuarios SET nacionalidad = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //El numero indica el signo de interrogación que tomara la variable.
            preparedStatement.setString(1, "Argentino");
            preparedStatement.setString(2, "1003");
            
            int result = preparedStatement.executeUpdate();
            
            if (result == 1) {
                System.out.println("Actualizado");
            }else{
                System.out.println("No se ha podido actualizar");
            }*/ //Usuario actualizado
            
            //*****DELETE*****
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1005");
            
            int result = preparedStatement.executeUpdate();
            
            if (result == 1) {
                System.out.println("Eliminado");
            }else{
                System.out.println("No se ha podido eliminar");
            }
            
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") +
                        resultSet.getString("nombre") +
                        resultSet.getString("apellido") +
                        resultSet.getString("nacionalidad"));
            }
            
        } catch (SQLException e) {
            DBUtils.processException(e);
        }
        finally{
            if(statement != null){
                statement.close();;
            }
            if(resultSet != null){
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
