package es.fpdual.eadmin.eadmin.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public class Expediente extends AdministracionElectronicaBase {
	private final TipoExpediente tipoExpediente;
	private final List<Documento> documentos;

	public Expediente(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, TipoExpediente tipoExpediente,
			List<Documento> documentos) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
		this.documentos = documentos;
	}

	public boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}

	public List<Integer> obtenerLongitudNombresDocumentos() {

		if (documentos.size() == 0) {
			throw new AdministracionElectronicaException("Lista de documentos vacía");
		}

		return documentos.stream().filter(this::esDocumentoContable).map(Documento::getNombre).map(String::length)
				.collect(Collectors.toList());
	}

	public Map<TipoDocumento, List<Documento>> obtenerDocumentosPorTipos() {
		return documentos.stream().collect(Collectors.groupingBy(Documento::getTipoDocumento));
	}

}
