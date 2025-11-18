package modelo;

import java.sql.Date;

public class Pedido {

	private int id_pedido;
	private int id_cliente;
	private int id_empleado;
	private Date fecha;
	private double precio_total;
	private boolean entregado;

	public Pedido(int id_pedido, int id_cliente, int id_empleado, Date fecha, double precio_total, boolean entregado) {
		super();
		this.id_pedido = id_pedido;
		this.id_cliente = id_cliente;
		this.id_empleado = id_empleado;
		this.fecha = fecha;
		this.precio_total = precio_total;
		this.entregado = entregado;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", id_cliente=" + id_cliente + ", id_empleado=" + id_empleado
				+ ", fecha=" + fecha + ", precio_total=" + precio_total + ", entregado=" + entregado + "]";
	}

}