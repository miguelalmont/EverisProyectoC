package com.everis.proyectoc.services;

import java.util.List;

import com.everis.proyectoc.repositories.SoccerGames;

public interface SoccerGamesServiceI {

	public void addGame(final SoccerGames game);

	public List<SoccerGames> getAllGames();

	public SoccerGames getGameByID(final int gameId);

	public void removeGameByID(final int gameId);

	public void modifyGame(final SoccerGames game);

}
