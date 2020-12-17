package com.everis.proyectoc.repositories;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "t_games")
public class SoccerGames implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** ID del partido */
	private int gameId;
	
	/** Equipo local */
	private Teams local;
	
	/** Equipo visitante */
	private Teams visitor;
	
	/** Goles del equipo local */
	private int localGoals;
	
	/** Goles del equipo visitante */
	private int visitorGoals;

	/**
	 * Constructor vacio
	 */
	public SoccerGames() {
		super();
	}

	/**
	 * @return the gameId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	public int getGameId() {
		return gameId;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the local
	 */
	@ManyToOne
	@JoinColumn(name = "local_team")
	public Teams getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(Teams local) {
		this.local = local;
	}

	/**
	 * @return the visitor
	 */
	@ManyToOne
	@JoinColumn(name = "visitor_team")
	public Teams getVisitor() {
		return visitor;
	}

	/**
	 * @param visitor the visitor to set
	 */
	public void setVisitor(Teams visitor) {
		this.visitor = visitor;
	}

	/**
	 * @return the localGoals
	 */
	@Column(name = "local_goals")
	public int getLocalGoals() {
		return localGoals;
	}

	/**
	 * @param localGoals the localGoals to set
	 */
	public void setLocalGoals(int localGoals) {
		this.localGoals = localGoals;
	}

	/**
	 * @return the visitorGoals
	 */
	@Column(name = "visitor_goals")
	public int getVisitorGoals() {
		return visitorGoals;
	}

	/**
	 * @param visitorGoals the visitorGoals to set
	 */
	public void setVisitorGoals(int visitorGoals) {
		this.visitorGoals = visitorGoals;
	}

}
