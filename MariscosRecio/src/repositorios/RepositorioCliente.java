package repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;

public class RepositorioCliente {

	public static ArrayList<Cliente> getAll() {
		String consulta = "SELECT * FROM cliente";
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try {
			Statement stm = Conector.conexion.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			
			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("dni"), rs.getString("mail"), rs.getString("contraseña"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("numero_telf"));
				
				listaClientes.add(cliente);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	
}