package es.fpdual.eadmin.eadmin.repositorio;

import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.eadmin.eadmin.modelo.Documento;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();
	private static Logger logger = LogManager.getLogger(EadminApplication.class);
	
	
			
	
	@Override
	public void altaDocumento(Documento documento) {
		
		if (documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento ya existe");
		}		
		documentos.add(documento);
		
		String rutaArchivo = (documento.getTipoDocumento()+".txt");
		File archivo = new File(rutaArchivo);
		
		try {
			if (!archivo.exists()) {
				
				String textoMostradoPorPantalla = "\n****************************************************\n documento creado correctamente\n id: " 
						+ documento.getId() + "\n Nombre: "
						+ documento.getNombre() + "\n Usuario: " + documento.getUsuario() + "\n fecha: " + documento.getFecha() + "\n tipo de documento: "
						+ documento.getTipoDocumento() + "\n****************************************************";
				logger.debug(textoMostradoPorPantalla);
				
				
	        	FileWriter fichero = new FileWriter(rutaArchivo);
	        	PrintWriter impFichero = new PrintWriter(fichero);
	        	
	        	String textoAImprimirEnFichero = "ID: " + documento.getId() + "Nombre: " + documento.getNombre() + "Fecha: " + documento.getFecha()
	        		+ "Tipo Documento: " + documento.getTipoDocumento() + "Usuario: " + documento.getUsuario();
	        	impFichero.println(textoAImprimirEnFichero);
	        	
	        	impFichero.close();
	        	logger.info("Documento creado correctamente");
	        	
	        	
			} else {
				logger.info("El documento ya existe");
			}
    		
        		
    	} catch(IOException e){
    		e.printStackTrace();
    	}
		
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		
		Documento documentoAEliminar = new Documento (codigoDocumento, null, null, null, null);
		
		//solucion 1
		final int indice = documentos.indexOf(documentoAEliminar); 
		
		//solucion 2
		//documentos.stream()
		//	.filter(d -> d.getId()==codigoDocumento)
		//	.findAny().orElse(null);
		
		
		if(indice >= 0) {
			documentos.remove(indice);
		}
		
		
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		
			
		String rutaArchivo = ("ListaDocumento.txt");		
		try {		
			
			FileWriter fichero = new FileWriter(rutaArchivo);
	        PrintWriter impFichero = new PrintWriter(fichero);
	        
			for(Documento documento: documentos) {
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Fecha: " + documento.getFecha());
				impFichero.println("Tipo Documento: " + documento.getTipoDocumento());
				impFichero.println("Usuario: " + documento.getUsuario());	        	        	
			}
			
        	impFichero.close();
        		
    	} catch(IOException e){
    		e.printStackTrace();
    	}
		return this.documentos.stream().collect(Collectors.toList());	
	}

	@Override
	public int getSiguiente() {
		if (documentos.isEmpty()) {
			return 1;
		}
		return documentos.get(documentos.size()-1).getId() +1;
	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return documentos.stream().filter(d-> d.getId()==codigoDocumento).findFirst().orElse(null);
	}
	
}
