package clases;

public class SitioClasificado {
	private String nombre;
	private String telefono;
	private String mail;
	
	public SitioClasificado(String nombre, String telefono, String mail) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
