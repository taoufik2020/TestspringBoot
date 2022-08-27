package com.test.springboot.services.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import com.test.springboot.Dto.GenericResponse;
import com.test.springboot.Dto.PersonneDto;
import com.test.springboot.Dto.ResponseListPersonne;
import com.test.springboot.models.Personne;
import com.test.springboot.repository.PersonneRepository;
import com.test.springboot.services.PersonneService;

@Service
public class PersonneServiceIMP implements PersonneService{

	private static final Logger logger = LoggerFactory.getLogger(PersonneServiceIMP.class);
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Override
	public GenericResponse<PersonneDto> createPersonne(PersonneDto personne) {
		
		try {
			logger.info("PersonneServiceIMP : createPersonne : START : Name personne"
					+ personne.getFirstName());
			
			int age = compareDate(personne.getBirthday());
			if(age <=150)
			{
				throw new Exception("l'age doit etre inferieure à 150");
			}
			
			Personne newPersonne = modelMapper.map(personne, Personne.class);
			
			Personne personneAfterPersist = personneRepository.save(newPersonne);
			
			if(personneAfterPersist == null) {
				return new GenericResponse<PersonneDto>(null, -1);
			}
			
			PersonneDto personneDto = modelMapper.map(personneAfterPersist, PersonneDto.class);
					
					return new GenericResponse<PersonneDto>(personneDto, 1);
		} catch (Exception e) {
			
			logger.error("PersonneServiceIMP : createPersonne erreur :" + e.getMessage());
			return new GenericResponse<PersonneDto>(null, -1);
		}
		
	}

	@Override
	public GenericResponse<List<ResponseListPersonne>> findAllByOrder() {
		
		List<ResponseListPersonne> sortingList = new ArrayList<>();
		
		List<Personne> listPersonnes = personneRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
		
		listPersonnes.forEach(p -> {
			ResponseListPersonne personneResponse = new ResponseListPersonne();
					personneResponse.setAge(compareDate(p.getBirthday()));
			personneResponse.setFirstName(p.getFirstName());
			sortingList.add(personneResponse);
		});
		
		if(sortingList== null) {
			return new GenericResponse<List<ResponseListPersonne>>(null, -1);
		}
		return new GenericResponse<List<ResponseListPersonne>>(sortingList, 1);
		
		
	}
	
	
	public int compareDate(Date date) {
	
			LocalDate currentDate = LocalDate.now();
			
			LocalDate dateNaissance = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
			
			Period periode =  Period.between(dateNaissance, currentDate);
			
			int age  = periode.getYears();
			
		return age;
		
	}
	
	

}
