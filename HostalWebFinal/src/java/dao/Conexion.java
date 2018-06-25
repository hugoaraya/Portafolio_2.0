/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 420NiggaBytes
 */
public class Conexion {

   
    public Conexion() {
    }
    private String classfor = "oracle.jdbc.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "hostal";
    private String pass = "1234";
    private Connection con = null;
    
    public Connection fabricarConexion(){
                        
            try{
                Class.forName(classfor);
                con = DriverManager.getConnection(url, user, pass);
            return con;
            }catch(Exception ex){
                System.err.println("No se pudo conectar a la BD");
            ex.printStackTrace();
            System.exit(1); 
            return null; 
            }
    }
    
    
    
}
