package es.fpdual.eadmin.eadmin.modelo;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public abstract class AdministracionElectronicaBase {
	protected int id;
	protected String nombre;
	protected Usuario usuario;
	protected LocalDate fechaCreacion;
}
