package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
public class Documento extends AdministracionElectronicaBase{

	protected final TipoDocumento tipoDocumento;

	
	public Documento(int id, String nombre, Usuario usuario, Date fechaCreacion, TipoDocumento tipoDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fecha = fechaCreacion;
		this.tipoDocumento = tipoDocumento;

	}
		


	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}	 
	

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			Documento documento = (Documento) obj;
			return this.getId() == documento.getId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}



	@Override
	public String toString() {
		return "Documento [tipoDocumento=" + tipoDocumento + ", id=" + id + ", nombre=" + nombre + ", usuario="
				+ usuario + ", fecha=" + fecha + "]";
	}
	

	
}
