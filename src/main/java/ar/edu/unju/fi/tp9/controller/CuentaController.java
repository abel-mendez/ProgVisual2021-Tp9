package ar.edu.unju.fi.tp9.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.model.Cuenta;
import ar.edu.unju.fi.tp9.service.IClienteService;
import ar.edu.unju.fi.tp9.service.ICuentaService;
@Controller
public class CuentaController {
	@Autowired
	@Qualifier("cuentaServiceMysql")
	private ICuentaService cuentaService;
	@Autowired
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;

	@GetMapping("/cuenta/nueva")
	public String nuevaCuenta(Model model){
		model.addAttribute(cuentaService.getCuenta());
		model.addAttribute("clientes", clienteService.getAllClientes());
		return"nueva-cuenta";
	}
	
//	@PostMapping("/cuenta/guardar")
//	public ModelAndView guardarCuenta(@ModelAttribute("cuenta")Cuenta cuenta) {
//		ModelAndView modelView= new ModelAndView("lista-cuenta");
//		cuentaService.guardarCuenta(cuenta);
//		modelView.addObject("cuentas", cuentaService.getAllCuentas());
//		return modelView;
//	}
	
	@GetMapping("/cuenta/guardar")
	public String guardarCuenta( Model model, @RequestParam(name="id") String id,
			@RequestParam(name="saldo") Double saldo,
			@RequestParam(name="fechaCreacion") String fechaCreacion,
			@RequestParam(name="estado") String estado,
			@RequestParam(name="cliente") Long cliente) {
		Cuenta cu= new Cuenta();
		cu.setSaldo(saldo);
		cu.setFechaCreacion(LocalDate.parse(fechaCreacion));
		cu.setEstado(estado);
		cu.setCliente(clienteService.getClienteById(cliente).get());
		
		cuentaService.guardarCuenta(cu);
		model.addAttribute("cuentas",cuentaService.getAllCuentas() );
		
		return "lista-cuenta";

		
	}
	
	@GetMapping("/cuenta/lista")
	public ModelAndView getCuentasPage() {
		ModelAndView modelView = new ModelAndView("lista-cuenta");
		modelView.addObject("cuentas", cuentaService.getAllCuentas());
		return modelView;
	}
	@GetMapping("/cuenta/borrar/{id}")
	public ModelAndView getCompraDeletPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("redirect:/cuenta/lista");
		cuentaService.deletCuentaById(id);
		return modelView;
	}
	@GetMapping("/cuenta/editar/{id}")
	public ModelAndView getCompraModPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView=new ModelAndView("nueva-cuenta");
		Optional<Cuenta> cuenta=cuentaService.getCuentaById(id);
		modelView.addObject("cuenta", cuenta);
		modelView.addObject("clientes", clienteService.getAllClientes());

		return modelView;
	}
}
