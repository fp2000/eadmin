package es.fpdual.eadmin.eadmin.modelo;

public class Usuario {
	private final int id;
	private final String cargo;
	private final String nombre;
	
	public Usuario(int id, String cargo, String nombre) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}	
	
	public String getCargo() {
		return cargo;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			final Usuario usuario = (Usuario) obj;
			return this.getId() == usuario.getId(); 
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cargo=" + cargo + ", nombre=" + nombre + "]";
	}
	
	
}
