package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Compra;
import ar.edu.unju.fi.tp9.model.Producto;
import ar.edu.unju.fi.tp9.service.ICompraService;
import ar.edu.unju.fi.tp9.util.TablaCompra;

@Service
public class CompraServiceImp implements ICompraService {
	private List<Compra> compras=TablaCompra.listCompras;
	private static final Log LOGGER =LogFactory.getLog(CompraServiceImp.class);
	@Autowired
	@Qualifier("unaCompra")
	Compra compra;
	@Override
	public void guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		if(compras==null) {
			generarTablaCompra();
		}
		this.compras.add(compra);
		LOGGER.info("METHOD: se agrego un obj compra a la lista -> "+compras.get(compras.size()-1));
		
	}

	@Override
	public List<Compra> obtenerCompras() {
		// TODO Auto-generated method stub
		LOGGER.info("METHOD: mostrar obj de la lista ");
		return this.compras;
	}

	@Override
	public void generarTablaCompra() {
		// TODO Auto-generated method stub
		this.compras=TablaCompra.listCompras;
		//this.compras.add(new Compra( new Producto(0, "Galleta", 25.6, "pepitos", 2), 3));
		LOGGER.info("RESULT : CREA LISTA DE CLIENTES");
	}

	@Override
	public Compra getCompra() {
		// TODO Auto-generated method stub
		return this.compra;
	}

	@Override
	public Optional<Compra> getCompraById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCompraById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compra> buscarCompra(String nombre, double total) {
		// TODO Auto-generated method stub
		return null;
	}

}
