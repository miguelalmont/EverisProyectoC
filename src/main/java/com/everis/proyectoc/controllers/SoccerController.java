package com.everis.proyectoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.proyectoc.services.SoccerGamesServiceI;
import com.everis.proyectoc.services.TeamsServiceI;

@Controller
@RequestMapping("*")
public class SoccerController {
	
	@Autowired
	SoccerGamesServiceI soccerService;
	@Autowired
	TeamsServiceI teamsService;
	
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
		
		model.addAllAttributes("rankingTeams", teamsService.getRanking());
		
		return "ranking";
	}
	
	@GetMapping("/insert-team")
	public String showInsertTeam(@ModelAttribute(value="newTeam") Teams team, BindingResult result, Model model) {
		
		if (null != result && result.hasErrors()) {
            return "insert-team-form";
            
		} else {
			
			try {
				teamsService.addTeam(team);
			}catch(Exception ex) {
				return "error";
			}
			
			return "index";
		}
		
	}
	
}
