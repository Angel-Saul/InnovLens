/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.conexionDB;
import dto.dtoProducto;
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
 *
 */
public class productoDAO {

    public dtoProducto create(dtoProducto producto) {

        String sql = "INSERT INTO producto (nombre_producto, descripcion, categoria,precio, cantidad) VALUES "
                + "('" + producto.getNombreProducto() + "' , '" + producto.getDescripcion() + "', '" + producto.getCategoria() + "','" + producto.getPrecio() + "','" + producto.getCantidad() + "');";
        try {
            Connection con = conexionDB.obtenerConexion();
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    producto.setIdProducto(idGenerado);
                    System.out.println("ID generado: " + idGenerado);
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos: " + e.getMessage());
            e.printStackTrace();
        }

        return producto;
    }
    //DAO Edicion de producto

    public boolean update(dtoProducto producto) {
        String sql = "UPDATE producto SET nombre_producto = '"
                + producto.getNombreProducto() + "', descripcion = '" + producto.getDescripcion() + "', "
                + "categoria = '" + producto.getCategoria() + "', cantidad ='" + producto.getCantidad() + "' "
                + "WHERE id_producto = " + producto.getIdProducto();
        //System.out.print(sql);
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar el expediente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    //DAO mostrar productos

    public static List<dtoProducto> mostrarProductos() {
        List<dtoProducto> listaProd = new ArrayList<>();
        String sql = "SELECT id_producto, nombre_producto, descripcion, categoria, precio, cantidad FROM producto";

        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id_producto") + " - " + rs.getString("nombre_producto") + " - " + rs.getInt("cantidad"));
                dtoProducto producto = new dtoProducto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("descripcion"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad")
                );
                listaProd.add(producto);
            }
        } catch (SQLException ex) {
            System.err.println("Error al cargar poductos: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listaProd;
    }

    public boolean delete(Integer id) {
        String sql = "DELETE FROM producto WHERE id_producto = " + id;
        System.out.print(sql);
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
