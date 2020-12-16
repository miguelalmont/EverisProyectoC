package com.everis.proyectoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.proyectoc.repositories.SoccerGames;
import com.everis.proyectoc.repositories.SoccerGamesRepositoryI;
import com.everis.proyectoc.repositories.Teams;

@Service
public class SoccerGamesServiceImpl implements SoccerGamesServiceI {

	@Autowired
	SoccerGamesRepositoryI gamesRepository;

	@Override
	public void addGame(final SoccerGames game) {
		
		Teams teamL = game.getLocal();
		Teams teamV = game.getVisitor();
		
		// Goles a favor
		teamL.setGoalsFor(teamL.getGoalsFor() + game.getLocalGoals());
		teamV.setGoalsFor(teamV.getGoalsFor() + game.getVisitorGoals());
		
		// Goles en contra
		teamL.setGoalsAgainst(teamL.getGoalsAgainst() + game.getVisitorGoals());
		teamV.setGoalsAgainst(teamV.getGoalsAgainst() + game.getLocalGoals());
		
		if (game.getLocalGoals() > game.getVisitorGoals()) {
			teamL.setVictories(teamL.getVictories() + 1);
			teamV.setDefeats(teamV.getDefeats() + 1);
		}
		else if (game.getLocalGoals() < game.getVisitorGoals()) {
			teamL.setDefeats(teamL.getDefeats() + 1);
			teamV.setVictories(teamV.getVictories() + 1);
		}
		else {
			teamL.setDraw(teamL.getDraw() + 1);
			teamV.setDraw(teamV.getDraw() + 1);
		}

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
