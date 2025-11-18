package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

	protected static Connection conexion;

	// abrir conexion con la base de datos
	public static void conectar() {
		try {
			// cargamos el driver, el driver es la libreria que nos permite conectarnos a la BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver cargado");
			
			try {
				// establecemos la conexion con la BD, con su direccion, usuario y contraseña
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/mariscos_recio","root","280505");
				System.out.println("conexion establecida");
			} catch (Exception e) {
				System.out.println("error en la conexion");
			}
		} catch (Exception e) {
			System.out.println("error en el driver"  + e.getMessage());
		}
	}

	// cerrar conexion con la base de datos
	public static void desconectar() throws SQLException {
		conexion.close();
	}

}