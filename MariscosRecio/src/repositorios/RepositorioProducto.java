package repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Producto;

public class RepositorioProducto {

	public static ArrayList<Producto> getAll() {
		String consulta = "SELECT * FROM producto";
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		
		try {
			Statement stm = Conector.conexion.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			
			while (rs.next()) {
				Producto producto = new Producto(rs.getInt("id_producto"), rs.getInt("stock"), rs.getDouble("precio_unitario"), rs.getString("nombre"));
				
				listaProductos.add(producto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaProductos;
	}
	
}