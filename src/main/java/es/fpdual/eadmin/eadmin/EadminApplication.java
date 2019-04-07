package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;
import org.apache.log4j.*;

@SpringBootApplication
public class EadminApplication {

	private static Logger logger = LogManager.getLogger(EadminApplication.class);

	public static void main(String[] args) {		
		logger.info("iniciando aplicacion");
		
		DocumentoContable documentoContabe1 = new DocumentoContable(0, null, null, null, null);
		
		SpringApplication.run(EadminApplication.class, args);
		logger.info("finalizando servicios");  
		
		
		
	}

}