package com.everis.proyectoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SoccerGamesRepositoryI extends JpaRepository<SoccerGames, Integer> {
	
	public SoccerGames findSoccerGamesByGameId(final int gameId);

}
