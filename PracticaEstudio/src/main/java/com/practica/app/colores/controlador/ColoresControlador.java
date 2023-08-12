package com.practica.app.colores.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.app.colores.entity.ColoresEntity;
import com.practica.app.colores.service.ColoresService;

@RestController
public class ColoresControlador {
	@Autowired
	private ColoresService coloresser;

	@PostMapping(value = "/insertacolor")
	public ColoresEntity insertarColor(@RequestBody ColoresEntity color) {
		return coloresser.insertarColor(color);
	}

	@GetMapping(value = "/consultacolore")
	public List<ColoresEntity> consultaColores() {
		return coloresser.consultaColores();
	}

	@PutMapping(value = "/actualizacolore")
	public String actualizaColor(@RequestBody ColoresEntity color) {
		coloresser.actualizaColor(color);
		return "Exito";
	}

	@DeleteMapping(value = "/borracolore/{id}")
	public String borraColor(@PathVariable("id") int id) {
		coloresser.borraColor(id);
		return "Exito";
	}

}
