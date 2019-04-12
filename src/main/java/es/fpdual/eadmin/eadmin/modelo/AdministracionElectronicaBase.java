package es.fpdual.eadmin.eadmin.modelo;

import java.time.LocalDate;

public abstract class AdministracionElectronicaBase {
	protected int id;
	protected String nombre;
	protected Usuario usuario;
	protected LocalDate fechaCreacion;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

}
