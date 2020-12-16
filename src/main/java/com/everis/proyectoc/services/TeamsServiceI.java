package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.proyectoc.repositories.Teams;

@Service
public interface TeamsServiceI {

	public void addTeam(final Teams team);

	public List<Teams> getAllTeams();

	public Teams getTeamByID(final int teamId);

	public void removeTeamByID(final int teamId);

	public void modifyTeam(final Teams team);

	public List<Teams> getTeamByName(final String teamName);

}
