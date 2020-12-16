package com.everis.proyectoc.controllers;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		return "index";
	}

	/**
	 * Escucha la ruta "ranking" y muestra la clasificación de los equipos
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/ranking")
	public String showRanking(Model model) {

		List<Teams> teamsList = teamsService.getAllTeams();
		LinkedHashMap<Integer, Teams> ranking = new LinkedHashMap<>(teamsList.size());

		for (Teams team : teamsList) {
			int points = 0;

			for (int i = 0; i < team.getVictories(); i++) {
				points += 3;
			}

			for (int i = 0; i < team.getDraw(); i++) {
				points += 1;
			}

			ranking.put(points, team);
		}

		LinkedHashMap<Integer, Teams> reverseSortedMap = new LinkedHashMap<>();
		ranking.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		model.addAttribute("ranking", reverseSortedMap);

		return "ranking";
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

			return "ranking";
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

		// Eliminación de vehículo.
		teamsService.removeTeamByID(teamId);

		return "redirect:ranking";
	}

	@GetMapping("/insert-match-form")
	public String showInsertMatch(@ModelAttribute(value = "newMatch") Teams team) {
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
	@GetMapping("/insert-match")
	public String showInsertMatch(@ModelAttribute(value = "newMatch") SoccerGames game, BindingResult result,
			Model model) {

		if (null != result && result.hasErrors()) {
			return "insert-match-form";

		} else {

			try {
				soccerService.addGame(game);
			} catch (Exception ex) {
//				return "error";
			}

			return "redirect:ranking";
		}

	}

}
