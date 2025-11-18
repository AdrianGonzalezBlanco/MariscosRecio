package modelo;

public class Cliente {

	private int id_cliente;
	private String dni;
	private String mail;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int numero_telf;

	public Cliente(int id_cliente, String dni, String mail, String contrasenia, String nombre, String apellido, int numero_telf) {
		super();
		this.id_cliente = id_cliente;
		this.dni = dni;
		this.mail = mail;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero_telf = numero_telf;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}

	public String getDni() {
		return dni;
	}

	public String getMail() {
		return mail;
	}

	public String getContraseña() {
		return contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getNumero_telf() {
		return numero_telf;
	}
	
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setContraseña(String contraseña) {
		this.contrasenia = contraseña;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNumero_telf(int numero_telf) {
		this.numero_telf = numero_telf;
	}
	
	@Override
	public String toString() {
		return "Cliente [id_cliente= " + id_cliente + ", dni=" + dni + ", mail=" + mail + ", contraseña=" + contrasenia + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", numero_telf=" + numero_telf + "]";
	}

}