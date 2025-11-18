package modelo;

public class Pedido_Producto {

	private int id_pedido;
	private int id_producto;
	private int cantidad;
	private double precio;

	public Pedido_Producto(int id_pedido, int id_producto, int cantidad, double precio) {
		super();
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public int getId_producto() {
		return id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Pedido_Producto [id_pedido=" + id_pedido + ", id_producto=" + id_producto + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}

}