package ar.edu.unju.fi.tp9.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Compra;

public interface ICompraService {
	public void generarTablaCompra();
	public void guardarCompra(Compra compra);
	public List<Compra> obtenerCompras();
	public Compra getCompra();
	public Optional<Compra> getCompraById(Long id);
   	public void deleteCompraById(Long id);
   	public List<Compra> buscarCompra(String nombre, double total);

}
