package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.proyectoc.repositories.Teams;

@Service
public interface TeamsServiceI {
	/**
	 * metodo para insertar un nuevo equipo
	 * @param team
	 */
	public void addTeam(final Teams team);
	
	/**
	 * metodo para mostrar todos los equipos
	 * @return List<Teams>
	 */
	public List<Teams> getAllTeams();
	
	/**
	 * metodo para buscar equipos por su ID
	 * @param teamId
	 * @return Teams
	 */
	public Teams getTeamByID(final int teamId);
	
	/**
	 * metodo para eliminar equipo por su ID
	 * @param teamId
	 */
	public void removeTeamByID(final int teamId);
	
	/**
	 * Metodo para modificar equipo
	 * @param team
	 */
	public void modifyTeam(final Teams team);
	
	/**
	 * Metodo para mostrar equipos por su nombre
	 * @param teamName
	 * @return Teams
	 */
	public Teams getTeamByName(final String teamName);
	
	/**
	 * Metodo para mostrar los equipos ordenados por los puntos conseguidos
	 * @return  List<Teams> 
	 */
	public List<Teams> getAllTeamsOrderByPoints();

}
