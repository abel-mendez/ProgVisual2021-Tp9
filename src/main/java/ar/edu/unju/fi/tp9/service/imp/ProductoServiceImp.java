package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Producto;
import ar.edu.unju.fi.tp9.service.IProductoService;
import ar.edu.unju.fi.tp9.util.TablaProducto;

@Service
public class ProductoServiceImp implements IProductoService {

	
	@Autowired
	@Qualifier("unProducto")
	Producto producto;

	//private List<Producto> productoList = new ArrayList<Producto>();
	private List<Producto> productos;
	
	
	//14-5 si la lista esta vacia se llamara a generarTabla()
	@Override
	public void addProducto(Producto producto) {
		/*
		 * //agrego el objeto producto en la lista de productos
		 * this.productoList.add(producto);
		 * LOGGER.info("METHOD: addProducto - se agrego un producto en la lista --> "+
		 * productoList.get(productoList.size()-1));
		 */	
		if (productos==null) {
			generarTablaProducto();
			
		}
		productos.add(producto);;
		
	}

	@Override
	public Producto getUltimoProducto() {

		if (productos.isEmpty()) {
			return producto;
			
		}else {
			Producto pr = productos.get(productos.size()-1);//productoList.get(productoList.size()-1);
			return pr;
		}

	}
	
	
	@Override
	public List<Producto> getAllProductos() {
		// TODO Auto-generated method stub
		if(this.productos==null) {
			this.generarTablaProducto();
		}
		return this.productos;//this.productoList;
	}

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return producto;
	}
	
	
	//14-5 Se busca un producto por codigo 
	@Override
	public Optional<Producto> getUnProducto(int codigo) {
		// TODO Auto-generated method stub
		Producto prod =new Producto();
		//for each
		/*
		 * for (Producto producto : this.productoList) { if
		 * (codigo==producto.getCodigo()) { prod=producto; }
		 * 
		 * }
		 */
		for (Producto producto : this.productos) 
		{
			if (codigo==producto.getCodigo()){
				prod=producto; 
				}
			 
		 }
		//return prod;
		return null;
	}
	
	
	//14-5 Se genera la tabla con dos productos por defecto
	@Override
	public void generarTablaProducto() {
		// TODO Auto-generated method stub
		this.productos=TablaProducto.ListProducto;
		this.productos.add(new Producto(111,"Arroz",80.2,"Peleador",5));
		this.productos.add(new Producto(112,"Yerba",100.5,"Amanda",3));
	}

	@Override
	public void deleteProducto(int id) {
		// TODO Auto-generated method stub
		
	}
}
