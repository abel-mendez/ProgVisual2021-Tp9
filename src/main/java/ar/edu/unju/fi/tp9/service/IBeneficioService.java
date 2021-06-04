package ar.edu.unju.fi.tp9.service;

import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Beneficio;

public interface IBeneficioService {
	public void saveBeneficio(Beneficio beneficio);
	public void deletBeneficio(int id);
	public Optional<Beneficio> getBeneficiosById(int id);
	
}
