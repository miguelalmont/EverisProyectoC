package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.proyectoc.repositories.SoccerGames;
import com.everis.proyectoc.repositories.Teams;
import com.everis.proyectoc.repositories.TeamsRepositoryI;

public class TeamsServiceImpl implements TeamsServiceI {

	@Autowired
	TeamsRepositoryI teamsRepository;

	@Override
	public void addTeam(Teams team) {

		teamsRepository.save(team);
	}

	@Override
	public List<Teams> getAllTeams() {

		return teamsRepository.findAll();
	}

	@Override
	public Teams getTeamByID(int teamId) {

		return teamsRepository.findTeamsByTeamId(teamId);
	}

	@Override
	public void removeTeamByID(int teamId) {

		Teams team = new Teams();
		team.setTeamId(teamId);
		teamsRepository.delete(team);

	}

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

	@Override
	public List<Teams> getTeamByName(String teamName) {
		
		return teamsRepository.findTeamsByName(teamName);
	}

}
