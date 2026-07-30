import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    private static final String TABLA = "clientes";

    public boolean registrar(Clientes cliente) {
        String sql = "INSERT INTO " + TABLA + " (nombre, correo, telefono, ciudad) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCiudad());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Clientes> listar() {
        List<Clientes> clientes = new ArrayList<>();
        String sql = "SELECT id, nombre, correo, telefono, ciudad FROM " + TABLA + " ORDER BY id";

        try (Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setNombres(rs.getString("nombre"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCiudad(rs.getString("ciudad"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar clientes: " + e.getMessage());
        }

        return clientes;
    }
}