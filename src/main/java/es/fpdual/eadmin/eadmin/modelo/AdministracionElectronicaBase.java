package es.fpdual.eadmin.eadmin.modelo;

import java.time.LocalDate;

public abstract class AdministracionElectronicaBase {
	protected int id;
	protected String nombre;
	protected Usuario usuario;
	protected LocalDate fecha;
	
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}	
	
	
}
