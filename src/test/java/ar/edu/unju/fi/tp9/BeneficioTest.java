package ar.edu.unju.fi.tp9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
		Beneficio beneficio= new Beneficio();
		beneficio.setDescripcion("10% de descuento");
		Beneficio bene= new Beneficio();
		List<Beneficio> beneficios= new ArrayList<Beneficio>();
		Cliente cli1=clienteService.buscarClientePorNombre("Vilte Diego");
		System.out.println("CLIENTE 1 => "+cli1);
		beneficioService.saveBeneficio(beneficio);
		bene=beneficioService.getBeneficiosById(1);
		beneficios.add(bene);
		cli1.setBeneficios(beneficios);
		clienteService.guardarCliente(cli1);
	
		
		assertEquals("Beneficio tramiteacion de compra", beneficio.getDescripcion());
	}

}
