package ar.edu.unju.fi.tp9.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.service.IClienteService;
import ar.edu.unju.fi.tp9.util.TablaCliente;

@Service("clienteRamImp")
public class ClienteServiceImp implements IClienteService{

	private List<Cliente> clientes;
	@Autowired
	@Qualifier("clienteObj")
	Cliente cliente;

	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	
	@Override
	public void generarTablaCLiente() {
		LOGGER.info("CONTROLLER : ClienteServiceImp");
		LOGGER.info("METHOD : generarTablaCLiente()");
		
		clientes = TablaCliente.listclientes;
		clientes.add(new Cliente("DNI",38325788,"CRUZ,LEANDRO","leoapu@gmail.com","sdd12554",LocalDate.of(1989, 4, 3),388,5445845,LocalDate.of(2021, 4, 16)));
	
		LOGGER.info("RESULT : CREA LISTA DE CLIENTES");
	}
	

	@Override
	public void guardarCliente(Cliente cliente) {
		LOGGER.info("CONTROLLER : ClienteServiceImp");
		  if (clientes == null) {
			  generarTablaCLiente();
		  }
		  
		   clientes.add(cliente);
		   LOGGER.info("METHOD : guardarCliente() - se agrego un Cliente en la lista --> " + clientes.get(clientes.size()-1));
		   LOGGER.info("RESULT : GUARDA CLIENTE INGRESADO POR FORMULARIO");
	}

	
	@Override
	public List<Cliente> getAllClientes() {
		LOGGER.info("METHOD : getAllClientes()");
		LOGGER.info("RESULT : INGRESA CLIENTES A UNA LISTA DE CLIENTES");
		return clientes;
	}


	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return cliente;
	}


	@Override
	public Optional<Cliente> getClienteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deletClienteById(Long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Cliente getClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cliente buscarClientePorNombre(String nombreApellido) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void BeneficioCliente(Long id,int idb) {
		// TODO Auto-generated method stub
		
	}




}