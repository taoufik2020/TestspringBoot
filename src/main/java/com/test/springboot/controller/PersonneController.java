package com.test.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.Dto.GenericResponse;
import com.test.springboot.Dto.PersonneDto;
import com.test.springboot.Dto.ResponseListPersonne;
import com.test.springboot.services.PersonneService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
@Api(value = "Personne", description = "personne Api")
public class PersonneController {
	
	private static final Logger log = LoggerFactory.getLogger(PersonneController.class);
	
	@Autowired
	private PersonneService personneService;
	
	@ApiOperation(value = "create personne", nickname = "addPersonne", notes = "this operation will return personne Entity.\n")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successful operation"),
			@ApiResponse(code = 204, message = "operation failure, see your logs"),
			
			})
	@RequestMapping(value = "/addPersonne", produces = { "application/json" }, method = RequestMethod.POST)
	
	ResponseEntity<PersonneDto> addPersonne(@RequestBody PersonneDto personne){
		
		try {
			
			
			GenericResponse<PersonneDto> response = personneService.createPersonne(personne);
			if(response.getCode() == -1) {
				
				return new ResponseEntity<PersonneDto>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<PersonneDto>(response.getData(),HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<PersonneDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	@ApiOperation(value = "get List personne", nickname = "list personne", notes = "this operation will return personne Entity.\n")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 204, message = "operation failure, see your logs"),
			
			})
	@RequestMapping(value = "/getListPersonne", produces = { "application/json" }, method = RequestMethod.GET)
	
	
	ResponseEntity<List<ResponseListPersonne>> getList(){
		
		GenericResponse<List<ResponseListPersonne>> response = personneService.findAllByOrder();
		
try {
			
			
	GenericResponse<List<ResponseListPersonne>> result = personneService.findAllByOrder();
			
				if(result.getCode() == -1) {
					return new ResponseEntity<List<ResponseListPersonne>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<ResponseListPersonne>>(result.getData(),HttpStatus.OK);
			
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResponseListPersonne>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
