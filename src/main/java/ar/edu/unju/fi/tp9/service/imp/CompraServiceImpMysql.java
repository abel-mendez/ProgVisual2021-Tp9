package ar.edu.unju.fi.tp9.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Compra;
import ar.edu.unju.fi.tp9.repository.ICompraRepository;
import ar.edu.unju.fi.tp9.service.ICompraService;
import ar.edu.unju.fi.tp9.util.TablaCompra;

@Service("compraServiceMysql")
public class CompraServiceImpMysql implements ICompraService{
	
	private List<Compra> compras=TablaCompra.listCompras;
	private static final Log LOGGER =LogFactory.getLog(CompraServiceImp.class);
	@Autowired
	@Qualifier("unaCompra")
	Compra compra;
	@Autowired
	ICompraRepository compraRepo;
	
	@Override
	public void generarTablaCompra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		//LOGGER.info("METHOD: se agrego un obj compra a la lista -> "+compras.get(compras.size()-1));
		compraRepo.save(compra);
	}

	@Override
	public List<Compra> obtenerCompras() {
		// TODO Auto-generated method stub
		LOGGER.info("METHOD: mostrar obj de la lista ");
		List<Compra> compras=(List<Compra>) compraRepo.findAll();
		return compras;
	}

	@Override
	public Compra getCompra() {
		// TODO Auto-generated method stub
		return this.compra;
	}

	@Override
	public Optional<Compra> getCompraById(Long id) {
		// TODO Auto-generated method stub
		Optional<Compra> comp = compraRepo.findById(id);
		return comp;
	}

	@Override
	public void deleteCompraById(Long id) {
		// TODO Auto-generated method stub
		compraRepo.deleteById(id);
	}

	@Override
	public List<Compra> buscarCompra(String nombre,double total) {
		// TODO Auto-generated method stub
		List<Compra> compra=new ArrayList<Compra>();
		if (!nombre.isEmpty()&&total>=0) {
			compra= compraRepo.findByProductoNombreAndTotalGreaterThanEqual(nombre, total);
		} else {if (nombre.isEmpty()&&total>=0) {
					compra=compraRepo.findByTotalGreaterThanEqual(total);
				}

		}
		return compra;
	}


}
