package com.everis.proyectoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SoccerGamesRepositoryI extends JpaRepository<SoccerGames, Integer> {
	
	/**
	 * Selecciona un juego por Id de la base de datos
	 * 
	 * @param gameId
	 * @return SoccerGames
	 */
	public SoccerGames findSoccerGamesByGameId(final int gameId);

}
