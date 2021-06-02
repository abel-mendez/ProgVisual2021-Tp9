package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Cuenta;
import ar.edu.unju.fi.tp9.repository.ICuentaRepository;
import ar.edu.unju.fi.tp9.service.ICuentaService;

@Service("cuentaServiceMysql")
public class CuentaServiceImpMysql implements ICuentaService{

	@Autowired
	private ICuentaRepository cuentaRepo;
	@Autowired
	private Cuenta cuenta;
	
	@Override
	public void guardarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaRepo.save(cuenta);
	}

	@Override
	public List<Cuenta> getAllCuentas() {
		// TODO Auto-generated method stub
		List<Cuenta> cuentas= (List<Cuenta>) cuentaRepo.findAll();
		return cuentas;
	}

	@Override
	public Cuenta getCuenta() {
		// TODO Auto-generated method stub
		return this.cuenta;
	}

	@Override
	public Optional<Cuenta> getCuentaById(Long id) {
		// TODO Auto-generated method stub
		Optional <Cuenta> cuenta= cuentaRepo.findById(id);
		return cuenta;
	}

	@Override
	public void deletCuentaById(Long id) {
		// TODO Auto-generated method stub
		cuentaRepo.deleteById(id);
	}

}
