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

import com.placeti.carro.model.Marca;
import com.placeti.carro.repository.MarcaRepository;

@RestController //vai receber requisições rest
@RequestMapping("/marca") //vai mapear os endpoints para receber as requisições com /marca
public class marcaController {
	@Autowired
	private MarcaRepository marcaRepositoty;
	@GetMapping // ele vai chamar o metodo de baixo
	public List<Marca> listar() {
		return marcaRepositoty.findAll();
			}
	//esse aqui é mais interessante
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Marca>> buscaMarcaID(@PathVariable(name = "id", required = true )Long id) {
		return ResponseEntity.ok(marcaRepositoty.findById(id));
	}
	//ate aq------/
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public Marca adicionar(@RequestBody Marca marca) {
		return marcaRepositoty.save(marca);
		
	}
	@DeleteMapping(path = "/{id}")
	public void deleteMarca(
			@PathVariable(name = "id", required = true)Long id) {
			marcaRepositoty.deleteById(id);
	}
	 @RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Marca> Put(@PathVariable(value = "id") long id, @RequestBody Marca novamarca)
	    {
	        Optional<Marca> antmarca = marcaRepositoty.findById(id);
	        if(antmarca.isPresent()){
	            Marca marca = antmarca.get();
	            marca.setNome(novamarca.getNome());
	            marcaRepositoty.save(marca);
	            return new ResponseEntity<Marca>(marca, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	

	
	
	}

	

