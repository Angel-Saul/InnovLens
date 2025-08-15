/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.conexionDB;
import dto.dtoExpediente;
import dto.dtoUsuarios;
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
public class usuariosDAO {
    //DAO creacion nuevo usuario
        public dtoUsuarios create(dtoUsuarios usuarios) {

        String sql = "INSERT INTO usuario (nombre,correo,contraseña) VALUES ('" + usuarios.getNombre()+ "' , '" + usuarios.getCorreo() + "', '" + usuarios.getCorreo() + "', '" + usuarios.getContra()+ "');";
        try {
            Connection con = conexionDB.obtenerConexion();
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    usuarios.setId_usuario(idGenerado);
                    System.out.println("ID generado: " + idGenerado);
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos: " + e.getMessage());
            e.printStackTrace();
        }

        return usuarios;
    }
    //Edicion de usuario
         public boolean update(dtoUsuarios usuarios) {
        String sql = "UPDATE usuario SET nombre = '" + usuarios.getNombre() + "', telefono = '" + usuarios.getCorreo() + "', historial = '" + usuarios.getContra() + "' WHERE id_expediente = " + usuarios.getId_usuario();
  
        
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar el expediente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    //DAO Mostrar usuarios 
          public static List<dtoUsuarios> mostrarTodos() {
        List<dtoUsuarios> lista = new ArrayList<>();
        String sql = "SELECT id_usuario, nombre, correo, id_rol, contraseña FROM usuario";
        
        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                dtoUsuarios usuarios = new dtoUsuarios(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getInt("id_rol")
                );
                lista.add(usuarios);
            }
        } catch (SQLException ex) {
            System.err.println("Error al cargar expedientes: " + ex.getMessage());
            ex.printStackTrace();
        }
        return lista;
    }
    //DAO Eliminar Usuarios 
          public boolean delete(Integer id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = " + id;
        System.out.print(sql);
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
        
 
/*
public class UsuarioDAO {

    public List<Usuario> buscarUsuarios(String nombre) {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, correo, rol FROM usuarios WHERE nombre LIKE ?";

        try (Connection conn = conexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("rol")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
*/
        
}
