package br.com.ramon.locadora.model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    //String de conexao do MySQL

    private static final String STR_CONEXAO =
            "jdbc:mysql://localhost:2206/";
    //Nome da base de dados criada no MySQL
    private static final String DATABASE = "locadoraDB";
    //Usuario do MySQL
    private static final String USER = "root";
    //Senha do MySQL
    private static final String PASSWORD = "";

    //Metodo que retorna a conexao
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(STR_CONEXAO + DATABASE + USER + PASSWORD);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    //Metodo fecha conexao
    public static void closeConnection(Connection con) throws SQLException{
        if(con != null){
            con.close();
        }
    }
    //Metodo que fecha o Statement
    public static void closeConnection(Connection con, Statement stmt) throws SQLException{
        if(stmt != null){
            stmt.close();
        }
        closeConnection(con);
    }
    
    //Metodo que fecha o ResultSet
    public static void closeConnection(Connection con, Statement stmt, ResultSet rs) throws SQLException{
        
        if(rs != null){
        rs.close();
            }
        closeConnection(con,stmt);
    }
}
