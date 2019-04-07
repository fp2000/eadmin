package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public abstract class AdministracionElectronicaBase {
	protected int id;
	protected String nombre;
	protected Usuario usuario;
	protected Date fecha;
	
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Date getFecha() {
		return fecha;
	}	
	
	
}
