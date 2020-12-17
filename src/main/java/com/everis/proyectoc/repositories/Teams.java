package com.everis.proyectoc.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "t_teams")
public class Teams implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Id del equipo */
	private int teamId;
	
	/** Nombre del equipo */
	private String name;
	
	/** Numero de victorias */
	private int victories;
	
	/** Numero de derrotas */
	private int defeats;
	
	/** Numero de empates */
	private int draw;
	
	/** Goles a favor */
	private int goalsFor;
	
	/** Goles en contra */
	private int goalsAgainst;
	
	/** Puntos */
	private int points;
	
	/** Lista de partidos como local */
	private List<SoccerGames> localGames;
	
	/** Lista de partidos como visitante */
	private List<SoccerGames> visitorGames;
	
	/**
	 * Constructor vacio
	 */
	public Teams() {
		super();
	}

	/**
	 * @return the teamId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "team_name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the wins
	 */
	@Column(name = "team_victories")
	public int getVictories() {
		return victories;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setVictories(int victories) {
		this.victories = victories;
	}

	/**
	 * @return the loose
	 */
	@Column(name = "team_defeats")
	public int getDefeats() {
		return defeats;
	}

	/**
	 * @param loose the loose to set
	 */
	public void setDefeats(int defeats) {
		this.defeats = defeats;
	}

	/**
	 * @return the draw
	 */
	@Column(name = "team_draws")
	public int getDraw() {
		return draw;
	}

	/**
	 * @param draw the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}

	/**
	 * @return the goalsFor
	 */
	@Column(name = "goals_for")
	public int getGoalsFor() {
		return goalsFor;
	}

	/**
	 * @param goalsFor the goalsFor to set
	 */
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	/**
	 * @return the goalsAgainst
	 */
	@Column(name = "goals_against")
	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	/**
	 * @param goalsAgainst the goalsAgainst to set
	 */
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	/**
	 * @return the games
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
	public List<SoccerGames> getLocalGames() {
		return localGames;
	}

	/**
	 * @param games the games to set
	 */
	public void setLocalGames(List<SoccerGames> localGames) {
		this.localGames = localGames;
	}

	/**
	 * @return the visitorGames
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "visitor")
	public List<SoccerGames> getVisitorGames() {
		return visitorGames;
	}

	/**
	 * @param visitorGames the visitorGames to set
	 */
	public void setVisitorGames(List<SoccerGames> visitorGames) {
		this.visitorGames = visitorGames;
	}

	/**
	 * @return the points
	 */
	@Column(name = "points")
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

}
