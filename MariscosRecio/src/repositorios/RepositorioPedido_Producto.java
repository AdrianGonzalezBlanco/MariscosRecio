package repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pedido_Producto;

public class RepositorioPedido_Producto {
	
	public static ArrayList<Pedido_Producto> getAll() {
		String consulta = "SELECT * FROM pedido_producto";
		ArrayList<Pedido_Producto> listaPedidos_Productos = new ArrayList<Pedido_Producto>();
		
		try {
			Statement stm = Conector.conexion.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			
			while (rs.next()) {
				Pedido_Producto pedido_producto = new Pedido_Producto(rs.getInt("id_pedido"), rs.getInt("id_producto"), rs.getInt("cantidad"), rs.getInt("precio"));
				
				listaPedidos_Productos.add(pedido_producto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaPedidos_Productos;
	}

}