/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.dtoExpediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonhy
 */
public class registrosDAO {

  /*  public List<dtoExpediente> obtenerExpedientes() {
        List<dtoExpediente> registro = new ArrayList<>();
        String sql = "SELECT id_Expediente, nombre, telefono, historial FROM optica";
        try (Connection con = conexion.conexionDB.obtenerConexion(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Integer id_Expediente = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String historial = rs.getString("historial");
                registro.add(new dtoExpediente(id_Expediente, nombre, rs.getString("telefono"), rs.getString("historial")));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el registro: " + e.getMessage());
            e.printStackTrace();
        }
        return registro;
    }*/
    
    
}
