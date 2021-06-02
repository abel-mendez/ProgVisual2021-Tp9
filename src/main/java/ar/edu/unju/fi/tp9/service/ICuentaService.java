package ar.edu.unju.fi.tp9.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Cuenta;

public interface ICuentaService {

	public void guardarCuenta(Cuenta cuenta);
	public List<Cuenta> getAllCuentas();
	public Cuenta getCuenta();
	public Optional<Cuenta> getCuentaById(Long id);
	public void deletCuentaById(Long id);
	
}
