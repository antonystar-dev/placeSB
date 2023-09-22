package com.placeti.carro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placeti.carro.model.Marca;
import com.placeti.carro.repository.MarcaRepositoty;

@RestController //vai receber requisições rest
@RequestMapping("/marca") //vai mapear os endpoints para receber as requisições com /marca
public class clienteController {
	@Autowired
	private MarcaRepositoty marcaRepositoty;
	@GetMapping // ele vai chamar o metodo de baixo
	public List<Marca> listar() {
		return marcaRepositoty.findAll();
		
	}
	@PostMapping
	public Marca adicionar(@RequestBody Marca marca) {
		return marcaRepositoty.save(marca);
		
	}
	
}
