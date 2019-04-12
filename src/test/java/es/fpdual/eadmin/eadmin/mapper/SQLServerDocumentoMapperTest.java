package es.fpdual.eadmin.eadmin.mapper;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-configuration/eadmin-persistencia.xml",
		"classpath:spring-configuration/eadmin-sqlserver-persistencia.xml" })

public class SQLServerDocumentoMapperTest extends BaseDocumentoMapperTest {

}
