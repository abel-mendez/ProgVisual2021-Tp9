package ar.edu.unju.fi.tp9.service.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.repository.IClienteRepository;
import ar.edu.unju.fi.tp9.service.IClienteService;
@Service("clienteServiceMysql")
public class ClienteServiceImpMysql implements IClienteService {
	
	List<Cliente> clientesEncontrados = new ArrayList<Cliente>();
	
	@Autowired
	private IClienteRepository clienteRepo;
	@Autowired
	private Cliente cliente;

	@Override
	public void generarTablaCLiente() {
		// TODO Auto-generated method stub
		
		guardarCliente(new Cliente("DNI", 111, "Vilte", "vilte@Hotmail.com", "1234", LocalDate.of(1989, 4, 3), 388, 4212121, LocalDate.of(2021, 4, 16)));
	
	}

	/**
	 *Guarda un clienteo modifica en caso q ya se encuentre el id
	 */
	@Override
	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepo.save(cliente);
	}

	/**
	 *se obtiene una lista de Clientes
	 */
	@Override
	public List<Cliente> getAllClientes() {
		// se hace un casteo directo 
		List<Cliente> clientes=(List<Cliente>)clienteRepo.findAll();
		return clientes;
	}

	/**
	 *devuelve un cliente nuvo
	 */
	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return this.cliente;
	}

	/**
	 *recupera el cliente por id
	 */
	@Override
	public Optional<Cliente> getClienteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente=clienteRepo.findById(id);
		return cliente;
	}

	/**
	 *elimina un cliente por id
	 */
	@Override
	public void deletClienteById(Long id) {
		// TODO Auto-generated method stub
		clienteRepo.deleteById(id);
		
	}

	/**
	 * devuelve un empleado por id
	 */
	@Override
	public Cliente getClientePorId(Long id) {
		Cliente cliente=clienteRepo.findById(id).get();
		return cliente;
	}

	@Override
	public Cliente buscarClientePorNombre(String nombreApellido) {
		// TODO Auto-generated method stub
		//List<Cliente> clientes= new ArrayList<Cliente>();
		Cliente cliente=new Cliente();
		cliente=clienteRepo.findByNombreApellido(nombreApellido);
		return cliente;
	}

	@Override
	public void BeneficioCliente(Long id,int idb) {
		// TODO Auto-generated method stub
		cliente = this.getClientePorId(id);
		for (int i=0; i< cliente.getBeneficios().size();i++) {
			if (i == idb) {
				cliente.getBeneficios().remove(idb);
			}
		}
		
	}



}
