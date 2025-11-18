package modelo;

public class Producto {
	
	private int id_producto;
	private int stock;
	private double precio_unitario;
	private String nombre;

	public Producto(int id_producto, int stock, double precio_unitario, String nombre) {
		this.id_producto = id_producto;
		this.stock = stock;
		this.precio_unitario = precio_unitario;
		this.nombre = nombre;
	}

	public int getIdProducto() {
		return id_producto;
	}

	public void setIdProducto(int idProducto) {
		this.id_producto = idProducto;
	}

	public int getCantidad() {
		return stock;
	}

	public void setCantidad(int cantidad) {
		this.stock = cantidad;
	}

	public double getPrecio() {
		return precio_unitario;
	}

	public void setPrecio(double precio) {
		this.precio_unitario = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Producto{" + "id_producto=" + id_producto + ", stock=" + stock + ", precio_unitario=" + precio_unitario + ", tipo='"
				+ nombre + '\'' + '}';
	}

}