package ar.edu.unju.fi.tp9.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.service.IBeneficioService;
import ar.edu.unju.fi.tp9.service.IClienteService;

@Controller
public class ClienteController {

	
	@Autowired
	//@Qualifier("clienteRamImp")
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("BeneficioServiceMysql")
	private IBeneficioService beneficioService;
	
	private static final Log LOGGER = LogFactory.getLog(ClienteController.class);
	
	@GetMapping("/cliente/nuevo")
	public String nuevoCliente(Model model) {
		LOGGER.info("CONTROLLER : ClienteController with / Formulario get method");
		LOGGER.info("METHOD : nuevoCliente()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA nuevocliente.html");
		model.addAttribute(clienteService.getCliente());
		model.addAttribute("allbeneficios",beneficioService.getAllbeneficios());
		model.addAttribute("benefcliente", null);
		return "nuevocliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView guardarCliente(@Valid @ModelAttribute("cliente") Cliente uncliente, BindingResult result) {
		LOGGER.info("CONTROLLER : ClienteController with / cliente/guardar post method");
		LOGGER.info("METHOD : guardarCliente()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA clientes.html");
		
		if(result.hasErrors()) {
			ModelAndView model=new ModelAndView("nuevocliente");
			model.addObject("cliente", uncliente);
			return model;
		}else {
			//vista
			ModelAndView modelView = new ModelAndView("clientes");
			clienteService.guardarCliente(uncliente);
			//en la vista clientes  se obtiene todos los clientes
			modelView.addObject("clientes",clienteService.getAllClientes());
			
			return modelView;
		}
	}
	
	
	
	@GetMapping("/cliente/listado")
	public ModelAndView getClientesPage() {
		LOGGER.info("CONTROLLER : ClienteController with / cliente/listado get method");
		LOGGER.info("METHOD : getClientesPage()");
		ModelAndView modelView = new ModelAndView("clientes");
//		if (clienteService.getAllClientes() == null) {
//			clienteService.generarTablaCLiente();
//		}
		modelView.addObject("clientes",clienteService.getAllClientes());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA clientes.html");
		return modelView;
	
	}
	
	@GetMapping("/cliente/editar/{id}")
	public ModelAndView getClienteModPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView=new ModelAndView("nuevocliente");
		Optional<Cliente> cliente=clienteService.getClienteById(id);
		//Cliente cliente =clienteService.getClientePorId(id);
		modelView.addObject("cliente", cliente);
		modelView.addObject("allbeneficios",beneficioService.getAllbeneficios());
		modelView.addObject("benefcliente", null );
		return modelView;
	}
	
	@GetMapping("/cliente/borrar/{id}")
	public ModelAndView getClienteDeletPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("redirect:/cliente/listado");
		clienteService.deletClienteById(id);
		
		return modelView;
	}
	
	@GetMapping("/cliente/{idcliente}/beneficio/agregar/{idbeneficio")
	public String agregarBeneficioCliente(@PathVariable(name="idcliente") Long idcliente,
			@PathVariable(name="idbeneficio") int idbeneficio,Model model) {
		Cliente cliente= clienteService.getClienteById(idcliente).get();
		Beneficio beneficio= beneficioService.getBeneficiosById(idbeneficio);
		cliente.getBeneficios().add(beneficio);
		try {
			clienteService.guardarCliente(cliente);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		cliente= clienteService.getClienteById(idcliente).get();
		model.addAttribute("cliente",cliente);
		model.addAttribute("allbeneficios",beneficioService.getAllbeneficios());
		model.addAttribute("benefcliente",cliente.getBeneficios());
		return "nuevocliente";
	}
	
}