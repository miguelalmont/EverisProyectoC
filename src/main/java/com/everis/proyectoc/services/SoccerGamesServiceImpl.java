package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.proyectoc.repositories.SoccerGames;
import com.everis.proyectoc.repositories.SoccerGamesRepositoryI;

@Service
public class SoccerGamesServiceImpl implements SoccerGamesServiceI {

	@Autowired
	SoccerGamesRepositoryI gamesRepository;

	@Override
	public void addGame(final SoccerGames game) {

		gamesRepository.save(game);
	}

	@Override
	public List<SoccerGames> getAllGames() {

		return gamesRepository.findAll();
	}

	@Override
	public SoccerGames getGameByID(final int gameId) {

		return gamesRepository.findSoccerGamesByGameId(gameId);
	}

	@Override
	public void removeGameByID(final int gameId) {

		SoccerGames game = new SoccerGames();
		game.setGameId(gameId);
		gamesRepository.delete(game);
	}

	@Override
	public void modifyGame(final SoccerGames game) {

		SoccerGames gameToUpdate = gamesRepository.findSoccerGamesByGameId(game.getGameId());
		if (gameToUpdate != null) {
			gameToUpdate.setLocal(game.getLocal());
			gameToUpdate.setVisitor(game.getVisitor());
			gameToUpdate.setLocalGoals(game.getLocalGoals());
			gameToUpdate.setVisitorGoals(game.getVisitorGoals());
			gamesRepository.save(gameToUpdate);
		}
	}
}
