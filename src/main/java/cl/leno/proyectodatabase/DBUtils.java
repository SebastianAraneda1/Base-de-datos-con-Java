package cl.leno.proyectodatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class DBUtils {
    
    protected static final String MYSQL_DB = "jdbc:mysql://localhost:3306/javadatabase";
    protected static final String MYSQL_USER = "leno";
    protected static final String MYSQL_PASS = "123456a";
    
    protected static final String ORACLE_DB = "x";
    protected static final String ORACLE_USER = "x";
    protected static final String ORACLE_PASS = "x";
    
    public static Connection getConnection(DBType dbType) throws SQLException{
        switch(dbType){
            case MYSQLDB:
                return DriverManager.getConnection(MYSQL_DB, MYSQL_USER, MYSQL_PASS);
                
            case ORACLEDB:
                return DriverManager.getConnection(ORACLE_DB, ORACLE_USER, ORACLE_PASS);
                
            default:
                return null;
        }
    }
    
    //Manejar error de mejor manera
    public static void processException(SQLException sqlex){
        System.err.println("Error: " + sqlex.getMessage());
        System.err.println("Codigo: " + sqlex.getErrorCode());
        System.err.println("Estado SQL: " + sqlex.getSQLState());
    }
}
