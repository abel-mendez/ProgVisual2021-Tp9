package ar.edu.unju.fi.tp9.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Producto;

public interface IProductoService {
	//14-5 VDE
	public void generarTablaProducto();

	public void addProducto(Producto producto);
	
	public Producto getUltimoProducto();
	
	public Producto getProducto();
	
	public List<Producto> getAllProductos();
	//14-5 VDE
	public Optional <Producto> getUnProducto(int codigo);
	
	public void deleteProducto(int id);
}
