package ar.edu.unju.fi.tp9;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.type.LocalDateType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.service.IBeneficioService;
import ar.edu.unju.fi.tp9.service.IClienteService;
@SpringBootTest
class BeneficioTest {
	
	@Autowired
	@Qualifier("clienteServiceMysql")
	IClienteService clienteService;
	
	@Autowired
	@Qualifier("BeneficioServiceMysql")
	IBeneficioService beneficioService;
	
	@Test
	void testGuardarBeneficio() {
		//List<Cliente> clientes= new ArrayList<Cliente>();
		LocalDate fecha=LocalDate.of(2020, 1, 8);
		Cliente client=new Cliente();
		client.setNombreApellido("Abel Mendez");
		client.setNroDocumento(40331244);
		client.setCodigoAreaTelefono(388);
		client.setCuenta(null);
		client.setEmail("abel.m.villagra@gmail.com");
		client.setFechaNacimiento(fecha);
		client.setFechaUltimaCompra(fecha);
		client.setNroTelefono(4087971);
		client.setPassword("12345678");
		client.setTipoDocumento("dni");
		Beneficio beneficio= new Beneficio();
		beneficio.setDescripcion("10% de descuento");
		beneficioService.saveBeneficio(beneficio);
		Beneficio bene= new Beneficio();
		bene=beneficioService.getBeneficiosById(1);
		List<Beneficio> beneficios= new ArrayList<Beneficio>();
		
		beneficios.add(bene);
		client.setBeneficios(beneficios);
		clienteService.guardarCliente(client);
	
		
		assertEquals("10% de descuento", beneficio.getDescripcion());
	}

}
