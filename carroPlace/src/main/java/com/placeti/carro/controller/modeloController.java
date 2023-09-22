package com.placeti.carro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.placeti.carro.model.Modelo;
import com.placeti.carro.repository.ModeloRepository;

@RestController
@RequestMapping("/modelo")
public class modeloController {
	@Autowired
	private ModeloRepository modeloRepository;
	@GetMapping
	public List<Modelo> listar() {
		return modeloRepository.findAll();
			}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Modelo>> buscaModeloID(@PathVariable(name = "id", required = true )Long id) {
		return ResponseEntity.ok(modeloRepository.findById(id));
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public Modelo adicionar(@RequestBody Modelo modelo) {
		return modeloRepository.save(modelo);
		
	}
	@DeleteMapping(path = "/{id}")
	public void deleteModelo(
			@PathVariable(name = "id", required = true)Long id) {
			modeloRepository.deleteById(id);
	}
	 @RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Modelo> Put(@PathVariable(value = "id") long id, @RequestBody Modelo novomodelo)
	    {
	        Optional<Modelo> antmodelo = modeloRepository.findById(id);
	        if(antmodelo.isPresent()){
	            Modelo modelo = antmodelo.get();
	            modelo.setNome(novomodelo.getNome());
	            modeloRepository.save(modelo);
	            return new ResponseEntity<Modelo>(modelo, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	

	
	
	}

	

