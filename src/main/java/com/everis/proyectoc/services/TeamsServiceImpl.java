package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.proyectoc.repositories.Teams;
import com.everis.proyectoc.repositories.TeamsRepositoryI;

@Service
public class TeamsServiceImpl implements TeamsServiceI {

	@Autowired
	TeamsRepositoryI teamsRepository;
	
	/**
	 * metodo para insertar un nuevo equipo
	 * @param team
	 */
	@Override
	public void addTeam(Teams team) {

		teamsRepository.save(team);
	}
	
	/**
	 * metodo para mostrar todos los equipos
	 * @return List<Teams>
	 */
	@Override
	public List<Teams> getAllTeams() {

		return teamsRepository.findAll();
	}

	/**
	 * metodo para buscar equipos por su ID
	 * @param teamId
	 * @return Teams
	 */
	@Override
	public Teams getTeamByID(int teamId) {

		return teamsRepository.findTeamsByTeamId(teamId);
	}

	/**
	 * metodo para eliminar equipo por su ID
	 * @param teamId
	 */
	@Override
	public void removeTeamByID(int teamId) {

		Teams team = new Teams();
		team.setTeamId(teamId);
		teamsRepository.delete(team);

	}

	/**
	 * Metodo para modificar equipo
	 * @param team
	 */
	@Override
	public void modifyTeam(Teams team) {

		Teams teamToUpdate = teamsRepository.findTeamsByTeamId(team.getTeamId());
		if (teamToUpdate != null) {
			teamToUpdate.setName(team.getName());
			teamToUpdate.setVictories(team.getVictories());
			teamToUpdate.setDefeats(team.getDefeats());
			teamToUpdate.setDraw(team.getDraw());
			teamToUpdate.setGoalsFor(team.getGoalsFor());
			teamToUpdate.setGoalsAgainst(team.getGoalsAgainst());
			teamsRepository.save(teamToUpdate);
		}

	}
	
	/**
	 * Metodo para mostrar equipos por su nombre
	 * @param teamName
	 * @return Teams
	 */
	@Override
	public Teams getTeamByName(String teamName) {

		return teamsRepository.findTeamsByName(teamName);
	}

	/**
	 * Metodo para mostrar los equipos ordenados por los puntos conseguidos
	 * @return  List<Teams> 
	 */
	@Override
	public List<Teams> getAllTeamsOrderByPoints() {

		return teamsRepository.findAllByOrderByPointsDesc();
	}

}
