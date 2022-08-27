package com.test.springboot.services;

import java.util.List;

import com.test.springboot.Dto.GenericResponse;
import com.test.springboot.Dto.PersonneDto;
import com.test.springboot.Dto.ResponseListPersonne;

public interface PersonneService {
	
	public GenericResponse<PersonneDto> createPersonne(PersonneDto personne);
	
	public GenericResponse<List<ResponseListPersonne>> findAllByOrder();
	

}
