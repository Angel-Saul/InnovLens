/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.conexionDB;
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
public class expedienteDAO {

    public dtoExpediente create(dtoExpediente expediente) {

        String sql = "INSERT INTO expediente (nombre, telefono, historial) VALUES ('" + expediente.getNombre() + "' , '" + expediente.getTelefono() + "', '" + expediente.getHistorial() + "');";
        try {
            Connection con = conexionDB.obtenerConexion();
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    expediente.setId(idGenerado);
                    System.out.println("ID generado: " + idGenerado);
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos: " + e.getMessage());
            e.printStackTrace();
        }

        return expediente;
    }

    //DAO Edicion de Expediente
    public boolean update(dtoExpediente expediente) {
        String sql = "UPDATE expediente SET nombre = '" + expediente.getNombre() + "', telefono = '" + expediente.getTelefono() + "', historial = '" + expediente.getHistorial() + "' WHERE id_expediente = " + expediente.getId();
  
        
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar el expediente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    //DAO mostrar expedientes 

    public static List<dtoExpediente> mostrarTodos() {
        List<dtoExpediente> lista = new ArrayList<>();
        String sql = "SELECT id_expediente, nombre, telefono, historial FROM expediente";
        
        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                dtoExpediente expediente = new dtoExpediente(
                        rs.getInt("id_expediente"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("historial")
                );
                lista.add(expediente);
            }
        } catch (SQLException ex) {
            System.err.println("Error al cargar expedientes: " + ex.getMessage());
            ex.printStackTrace();
        }
        return lista;
    }

    //DAO Eliminar expedientes 
    public boolean delete(Integer id) {
        String sql = "DELETE FROM expediente WHERE id_Expediente = " + id;
        System.out.print(sql);
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar el expediente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
