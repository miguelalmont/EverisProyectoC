package com.everis.proyectoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SoccerController {
	
	@Autowired
	SoccerServiceI soccerService;
	
	/**
	 * Escucha cualquier ruta y muestra la vista del índice.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping
	public String showIndex(Model model) {
		return "index";
	}
	/**
	 * Escucha la ruta "ranking" y muestra la clasificación de los equipos
	 * @param model
	 * @return String
	 */
	@GetMapping("/ranking")
	public String showRanking(Model model) {
		
		model.addAllAttributes("rankingTeams", soccerService.getRanking)
	}
	
	
}
