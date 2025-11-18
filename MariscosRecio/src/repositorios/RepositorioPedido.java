package repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pedido;

public class RepositorioPedido {

	public static ArrayList<Pedido> getAll() {
		String consulta = "SELECT * FROM pedido";
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		try {
			Statement stm = Conector.conexion.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			
			while (rs.next()) {
				Pedido pedido = new Pedido(rs.getInt("id_pedido"), rs.getInt("id_cliente"), rs.getInt("id_empleado"), rs.getDate("fecha"), rs.getDouble("precio_total"), rs.getBoolean("entregado"));
				
				listaPedidos.add(pedido);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaPedidos;
	}
	
}