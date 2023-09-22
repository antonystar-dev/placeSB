package com.placeti.carro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placeti.carro.model.Marca;

@RestController //vai receber requisições rest
@RequestMapping("/marca") //vai mapear os endpoints para receber as requisições com /marca
public class clienteController {
	@GetMapping // ele vai chamar o metodo de baixo
	public List<Marca> listar() {
		
	}
}
