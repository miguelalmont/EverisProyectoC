package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.proyectoc.repositories.SoccerGames;

@Service
public interface SoccerGamesServiceI {

	public void addGame(final SoccerGames game);

	public List<SoccerGames> getAllGames();

	public SoccerGames getGameByID(final int gameId);

	public void removeGameByID(final int gameId);

	public void modifyGame(final SoccerGames game);

}
