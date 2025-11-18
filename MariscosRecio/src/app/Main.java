package app;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import modelo.Pedido;
import modelo.Pedido_Producto;
import modelo.Producto;
import repositorios.Conector;
import repositorios.RepositorioPedido;
import repositorios.RepositorioPedido_Producto;
import repositorios.RepositorioProducto;

public class Main {

	public static void main(String[] args) throws SQLException {
		Conector.conectar();

		String opcion;

		do {
			System.out.println("\n----  🦐  Mariscos Recio  🦐  ----");
			System.out.println("1. Generar XML de Pedidos");
			System.out.println("0. Salir");
			System.out.println();

			System.out.print("Seleccione una opción: ");

			Scanner teclado = new Scanner(System.in);
			opcion = teclado.nextLine();

			switch (opcion) {
			case "1" -> generarXML();
			case "0" -> System.out.println("Saliendo...");
			default -> System.out.println("Introduce una opcion válida");
			}

			System.out.println();
		} while (!opcion.equals("0"));

		try {
			Conector.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void generarXML() {
		ArrayList<Pedido> listaPedidos = RepositorioPedido.getAll();
		ArrayList<Pedido_Producto> listaPedidoProductos = RepositorioPedido_Producto.getAll();
		ArrayList<Producto> listaProductos = RepositorioProducto.getAll();
		
		try {
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dBF.newDocumentBuilder();
			
			Document doc = dB.newDocument();
			
			Element pedidos = doc.createElement("pedidos");
			doc.appendChild(pedidos);
			
			for (Pedido p : listaPedidos) {
				Element pedido = doc.createElement("pedido");
				pedido.setAttribute("idPedido", String.valueOf(p.getId_pedido()));
				pedido.setAttribute("idCliente", String.valueOf(p.getId_cliente()));
				pedido.setAttribute("idEmpleado", String.valueOf(p.getId_empleado()));
				pedidos.appendChild(pedido);
				
				Element productos = doc.createElement("productos");
				pedido.appendChild(productos);
				
				for (Pedido_Producto pp : listaPedidoProductos) {
					if (p.getId_pedido() == pp.getId_pedido()) {
						Element producto = doc.createElement("producto");
						producto.setAttribute("idProducto", String.valueOf(pp.getId_producto()));
						
						for (Producto prod : listaProductos) {
							if (pp.getId_producto() == prod.getIdProducto()) {
								producto.setAttribute("nombre", prod.getNombre());
								producto.setAttribute("cantidad", String.valueOf(pp.getCantidad()));
							}
						}
						productos.appendChild(producto);
						
						Element cantidad = doc.createElement("cantidad");
						cantidad.setTextContent(String.valueOf(pp.getCantidad()));
						
						Element precio = doc.createElement("precio");
						precio.setTextContent(String.valueOf(pp.getPrecio()));
					}
				}
				
				Element fecha = doc.createElement("fecha");
				fecha.setTextContent(String.valueOf(p.getFecha()));
				pedido.appendChild(fecha);				
				
				Element precio = doc.createElement("precio_total");
				precio.setTextContent(String.valueOf(p.getPrecio_total()));
				pedido.appendChild(precio);
				
				Element entregado = doc.createElement("entregado");
				entregado.setTextContent(String.valueOf(p.isEntregado()));
				pedido.appendChild(entregado);
			}
			
			TransformerFactory tF = TransformerFactory.newInstance();
			Transformer t = tF.newTransformer();
			
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("pedidos.xml"));
			
			t.transform(source, result);
			
			System.out.println("XML generado correctamente como 'pedidos.xml'.");
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}
	
}