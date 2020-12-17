package com.everis.proyectoc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.proyectoc.repositories.SoccerGames;
import com.everis.proyectoc.repositories.Teams;
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
		
		List<Teams> teams = teamsService.getAllTeamsOrderByPoints();

		model.addAttribute("ranking", teams);
		
		return "index";
	}

	@GetMapping("/insert-team-form")
	public String showInsertTeam(@ModelAttribute(value = "newTeam") Teams team) {
		return "insert-team-form";
	}

	/**
	 * Escucha la ruta "insert-team", añade el equipo y redirige a la pagina
	 * principal
	 * 
	 * @param team
	 * @param result
	 * @param model
	 * @return String
	 */
	@PostMapping("/insert-team")
	public String onSubmitInsert(@ModelAttribute(value = "newTeam") Teams team, BindingResult result, Model model) {

		if (null != result && result.hasErrors()) {

			return "insert-team-form";
		} else {
			try {
				teamsService.addTeam(team);
			} catch (Exception ex) {
//				return "error";
			}

			return "redirect:index";
		}

	}

	/**
	 * Elimina un equipo
	 * 
	 * @param teamId
	 * @return String
	 */
	@PostMapping("/actDropTeam")
	public String deleteTeam(@RequestParam int teamId, Model model) {

		// Eliminación de equipo.
		teamsService.removeTeamByID(teamId);

		return "redirect:index";
	}

	@GetMapping("/insert-match-form")
	public String showInsertMatch(@ModelAttribute(value = "newMatch") SoccerGames game, Model model) {
		
		List<Teams> teams = teamsService.getAllTeams();
		
		model.addAttribute("teams", teams);
		
		return "insert-match-form";
		
	}

	/**
	 * Escucha la ruta "insert-match", añade el equipo y redirige a la pagina
	 * ranking
	 * 
	 * @param match
	 * @param result
	 * @param model
	 * @return String
	 */
	@PostMapping("/insert-match")
	public String showInsertMatch(@ModelAttribute(value = "newMatch") SoccerGames game, BindingResult result,
			Model model) {

		if (null != result && result.hasErrors()) {
			System.out.println(result.toString());
			return "error";
			
		} else {

			try {
				game.setLocal(teamsService.getTeamByID(game.getLocal().getTeamId()));
				game.setVisitor(teamsService.getTeamByID(game.getVisitor().getTeamId()));
				soccerService.addGame(game);
			} catch (Exception ex) {
				ex.printStackTrace();
				return "error";
			}

			return "redirect:index";
		}

	}

}
