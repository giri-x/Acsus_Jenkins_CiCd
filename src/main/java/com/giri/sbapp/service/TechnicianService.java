package com.giri.sbapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.giri.sbapp.model.Technician;


@Service
public interface TechnicianService {
	
	public Optional<Technician> findbyemail(String email);
    public Optional<Technician> techLogin(String email, String password);
	public String addTechnician(Technician tech);
	public Technician getTechnician(int id);
	public List<Technician> getAllTechnician();
	public void updateTechnician(Technician tech);
	public String deleteTechnicianId(int id);

}
