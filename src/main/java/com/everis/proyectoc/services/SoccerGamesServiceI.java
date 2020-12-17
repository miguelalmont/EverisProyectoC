package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.proyectoc.repositories.SoccerGames;

@Service
public interface SoccerGamesServiceI {
	/**
	 * Metodo para insertar nuevos partidos
	 * @param game
	 */
	public void addGame(final SoccerGames game);
	/**
	 * Metodo que devuelve todos los partidos
	 * @return List<SoccerGames>
	 */
	public List<SoccerGames> getAllGames();
	
	/**
	 * Método que busca partidos por su ID
	 * @param gameId
	 * @return SoccerGame
	 */
	public SoccerGames getGameByID(final int gameId);
	
	/**
	 * Metodo para eliminar partidos
	 * @param gameId
	 */
	public void removeGameByID(final int gameId);
	/**
	 * Metodo para modificar partidos
	 * @param game
	 */
	public void modifyGame(final SoccerGames game);

}
