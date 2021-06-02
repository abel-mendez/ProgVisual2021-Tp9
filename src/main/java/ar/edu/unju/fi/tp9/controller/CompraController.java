package ar.edu.unju.fi.tp9.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp9.model.Compra;
import ar.edu.unju.fi.tp9.service.ICompraService;
import ar.edu.unju.fi.tp9.service.IProductoService;

@Controller
public class CompraController {
	
	@Autowired
	@Qualifier("compraServiceMysql")
	private ICompraService compraService;
	@Autowired
	@Qualifier("productoServiceImpMysql")
	private IProductoService productoService;
	
	private static final Log LOGGER = LogFactory.getLog(CompraController.class);

	@GetMapping("/compra/guardar")
	public String getAddCompraGuardarPage(@Valid @ModelAttribute("compra") Compra unaCompra,BindingResult result, Model model,@RequestParam(name="cantidad")String cantidad,
			@RequestParam(name="id")String id,
			@RequestParam(name="codigo")String codigo) {
		Compra comp = new Compra();
		comp.setId(Long.valueOf(id));
		comp.setCantidad(Integer.valueOf(cantidad));
		comp.setProducto( this.productoService.getUnProducto(Integer.valueOf(codigo)).get());
		comp.setTotal(comp.getTotal());
		if(result.hasErrors()) {
			model.addAttribute("compra",unaCompra);
			model.addAttribute("producto",productoService.getAllProductos());
			return "compra";
		}else {
			LOGGER.info("CONTROLLER : CompraController with /guardarCompra post method");
			compraService.guardarCompra(comp);
			model.addAttribute("compras",compraService.getCompra());
			LOGGER.info("RESULT : VISUALIZA LA PAGINA resultadoCompra.html ");
			return "resultadoCompra";
		}
	}
	
	@GetMapping("/compra")
	public String getCompraFormPage(Model model) {
		LOGGER.info("CONTROLLER : CompraController with / Formulario get method");
		LOGGER.info("METHOD : getCompraFormPage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA compra.html");
		model.addAttribute("compra",compraService.getCompra());
		model.addAttribute("producto",productoService.getAllProductos());
		return "compra";
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getComprasListPage() {
		LOGGER.info("CONTROLLER : CompraController with / compra/listado get method");
		LOGGER.info("METHOD : getComprasListPage()");
		ModelAndView modelView = new ModelAndView("listacompras");
		if (compraService.obtenerCompras().isEmpty()) {
			compraService.generarTablaCompra();
		}
		modelView.addObject("filtroproducto","");
		modelView.addObject("filtrototal","");
		modelView.addObject("compras",compraService.obtenerCompras());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA listacompras.html");
		return modelView;
	
	}
	
	@GetMapping("/compra/borrar/{id}")
	public ModelAndView getCompraDeletPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("redirect:/compra/listado");
		compraService.deleteCompraById(id);
		return modelView;
	}

	@GetMapping("/compra/editar/{id}")
	public ModelAndView getCompraModPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView=new ModelAndView("compra");
		Compra compra=compraService.getCompraById(id).get();
		modelView.addObject("compra", compra);
		modelView.addObject("producto",productoService.getAllProductos());
		return modelView;
	}
	@GetMapping("/compra/filtrar")
	public String findCompraByFiltro(Model model,@RequestParam(name="filtroproducto") String filtroproducto,
			@RequestParam(name="filtrototal") Double filtrototal) {
			//@ModelAttribute(name="compra")Compra compra
			
		//model.addAttribute("compra", compraService.getCompra());
//		model.addAttribute("filtroproducto","");
//		model.addAttribute("filtrototal","");
		System.out.println("Filtro Producto=> "+filtroproducto);
		System.out.println("Filtro Total=> "+filtrototal);
		model.addAttribute("compras", compraService.buscarCompra(filtroproducto, filtrototal));
		return "listacompras";
	}
	
}
