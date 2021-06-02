package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Producto;
import ar.edu.unju.fi.tp9.repository.IProductoRepository;
import ar.edu.unju.fi.tp9.service.IProductoService;

@Service("productoServiceImpMysql")
public class ProductoServiceImpMysql implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepo;
	
	@Autowired
	Producto producto;
	
	@Override
	public void generarTablaProducto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProducto(Producto producto) {
		productoRepo.save(producto);
	}

	@Override
	public Producto getUltimoProducto() {
		List<Producto> productos=this.getAllProductos();
		if (productos.isEmpty()) {
			return producto;
		}else {
			Producto pr = productos.get(productos.size()-1);
			return pr;
		}
	}

	@Override
	public Producto getProducto() {
		return this.producto;
	}

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> productos=(List<Producto>) productoRepo.findAll();
		return productos;
	}

	@Override
	public Optional<Producto> getUnProducto(int codigo) {
		Optional<Producto> prod;
		prod= productoRepo.findById(codigo);
		return prod;
	}

	@Override
	public void deleteProducto(int id) {
		productoRepo.deleteById(id);
	}

}
