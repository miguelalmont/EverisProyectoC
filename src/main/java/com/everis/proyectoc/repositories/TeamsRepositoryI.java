package com.everis.proyectoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepositoryI extends JpaRepository<Teams, Integer> {

	/**
	 * Selecciona equipo por la Id de la base de datos
	 * 
	 * @param teamId
	 * @return Teams
	 */
	public Teams findTeamsByTeamId(final int teamId);

	/**
	 * Selecciona equipo por el nombre de la base de datos
	 * 
	 * @param teamName
	 * @return Teams
	 */
	public Teams findTeamsByName(final String teamName);

	/**
	 * Selecciona todos los equipos ordenados por puntos descendientemente
	 * 
	 * @return List<Teams>
	 */
	public List<Teams> findAllByOrderByPointsDesc();

}
