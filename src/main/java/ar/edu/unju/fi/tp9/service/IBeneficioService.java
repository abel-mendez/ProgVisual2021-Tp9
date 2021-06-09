package ar.edu.unju.fi.tp9.service;

import java.util.List;

import ar.edu.unju.fi.tp9.model.Beneficio;

public interface IBeneficioService {
	public void saveBeneficio(Beneficio beneficio);
	public void deletBeneficio(int id);
	public Beneficio getBeneficiosById(int id);
	public List<Beneficio> getAllbeneficios();
	
}
