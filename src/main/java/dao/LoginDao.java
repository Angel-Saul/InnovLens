/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.conexionDB;
import dto.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jonhy
 */
public class LoginDao {
    
    public Boolean login (String usuario, String password){
        //UserDto user  = new UserDto();
        Boolean isUser = false;
        //, nombre, correo, id_rol
        String sql =  "SELECT id_usuario FROM usuario WHERE correo = '" + usuario+"' and contraseña = '"+ password +"'";
        try (
                Connection con = conexionDB.obtenerConexion();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()){
            while (rs.next()) {
                isUser =true;
                break;
            } 
        } catch (SQLException e) {
            System.err.println("Error al obtener los roles: " + e.getMessage());
            e.printStackTrace();
        }
        return isUser;
    }
    

    public UserDto getUserData(String usuario, String password){
        UserDto user  = new UserDto();
        
        String sql =  "SELECT id_usuario, nombre, correo, id_rol  FROM usuario WHERE correo = '" + usuario+"' and contraseña = '"+ password +"'";
        try {
                Connection con = conexionDB.obtenerConexion();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user.setCorreo(rs.getString("correo"));
                user.setId(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setRol(rs.getInt("id_rol"));
                break;
            } 
        } catch (SQLException e) {
            System.err.println("Error al obtener los roles: " + e.getMessage());
            e.printStackTrace();
        }
        
        return user;
    }
    
}
