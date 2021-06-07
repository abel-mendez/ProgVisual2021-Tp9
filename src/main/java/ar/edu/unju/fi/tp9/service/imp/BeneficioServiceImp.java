package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.repository.IBeneficioRepository;
import ar.edu.unju.fi.tp9.service.IBeneficioService;
@Service("BeneficioServiceMysql")
public class BeneficioServiceImp implements IBeneficioService {
	@Autowired
	IBeneficioRepository beneficioRepo;
	
	@Override
	public void saveBeneficio(Beneficio beneficio) {
		// TODO Auto-generated method stub
		beneficioRepo.save(beneficio);
	}

	@Override
	public void deletBeneficio(int id) {
		// TODO Auto-generated method stub
		beneficioRepo.deleteById(id);
	}

	@Override
	public Beneficio getBeneficiosById(int id) {
		// TODO Auto-generated method stub
		Beneficio beneficio=beneficioRepo.findById(id).get();
		return beneficio;
	}

}
